package test.com.nt.cryptotool.utils;

import com.nt.cryptotool.utils.Converter;
import org.junit.Test;

import java.nio.ByteBuffer;
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
        assertEquals(ByteBuffer.wrap(expectedOutput.toByteArray()), ByteBuffer.wrap(input));
    }

    @Test
    public void testBytestoBitslength() throws Exception {
        byte[] input = new byte[]{(byte) 0xFFFF,(byte)0x7F70,(byte)0xF45A,(byte)0xA24B};
        BitSet output = converter.byteToBits(input);
        System.out.println("byte[] length: "+input.length+ "x8: "+input.length*8);
        System.out.println("BitSet length: "+output.length());
        System.out.println(input);
        System.out.println(output.toByteArray());
        assertTrue(output.length()==input.length*8);
    }

    @Test
    public void curiosity() throws Exception {
        byte[] byteArray = new byte[]{(byte) 0xFFFF,(byte)0x7F70,(byte)0xF45A,(byte)0xA24B};
        BitSet bitSet = BitSet.valueOf(byteArray);
        System.out.println("byte[]: "+byteArray);
        System.out.println("BitSet: "+bitSet.toByteArray());
        assertEquals(ByteBuffer.wrap(byteArray),ByteBuffer.wrap(bitSet.toByteArray()));
        //assertEquals(bitSet.length(),byteArray.length*8);
    }

    @org.junit.Test
    public void stringToBigInt() throws Exception {

    }
}