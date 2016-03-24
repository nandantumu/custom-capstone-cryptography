package com.nt.cryptotool.utils;

import com.nt.cryptotool.errors.PasswordNotFoundException;
import com.nt.cryptotool.objects.Key;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Nandan on 3/11/2016.
 */
public class KeyGenerator {
    public void generateKey(File userChosenDirectory, String password) throws PasswordNotFoundException{
        Key theKey = new Key(password);
        try {
            System.out.println(userChosenDirectory.getPath());
            FileUtils.writeByteArrayToFile(new File(userChosenDirectory.getPath().concat("/Keyfile.secure")),theKey.getBitsToSave().toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
