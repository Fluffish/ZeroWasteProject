package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.connectionManager.ConnectingSession;

public class Main extends Application {

    protected static ConnectingSession session;


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/homepage2.fxml"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    public void setSession(ConnectingSession session) {
        this.session = session;
    }

    public static void main(String[] args) {

        launch(args);

    }


}
