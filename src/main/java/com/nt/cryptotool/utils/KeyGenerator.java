package com.nt.cryptotool.utils;

import com.nt.cryptotool.errors.PasswordNotFoundException;
import com.nt.cryptotool.objects.Key;

import java.math.BigInteger;

/**
 * Created by Nandan on 3/11/2016.
 */
public class KeyGenerator {
    private String password;
    private BigInteger randomkey;

    public KeyGenerator(String password){
        this.password = password;
    }

    public Key generateKey() throws PasswordNotFoundException{
        if(password==null){
            throw new PasswordNotFoundException("No Password Found");
        }
        Key theKey = new Key(password);
        return  theKey;

    }

}
