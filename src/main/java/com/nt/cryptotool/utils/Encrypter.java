package com.nt.cryptotool.utils;

import com.nt.cryptotool.miscobjects.BitSetLengthException;
import com.nt.cryptotool.objects.Key;
import com.nt.cryptotool.objects.TargetFile;
import com.nt.cryptotool.utils.PBox;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.List;

/**This class manages the Encryption process.
 * Created by Nandan on 3/26/2016.
 */
public class Encrypter {
    private TargetFile targetFile;
    private Key key;
    private SBox sBox;

    /**
     * Constructor method to generate new Encrypter object.
     * @param targetFile file that must be encrypted
     * @param key key object to be used to encrypt the file
     */
    public Encrypter(TargetFile targetFile,Key key){
        this.key=key;
        this.targetFile=targetFile;
        this.sBox = new SBox(key.getSBoxKeys());
    }

    /**
     * Calling this method will encrypt the file, and save its contents to the specified {@link TargetFile}
     */
    public void encryptFile(){
        try {
            List<BitSet> file = PBox.split(targetFile.getBitsContents());
            for(BitSet b:file){
                sBox.encrypt(b);
            }
            FileUtils.writeByteArrayToFile(targetFile.getTargetFile(), PBox.combine(file).toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
