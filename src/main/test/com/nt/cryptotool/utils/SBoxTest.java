package test.com.nt.cryptotool.utils;

import com.nt.cryptotool.utils.SBox;
import org.junit.Test;

import java.nio.LongBuffer;
import java.util.BitSet;

import static org.junit.Assert.*;


/**
 * Created by Nandan on 3/27/2016.
 */
public class SBoxTest {
    @Test
    public void bitSetEquals() throws Exception {
        BitSet b1,b2;
        b1 = new BitSet(4);
        b1.set(1);
        b2 = new BitSet(4);
        b2.set(1);
        for (int i = 0; i < 4; i++) {
            System.out.print(b1.get(i));
        }
        System.out.print("\n");
        for (int i = 0; i < b2.length(); i++) {
            System.out.print(b2.get(i));
        }
        assertTrue(b1.equals(b2));
    }

    @Test
    public void returnBits() throws Exception {
        BitSet b1,b2;
        b1 = new BitSet(4);
        b1.set(1);
        b2 = SBox.getBitSet("0100");
        for (int i = 0; i < 4; i++) {
            System.out.print(b1.get(i));
        }
        System.out.print("\n");
        for (int i = 0; i < b2.length(); i++) {
            System.out.print(b2.get(i));
        }
        assertTrue(b1.equals(b2));
    }
}
