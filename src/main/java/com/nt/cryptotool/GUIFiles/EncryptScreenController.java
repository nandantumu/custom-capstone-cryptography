/**
 * Sample Skeleton for 'EncryptScreen.fxml' Controller Class
 */

package com.nt.cryptotool.GUIFiles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EncryptScreenController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="encryptButton"
    private Button encryptButton; // Value injected by FXMLLoader

    @FXML // fx:id="encryptTitleText"
    private Label encryptTitleText; // Value injected by FXMLLoader

    @FXML // fx:id="selectKeyFileButton"
    private Button selectKeyFileButton; // Value injected by FXMLLoader

    @FXML // fx:id="selectTargetFileButton"
    private Button selectTargetFileButton; // Value injected by FXMLLoader

    @FXML // fx:id="passwordTextField"
    private TextField passwordTextField; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert encryptButton != null : "fx:id=\"encryptButton\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert encryptTitleText != null : "fx:id=\"encryptTitleText\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert selectKeyFileButton != null : "fx:id=\"selectKeyFileButton\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert selectTargetFileButton != null : "fx:id=\"selectTargetFileButton\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'EncryptScreen.fxml'.";

    }
}
