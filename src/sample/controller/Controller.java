package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class Controller {

    protected void openWindow(Button buttonAction, String window, String title){

        Stage stage = (Stage) buttonAction.getScene().getWindow();
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(window));
        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    protected static void checkIsEmpty(TextField field){

        if (field.getText().trim().isEmpty()) {
            System.out.println( "Login is empty");
        }
        else {
            System.out.println( "Login is not empty");
        }
    }
}
