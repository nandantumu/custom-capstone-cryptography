package com.nt.cryptotool.GUIFiles;

import com.nt.cryptotool.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HomeScreenController extends BorderPane
{


    @FXML private Button keyGenButton;
    @FXML private Button decryptButton;
    @FXML private Button encryptButton;
    private MainApp main;

    HomeScreenController(MainApp main){
        this.main = main;
    }

    HomeScreenController(){

    }

    public void onClickEncryptButton(){
        try {
            main.changeView("EncryptScreen.fxml");
        }
        catch (Exception e){

        }
    }
}
