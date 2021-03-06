package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.Constants.*;
import static sample.database.DatabaseHandler.createTables;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        createTables(USERS_DB);
        Parent root = FXMLLoader.load(getClass().getResource(LOGIN_SCREEN));
        primaryStage.setTitle(TITLE_LOGIN_SCREEN);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);

    }
}
