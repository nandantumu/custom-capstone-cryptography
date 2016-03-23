package com.nt.cryptotool.GUIFiles;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.nt.cryptotool.MainApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HomeScreenController {

    private MainApp main;

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
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Get file");
                File theSelectedFile = fileChooser.showOpenDialog(HomeScreenRootPane.getScene().getWindow());
                System.out.println(theSelectedFile.getAbsoluteFile());
            }
        });
        DecryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("DecryptButton click handled");
                Stage theMainStage = (Stage)HomeScreenRootPane.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/DecryptScreen.fxml"));
                try {
                    Parent root = (Parent) fxmlLoader.load(fxmlLoader.getClassLoader().getResource("fxml/DecryptScreen.fxml"));
                    theMainStage.setScene(new Scene(root,600,400));
                    theMainStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        KeyGenButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("KeyGenButton click handled");
            }
        });
    }

    public void addMain(MainApp mainApp) {
        this.main = mainApp;
    }
}
