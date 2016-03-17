package com.nt.cryptotool.utils;

import java.math.BigInteger;

/**
 * Created by Nandan on 3/11/2016.
 */
public class Converter {
    Converter(){

    }

    public BigInteger stringToBigInt(String input){
        BigInteger output = new BigInteger(input,2);
        return output;
    }


}
