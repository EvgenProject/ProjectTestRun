package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import static sample.Constants.*;

public class ControllerMainWindow extends Controller{

    @FXML
    private Button buttonLogOut;

    @FXML
    void initialize() {
        buttonLogOut.setOnAction(event -> openWindow(buttonLogOut, LOGIN_SCREEN, TITLE_LOGIN_SCREEN));
    }
}