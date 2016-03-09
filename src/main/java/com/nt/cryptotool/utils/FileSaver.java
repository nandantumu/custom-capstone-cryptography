package com.nt.cryptotool.utils;

/**
 * Created by Nandan on 3/7/2016.
 */
public class FileSaver {

    private String fileName,fileType,OwnerID;

    FileSaver(String fileName, String fileType, String ownerID){

    }

    FileSaver(String fileName, String fileType){

    }

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
