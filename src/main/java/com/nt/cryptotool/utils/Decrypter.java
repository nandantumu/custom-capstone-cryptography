package com.nt.cryptotool.utils;

import com.nt.cryptotool.objects.Key;
import com.nt.cryptotool.objects.TargetFile;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.BitSet;
import java.util.List;

/**This class manages the Encryption process.
 * Created by Nandan on 3/26/2016.
 */
public class Decrypter {
    private TargetFile targetFile;
    private Key key;
    private SBox sBox;
    private SecureRandom secureRandom;
    private byte[] resultant;

    /**
     * Constructor method to generate new Decrypter object.
     * @param targetFile file that must be decrypted
     * @param key key object to be used to encrypt the file
     */
    public Decrypter(TargetFile targetFile, Key key){
        this.key=key;
        this.targetFile=targetFile;
        this.sBox = new SBox(key.getSBoxKeys());
    }

    /**
     * Calling this method will decrypt the file, and save its contents to the specified {@link TargetFile}
     */
    public void decryptFile() throws IOException{
        //Whitening
        secureRandom = new SecureRandom();
        secureRandom.setSeed(key.getLastWhiteningKey().toByteArray());
        BitSet fileBits = targetFile.getBitsContents();
        fileBits.xor(Converter.bitsFromRandom(secureRandom,fileBits.size()));
        //SBoxing
        //List<BitSet> fileBitsSplit = PBox.split(targetFile.getBitsContents());
        /*
        for(BitSet b:fileBitsSplit){
            sBox.encrypt(b);
        }*/
        //BitSet finalBits = PBox.combine(fileBitsSplit);
        //Whitening
        secureRandom.setSeed(key.getFirstWhiteningKey().toByteArray());
        fileBits.xor(Converter.bitsFromRandom(secureRandom,fileBits.size()));
        resultant = fileBits.toByteArray();
        //Saving
        FileUtils.writeByteArrayToFile(targetFile.getTargetFile(), fileBits.toByteArray());

    }

    public byte[] getResultant() {
        return resultant;
    }
}
