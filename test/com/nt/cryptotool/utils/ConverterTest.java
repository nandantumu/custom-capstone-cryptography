package com.nt.cryptotool.utils;

import java.util.BitSet;

import static org.junit.Assert.*;

/**
 * Created by Nandan on 3/21/2016.
 */
public class ConverterTest {

    Converter converter = new com.nt.cryptotool.utils.Converter();

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void bitsFromRandom() throws Exception {

    }

    @org.junit.Test
    public void byteToBits() throws Exception {
        byte[] input = new byte[]{(byte) 0b1011_1011};
        BitSet expectedOutput = new BitSet(8);
        expectedOutput = BitSet.valueOf(new byte[]{(byte)0b1011_1011});
        assertEquals(expectedOutput,converter.byteToBits(input));
    }

    @org.junit.Test
    public void stringToBigInt() throws Exception {

    }
}