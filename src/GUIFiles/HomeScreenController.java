package GUIFiles;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class HomeScreenController {

    private Main main;

    // Views
    @FXML private BorderPane HomeScreenRootPane;
    @FXML private Button EncryptButton;
    @FXML private Button DecryptButton;
    @FXML private Button KeyGenButton;

    public void setMain(Main main){
        this.main= main;
    }

}
