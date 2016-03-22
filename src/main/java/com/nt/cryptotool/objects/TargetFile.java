package com.nt.cryptotool.objects;


import java.io.*;

import org.apache.commons.io.IOUtils;

/**
 * Created by Nandan on 3/21/2016.
 */
public class TargetFile {
    private File sourceFile;
    private File targetFile;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public TargetFile(String url) throws FileNotFoundException{
        sourceFile = new File(url);
        targetFile = new File(url.substring(0,url.indexOf(sourceFile.getName())).concat("EncryptedFile.secure"));
        fileInputStream = new FileInputStream(sourceFile);
        fileOutputStream = new FileOutputStream(targetFile);
        targetFile.mkdirs();
    }

    public byte[] getContents() throws IOException {
        return IOUtils.toByteArray(fileInputStream);
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


}
