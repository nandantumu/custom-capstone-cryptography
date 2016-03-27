package com.nt.cryptotool.utils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/** This class splits files into pieces that fit into SBoxes. In future versions, this would also scramble the order of the pieces.
 * Created by Nandan on 3/27/2016.
 */
public class PBox {
    /**
     *  This method returns a List of BitSets.
     * @param bitsContents BitSet to split into smaller pieces.
     * @return List of all the contents of bitsContents, split up into smaller BitSets of length 4.
     */
    public static List<BitSet> split(BitSet bitsContents) {
        List<BitSet> returnArray = new ArrayList<BitSet>(bitsContents.length()/4);
        for (int i = 0; i < bitsContents.length()/4 ; i++) {
            returnArray.add(bitsContents.get(i*4,((4*i)+3)));
        }
        return returnArray;
    }
}
