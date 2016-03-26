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

    public String generateHeaders(){
        String headerString = "";
        headerString.concat(fileName+"//"+fileType+"//");
        if(doesOwnerIDExist()){
            headerString.concat(OwnerID);
        }
        else{
            headerString.concat("NO OWN");
        }
        headerString.concat("||");
        return headerString;
    }

}
