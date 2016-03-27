package com.nt.cryptotool.utils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Created by Nandan on 3/27/2016.
 */
public class PBox {
    public static List<BitSet> split(BitSet bitsContents) {
        List<BitSet> returnArray = new ArrayList<BitSet>(bitsContents.length()/4);
        for (int i = 0; i < bitsContents.length()/4 ; i++) {
            returnArray.add(bitsContents.get(i*4,((4*i)+3)));
        }
        return returnArray;
    }
}
