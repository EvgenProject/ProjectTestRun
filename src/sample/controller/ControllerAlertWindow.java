package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static sample.Constants.PASSWORDS_ARE_NOT_MATCHED;

public class ControllerAlertWindow extends Controller{

    @FXML
    private Button loginAuthButton;

    @FXML
    private Label warningLabel;

    @FXML
    void initialize(){

        displayElement(warningLabel, PASSWORDS_ARE_NOT_MATCHED);

        loginAuthButton.setOnAction( event -> closeWindow(loginAuthButton));
    }


}
