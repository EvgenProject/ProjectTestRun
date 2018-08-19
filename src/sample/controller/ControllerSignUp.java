package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Constants;
import sample.database.DatabaseHandler;
import sample.User;

import static sample.Constants.MAIN_WINDOW;

public class ControllerSignUp extends Controller{

    @FXML
    private TextField newUserNameField;

    @FXML
    private Button loginSignUp;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private Button backButton;

    @FXML
    void initialize(){

        // method create new user by press button "Sign Up"
        loginSignUp.setOnAction(event -> {
            signUpNewUser();
        });

        backButton.setOnAction(event -> {
            openWindow(backButton, Constants.LOGIN_SCREEN);
        });
    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String loginName = newUserNameField.getText();
        String password = newPasswordField.getText();
        String gender = "";

        if(Male.isSelected())
            gender = Male.getText();
        else
            gender = Female.getText();

        User user = new User(loginName, password, gender);

        dbHandler.signUpUser(user);
        openWindow(loginSignUp, MAIN_WINDOW);
    }

    private String validLogin(String login){

        return login;
    }
}

