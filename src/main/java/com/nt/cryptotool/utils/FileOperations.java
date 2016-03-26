package com.nt.cryptotool.utils;

/**This class is designed to format and export encrypted files, so that their names and extensions can be restored.
 * Created by Nandan on 3/7/2016.
 */
public class FileOperations {

    private String fileName,fileType,OwnerID;

    public FileOperations(){
        //Empty constructor
    }

    @Deprecated
    private boolean doesOwnerIDExist(){
        if(OwnerID!=null)return true;
        else return false;
    }

    /**
     * This method generates headers for the file to be generated from an encryption.
     * <b>File headers are unimplemented in Version 1.0</b>
     * @return String to be prepended to the file that results from the program
     */
    public String generateHeaders(){
        String headerString = "";
        headerString.concat(fileName+"//"+fileType);
        headerString.concat("||");
        return headerString;
    }

}
