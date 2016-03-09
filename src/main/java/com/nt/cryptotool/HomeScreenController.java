package com.nt.cryptotool;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sun.applet.Main;

public class HomeScreenController
{


    @FXML private Button keyGenButton;
    @FXML private Button decryptButton;
    @FXML private Button encryptButton;
    private MainApp main;

    HomeScreenController(MainApp main){
        this.main = main;
    }

    public void onClickEncryptButton(){
        try {
            main.changeView("EncryptScreen.fxml");
        }
        catch (Exception e){

        }
    }
}
