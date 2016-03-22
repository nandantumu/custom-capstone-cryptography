package com.nt.cryptotool.GUIFiles;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HomeScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane HomeScreenRootPane;

    @FXML
    private Button KeyGenButton;

    @FXML
    private Button EncryptButton;

    @FXML
    private Button DecryptButton;

    @FXML
    void initialize() {
        assert HomeScreenRootPane != null : "fx:id=\"HomeScreenRootPane\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert KeyGenButton != null : "fx:id=\"KeyGenButton\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert EncryptButton != null : "fx:id=\"EncryptButton\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        assert DecryptButton != null : "fx:id=\"DecryptButton\" was not injected: check your FXML file 'HomeScreen.fxml'.";
        EncryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("EncryptButton click handled");
            }
        });
        DecryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("DecryptButton click handled");
            }
        });
        KeyGenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("KeyGenButton click handled");
            }
        });
    }
}
