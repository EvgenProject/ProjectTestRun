package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.User;
import sample.database.DatabaseHandler;

import static sample.Constants.*;

public class ControllerLoginScreen extends Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userNameField;

    @FXML
    private Button registerButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox isSavePasswordCheck;

    @FXML
    private Button loginAuthButton;

    @FXML
    void initialize() {

        loginAuthButton.setOnAction( event -> {
            String userName = userNameField.getText().trim();
            String userPassword = passwordField.getText().trim();
            
            if(!userName.equals("") || !userPassword.equals(""))
                loginUser(userName, userPassword);

            else System.out.println("Login or password is empty");
        });

        registerButton.setOnAction( event ->  {
            openWindow(registerButton, SIGN_UP_WINDOW);
        });
    }

    private void loginUser(String userName, String userPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLoginName(userName);
        user.setPassword(userPassword);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;

        try{
            while(result.next()){
                String loginname = result.getString("loginname");
                String password = result.getString("password");
                String gender = result.getString("gender");
                System.out.println(loginname + " " + password + " " + gender);
                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(counter >= 1){
            openWindow(registerButton, MAIN_WINDOW);
        }
    }
}

