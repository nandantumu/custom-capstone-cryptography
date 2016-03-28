package com.nt.cryptotool.utils;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * This class splits files into pieces that fit into SBoxes. In future versions, this would also scramble the order of the pieces.
 * Created by Nandan on 3/27/2016.
 */
public class PBox {
    /**
     * This method returns a List of BitSets.
     * @param bitsContents BitSet to split into smaller pieces.
     * @return List of all the contents of bitsContents, split up into smaller BitSets of length 4.
     */
    public static List<BitSet> split(BitSet bitsContents) {
        List<BitSet> returnArray = new ArrayList<BitSet>(bitsContents.toByteArray().length*2);
        for (int i = 0; i < bitsContents.toByteArray().length*2 ; i++) {
            returnArray.add(bitsContents.get(i*4,((4*i)+3)));
        }
        return returnArray;
    }

    public static BitSet combine(List<BitSet> shredded) {
        BitSet combined = new BitSet(shredded.size()*4);
        for (int i = 0; i < shredded.size() ; i++) {
            for (int j = 0; j < 4; j++) {
                combined.set(i*4+j,shredded.get(i).get(j));
            }
        }
        return combined;
    }

}
