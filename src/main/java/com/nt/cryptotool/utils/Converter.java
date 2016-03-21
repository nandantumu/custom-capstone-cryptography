package com.nt.cryptotool.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.BitSet;

import static java.util.BitSet.valueOf;

/**
 * Created by Nandan on 3/11/2016.
 */
public class Converter {
    public Converter(){

    }

    /**
     * Returns a BitSet of specified length using the provided SecureRandom object.
     * @param secureRandom provided SecureRandom object
     * @param bitSetLength length of BitSet to be provided
     * @return BitSet of randomized nature.
     */
    public BitSet bitsFromRandom(SecureRandom secureRandom, int bitSetLength){
        BitSet randomBits = new BitSet(bitSetLength);
        for(int index = 0;index<bitSetLength;index++){
            randomBits.set(index, secureRandom.nextBoolean());
        }
        return randomBits;
    }

    /**
     * Converts byte array into BitSet. Does not work on JRE version below 7.
     * @param bytearray Byte[] to be converted
     * @return BitSet based on Byte[]
     */

    public BitSet byteToBits(byte[] bytearray){
        BitSet returnValue;
        //noinspection Since15
        returnValue = BitSet.valueOf(bytearray);
        return returnValue;
    }

    /**
     * Turns input string into a BigInteger.
     * @param input String to be converted
     * @return BigInteger output
     */
    public BigInteger stringToBigInt(String input){
        BigInteger output = new BigInteger(input,2);
        return output;
    }


}
