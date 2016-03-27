package com.nt.cryptotool.miscobjects;

/**
 * Created by Nandan on 3/11/2016.
 */
public class PasswordNotFoundException extends Exception{
    public PasswordNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "The password field is unset in the KeyGeneratorClass";
    }
}
