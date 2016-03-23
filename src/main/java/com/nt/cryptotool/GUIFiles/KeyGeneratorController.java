/**
 * Sample Skeleton for 'KeyGeneratorScreen.fxml' Controller Class
 */

package com.nt.cryptotool.GUIFiles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class KeyGeneratorController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="BorderPane"
    private BorderPane BorderPane; // Value injected by FXMLLoader

    @FXML // fx:id="GenerateKeyButton"
    private Button GenerateKeyButton; // Value injected by FXMLLoader

    @FXML // fx:id="KeyGenLabel"
    private Label KeyGenLabel; // Value injected by FXMLLoader

    @FXML // fx:id="TargetDirLabel"
    private Label TargetDirLabel; // Value injected by FXMLLoader

    @FXML // fx:id="selectTargetDirectoryButton"
    private Button selectTargetDirectoryButton; // Value injected by FXMLLoader

    @FXML // fx:id="EnterPasswordLabel"
    private Label EnterPasswordLabel; // Value injected by FXMLLoader

    @FXML // fx:id="PasswordField"
    private TextField PasswordField; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert BorderPane != null : "fx:id=\"BorderPane\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert GenerateKeyButton != null : "fx:id=\"GenerateKeyButton\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert KeyGenLabel != null : "fx:id=\"KeyGenLabel\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert TargetDirLabel != null : "fx:id=\"TargetDirLabel\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert selectTargetDirectoryButton != null : "fx:id=\"selectTargetDirectoryButton\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert EnterPasswordLabel != null : "fx:id=\"EnterPasswordLabel\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert PasswordField != null : "fx:id=\"PasswordField\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";

    }
}
