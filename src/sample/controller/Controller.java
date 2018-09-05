package sample.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class Controller {

    private Stage parenStage = null;

    protected void openWindow(Button buttonAction, String window, String title){

        parenStage = (Stage) buttonAction.getScene().getWindow();
        parenStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(window));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        parenStage = new Stage();
        parenStage.initModality(Modality.NONE);
        parenStage.setTitle(title);
        parenStage.setScene(new Scene(root));
        parenStage.show();
    }


    protected void openModalWindow(Button buttonAction, String window, String warningMessage){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(window));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.setTitle(warningMessage);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(buttonAction.getScene().getWindow());
        stage.showAndWait();
    }

    protected void closeWindow(Button buttonAction){
        Stage stage = (Stage) buttonAction.getScene().getWindow();
        stage.close();
    }

    protected static boolean checkIsEmpty(TextField field){

        if (field.getText().trim().isEmpty()) return true;

        return false;
    }

    protected static void displayElement (Label element, String information){
        element.setText(information);
    }
}
