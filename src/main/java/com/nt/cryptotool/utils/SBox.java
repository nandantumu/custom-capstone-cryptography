package com.nt.cryptotool.utils;

import com.nt.cryptotool.miscobjects.BitSetLengthException;
import com.nt.cryptotool.objects.Key;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * This utility takes a BitSet sBox key of length 64Bits and turns it into an SBox definition.
 * Created by Nandan on 3/27/2016.
 */
public class SBox {

    private List<BitSet> keys = new ArrayList<BitSet>(16);

    private int k0000 = 0;
    private int k1000 = 1;
    private int k0100 = 2;
    private int k0010 = 3;
    private int k0001 = 4;
    private int k1100 = 5;
    private int k1010 = 6;
    private int k1001 = 7;
    private int k0110 = 8;
    private int k0101 = 9;
    private int k0011 = 10;
    private int k1110 = 11;
    private int k1101 = 12;
    private int k1011 = 13;
    private int k0111 = 14;
    private int k1111 = 15;
    private String k0   =     "0000";
    private String k1   =     "1000";
    private String k2   =     "0100";
    private String k3   =     "0010";
    private String k4   =     "0001";
    private String k5   =     "1100";
    private String k6   =     "1010";
    private String k7   =     "1001";
    private String k8   =     "0110";
    private String k9   =     "0101";
    private String k10  =     "0011";
    private String k11  =     "1110";
    private String k12  =     "1101";
    private String k13  =     "1011";
    private String k14  =     "0111";
    private String k15  =     "1111";

    /**
     * Creates a new SBox object, using the 64Bit key provided
     * @param sBoxKey portion of Key from {@link Key#getSBoxKeys()}
     */
    public SBox(BitSet sBoxKey) {
        //Reject keys of incorrect length
        //if(sBoxKey.length()!=64)throw new BitSetLengthException("SBox key was: "+sBoxKey.length()+" not 64");
        //Use bits 7-10 to define a start point in the progression of keys.
        byte[] byteArray = sBoxKey.toByteArray();
        int seed = (int)byteArray[1];
        seed = seed%16;
        for(int i = seed; i<16; i++){
            keys.add(getKeyfromConstant(i));
        }
        if(seed != 0){
            for (int i = 0; i < seed; i++) {
                keys.add(getKeyfromConstant(i));
            }
        }
    }

    private BitSet getKeyfromConstant(int k){
        BitSet returnSet;
        switch (k){
            case 0:
                returnSet = getBitSet(k0);
                break;
            case 1:
                returnSet = getBitSet(k1);
                break;
            case 2:
                returnSet = getBitSet(k2);
                break;
            case 3:
                returnSet = getBitSet(k3);
                break;
            case 4:
                returnSet = getBitSet(k4);
                break;
            case 5:
                returnSet = getBitSet(k5);
                break;
            case 6:
                returnSet = getBitSet(k6);
                break;
            case 7:
                returnSet = getBitSet(k7);
                break;
            case 8:
                returnSet = getBitSet(k8);
                break;
            case 9:
                returnSet = getBitSet(k9);
                break;
            case 10:
                returnSet = getBitSet(k10);
                break;
            case 11:
                returnSet = getBitSet(k11);
                break;
            case 12:
                returnSet = getBitSet(k12);
                break;
            case 13:
                returnSet = getBitSet(k13);
                break;
            case 14:
                returnSet = getBitSet(k14);
                break;
            case 15:
                returnSet = getBitSet(k15);
                break;
            default:
                returnSet = new BitSet(4);
                break;
        }
        return returnSet;
    }

    private BitSet getKey(BitSet match){
        if(match.equals(getBitSet("0000")))return keys.get(0);
        else if(match.equals(getBitSet("1000")))return keys.get(1);
        else if(match.equals(getBitSet("0100")))return keys.get(2);
        else if(match.equals(getBitSet("0010")))return keys.get(3);
        else if(match.equals(getBitSet("0001")))return keys.get(4);
        else if(match.equals(getBitSet("1100")))return keys.get(5);
        else if(match.equals(getBitSet("1010")))return keys.get(6);
        else if(match.equals(getBitSet("1001")))return keys.get(7);
        else if(match.equals(getBitSet("0110")))return keys.get(8);
        else if(match.equals(getBitSet("0101")))return keys.get(9);
        else if(match.equals(getBitSet("0011")))return keys.get(10);
        else if(match.equals(getBitSet("1110")))return keys.get(11);
        else if(match.equals(getBitSet("1101")))return keys.get(12);
        else if(match.equals(getBitSet("1011")))return keys.get(13);
        else if(match.equals(getBitSet("0111")))return keys.get(14);
        else if(match.equals(getBitSet("1111")))return keys.get(15);
        return new BitSet(4);//This case should never occur.
    }

    public static BitSet getBitSet(String bits){
        bits = bits.trim();
        BitSet returnSet = new BitSet(bits.length());
        for (int i = 0; i < bits.length(); i++) {
            if(bits.charAt(i)=='1'){
                returnSet.set(i);
            }
        }
        return returnSet;
    }

    /**
     * This method mutates the given BitSet by XORing it with its key. No new object is created.
     * @param unencrypted
     */
    public void encrypt(BitSet unencrypted){
        unencrypted.xor(getKey(unencrypted));
    }
}
