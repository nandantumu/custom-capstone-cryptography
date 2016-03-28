package com.nt.cryptotool.objects;


import java.io.*;
import java.util.BitSet;

import com.nt.cryptotool.miscobjects.Task;
import com.nt.cryptotool.utils.Converter;
import org.apache.commons.io.IOExceptionWithCause;
import org.apache.commons.io.IOUtils;

/**This class represents the file to be
 * Created by Nandan on 3/21/2016.
 */
public class TargetFile {

    private File sourceFile;
    private File targetFile;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private byte[] sourceContentsBytes;
    private BitSet sourceContentsBits;
    private Converter converter = new Converter();

    public TargetFile(String url, Task task) throws FileNotFoundException{
        if(task==Task.Encrypt) {
            sourceFile = new File(url);
            targetFile = new File(url.substring(0, url.indexOf(sourceFile.getName())).concat("EncryptedFile.secure"));
        }
        else if(task == Task.Decrypt){
            sourceFile = new File(url);
            targetFile = new File(url.substring(0, url.indexOf(sourceFile.getName())).concat("DecryptedFile.secure"));
        }
        fileInputStream = new FileInputStream(sourceFile);
        fileOutputStream = new FileOutputStream(targetFile);
        targetFile.mkdirs();
        try {
            sourceContentsBytes = IOUtils.toByteArray(fileInputStream);
            sourceContentsBits = converter.byteToBits(IOUtils.toByteArray(fileInputStream));
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] getBytesContents() throws IOException {
        return sourceContentsBytes;
    }

    public BitSet getBitsContents() throws IOException{
        return sourceContentsBits;
    }

    public int getFileSize(){
        return (int)sourceFile.length();
    }

    public String getFileName(){
        return sourceFile.getName();
    }

    public FileOutputStream getFileOutputStream(){
        return fileOutputStream;
    }

    public File getTargetFile(){
        return targetFile;
    }
    public File getSourceFile() {
        return sourceFile;
    }

}
