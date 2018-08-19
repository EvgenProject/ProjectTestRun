package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    void initialize(){

        loginSignUp.setOnAction(event -> {
            signUpNewUser();
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
        openMainWindow(loginSignUp, MAIN_WINDOW);
    }

    private String validLogin(String login){

        return login;
    }
}

