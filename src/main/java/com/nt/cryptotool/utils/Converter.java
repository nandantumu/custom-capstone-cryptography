package com.nt.cryptotool.utils;

import java.math.BigInteger;
import java.util.BitSet;

import static java.util.BitSet.valueOf;

/**
 * Created by Nandan on 3/11/2016.
 */
public class Converter {
    public Converter(){

    }

    public BitSet byteToBits(byte[] bytearray){
        BitSet returnValue = new BitSet();
        //noinspection Since15
        returnValue = BitSet.valueOf(bytearray);
        return returnValue;
    }

    public BigInteger stringToBigInt(String input){
        BigInteger output = new BigInteger(input,2);
        return output;
    }


}
