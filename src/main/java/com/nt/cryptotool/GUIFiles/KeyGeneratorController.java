/**
 * Sample Skeleton for 'KeyGeneratorScreen.fxml' Controller Class
 */

package com.nt.cryptotool.GUIFiles;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nt.cryptotool.miscobjects.PasswordNotFoundException;
import com.nt.cryptotool.utils.KeyGenerator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;

public class KeyGeneratorController {

    private File theChosenFile;
    private String password;

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

    @FXML // fx:id="BottomMessage"
    private Label BottomMessage; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert BorderPane != null : "fx:id=\"BorderPane\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert GenerateKeyButton != null : "fx:id=\"GenerateKeyButton\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert KeyGenLabel != null : "fx:id=\"KeyGenLabel\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert TargetDirLabel != null : "fx:id=\"TargetDirLabel\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert selectTargetDirectoryButton != null : "fx:id=\"selectTargetDirectoryButton\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert EnterPasswordLabel != null : "fx:id=\"EnterPasswordLabel\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert PasswordField != null : "fx:id=\"PasswordField\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";
        assert BottomMessage != null : "fx:id=\"BottomMessage\" was not injected: check your FXML file 'KeyGeneratorScreen.fxml'.";

        selectTargetDirectoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("Choose directory to place Keyfile in");
                try{
                    theChosenFile = directoryChooser.showDialog(BorderPane.getScene().getWindow());
                }
                catch (Exception e){
                    Logger.getGlobal().log(Level.WARNING,"The user exited the filechooser without selecting a file");
                }
                if(!theChosenFile.isDirectory()){
                    BottomMessage.setText("Please select a directory.");
                    BottomMessage.setTextFill(Color.RED);
                }
                else{
                    BottomMessage.setText("Your Keyfile will be saved as Keyfile.secure");
                    BottomMessage.setTextFill(Color.WHITE);
                }
            }
        });

        GenerateKeyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                password = PasswordField.getText().trim();
                KeyGenerator keyGenerator = new KeyGenerator();
                try {
                    keyGenerator.generateKey(theChosenFile,password);
                    BottomMessage.setText("Your Keyfile will be saved as Keyfile.secure");
                    BottomMessage.setTextFill(Color.WHITE);
                } catch (Exception e) {
                    e.printStackTrace();
                    BottomMessage.setText("No Password Found");
                    BottomMessage.setTextFill(Color.RED);
                }
            }
        });
    }
}
