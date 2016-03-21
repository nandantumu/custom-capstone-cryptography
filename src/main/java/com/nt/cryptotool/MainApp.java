package com.nt.cryptotool;

import com.nt.cryptotool.utils.Converter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainApp extends Application {

    private Stage mainStage;
    private FXMLLoader loader;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        mainStage = stage;
        //HomeScreenController homeScreenController = new HomeScreenController(this);
        String fxmlFile = "fxml/HomeScreen.fxml";
        loader = new FXMLLoader();
        loader.getController();
        BorderPane rootNode = (BorderPane) loader.load(loader.getClassLoader().getResource("fxml/HomeScreen.fxml"));
        Scene scene = new Scene(rootNode, 600, 400);
        stage.setTitle("Encryption Tool");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void changeView(String scene) throws IOException{
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/fxml/"+scene));
        Scene scene1 = new Scene(rootNode);
        mainStage.setScene(scene1);
    }

}
