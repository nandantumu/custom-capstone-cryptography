package test.com.nt.cryptotool.utils;

import com.nt.cryptotool.utils.PBox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nandan on 3/28/2016.
 */
public class PBoxTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFlow() throws Exception {
        BitSet input = BitSet.valueOf(new byte[]{(byte)0b00101101, (byte) 0b10111011,(byte)0b01101001});
        List<BitSet> shredded = PBox.split(input);
        for (int i = 0; i < input.toByteArray().length*8; i++) {
            System.out.print(input.get(i)+"|");
        }
        System.out.print("\n");
        for (int i = 0; i < shredded.size() ; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(shredded.get(i).get(j)+"|");
            }
        }
        assertTrue(PBox.combine(shredded).equals(input));
    }
}