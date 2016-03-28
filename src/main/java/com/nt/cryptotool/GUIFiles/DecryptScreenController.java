/**
 * Sample Skeleton for 'DecryptScreen.fxml' Controller Class
 */

package com.nt.cryptotool.GUIFiles;

import java.io.File;
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

public class DecryptScreenController {

    private File keyfile,targetFile;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="rootPane"
    private BorderPane rootPane; // Value injected by FXMLLoader

    @FXML // fx:id="decryptButton"
    private Button decryptButton; // Value injected by FXMLLoader

    @FXML // fx:id="decryptTitleText"
    private Label decryptTitleText; // Value injected by FXMLLoader

    @FXML // fx:id="selectKeyFileButton"
    private Button selectKeyFileButton; // Value injected by FXMLLoader

    @FXML // fx:id="selectTargetFileButton"
    private Button selectTargetFileButton; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private TextField passwordField; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'DecryptScreen.fxml'.";
        assert decryptButton != null : "fx:id=\"decryptButton\" was not injected: check your FXML file 'DecryptScreen.fxml'.";
        assert decryptTitleText != null : "fx:id=\"decryptTitleText\" was not injected: check your FXML file 'DecryptScreen.fxml'.";
        assert selectKeyFileButton != null : "fx:id=\"selectKeyFileButton\" was not injected: check your FXML file 'DecryptScreen.fxml'.";
        assert selectTargetFileButton != null : "fx:id=\"selectTargetFileButton\" was not injected: check your FXML file 'DecryptScreen.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'DecryptScreen.fxml'.";

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

        decryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    TargetFile targetFile1 = new TargetFile(targetFile.getAbsolutePath(), Task.Decrypt);
                    Key theKey = new Key(keyfile,passwordField.getText().trim());
                    Encrypter encrypter = new Encrypter(targetFile1,theKey);
                    encrypter.encryptFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
