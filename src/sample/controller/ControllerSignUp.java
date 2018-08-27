package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.database.DatabaseHandler;
import sample.User;
import static sample.Constants.*;


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

        // to call method create new user by press button "Sign Up"
        loginSignUp.setOnAction(event -> signUpNewUser());
        // method returns to LoginScreen window
        backButton.setOnAction(event -> openWindow(backButton, LOGIN_SCREEN, TITLE_LOGIN_SCREEN));
    }

    private void signUpNewUser() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String loginName = newUserNameField.getText();
        String password = newPasswordField.getText();
        String gender = (Male.isSelected()) ? Male.getText() : Female.getText();

        User user = new User(loginName, password, gender);
        dbHandler.signUpUser(user);
        openWindow(loginSignUp, MAIN_WINDOW, TITLE_MAIN_WINDOW);
    }

    private boolean isPasswordMatch(PasswordField newPassword, PasswordField confirmPassword){
        return newPassword.getText().trim().equals(confirmPassword.getText().trim());
    }
}

