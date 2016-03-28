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

    /**
     * Creates a new SBox object, using the 64Bit key provided
     * @param sBoxKey portion of Key from {@link Key#getSBoxKeys()}
     */
    public SBox(BitSet sBoxKey) throws BitSetLengthException{
        //Reject keys of incorrect length
        if(sBoxKey.length()!=64)throw new BitSetLengthException("SBox key was: "+sBoxKey.length()+" not 64");
        for (int i = 0; i < 16 ; i++) {
            keys.add(sBoxKey.get(i*4,((4*i)+3)));
        }
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

    public BitSet encrypt(BitSet unencrypted){
        BitSet forUseInMethod = (BitSet)unencrypted.clone();
        forUseInMethod.xor(getKey(unencrypted));
        return forUseInMethod;
    }
}
