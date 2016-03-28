/**
 * Sample Skeleton for 'EncryptScreen.fxml' Controller Class
 */

package com.nt.cryptotool.GUIFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import com.nt.cryptotool.miscobjects.Task;
import com.nt.cryptotool.objects.Key;
import com.nt.cryptotool.objects.TargetFile;
import com.nt.cryptotool.utils.Encrypter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import javax.security.auth.kerberos.KerberosTicket;

public class EncryptScreenController {

    private File keyfile,targetFile;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="rootPane"
    private BorderPane rootPane; // Value injected by FXMLLoader

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
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert encryptButton != null : "fx:id=\"encryptButton\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert encryptTitleText != null : "fx:id=\"encryptTitleText\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert selectKeyFileButton != null : "fx:id=\"selectKeyFileButton\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert selectTargetFileButton != null : "fx:id=\"selectTargetFileButton\" was not injected: check your FXML file 'EncryptScreen.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'EncryptScreen.fxml'.";

        selectKeyFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose Keyfile");
                keyfile = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
            }
        });

        selectTargetFileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose Target File");
                targetFile = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
            }
        });

        encryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    TargetFile targetFile1 = new TargetFile(targetFile.getAbsolutePath(), Task.Encrypt);
                    Key theKey = new Key(keyfile,passwordTextField.getText().trim());
                    Encrypter encrypter = new Encrypter(targetFile1,theKey);
                    encrypter.encryptFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
