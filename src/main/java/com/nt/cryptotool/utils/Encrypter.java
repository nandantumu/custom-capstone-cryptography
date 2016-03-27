package com.nt.cryptotool.utils;

import com.nt.cryptotool.objects.Key;
import com.nt.cryptotool.objects.TargetFile;
import com.nt.cryptotool.utils.PBox;

import java.io.IOException;
import java.util.BitSet;
import java.util.List;

/**This class manages the Encryption process.
 * Created by Nandan on 3/26/2016.
 */
public class Encrypter {
    private TargetFile targetFile;
    private Key key;

    /**
     * Constructor method to generate new Encrypter object.
     * @param targetFile file that must be encrypted
     * @param key key object to be used to encrypt the file
     */
    public Encrypter(TargetFile targetFile,Key key){
        this.key=key;
        this.targetFile=targetFile;
    }

    public void encryptFile(){
        try {
            List<BitSet> file = PBox.split(targetFile.getBitsContents());
            for(BitSet b:file){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
