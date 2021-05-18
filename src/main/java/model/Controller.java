package model;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    public void SignInButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/mainpage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void SignUpButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/homepage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void StorageRedirection(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Stockage.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MyFoodRediction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Food.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void AvailableDishes(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/dish.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MyProfil(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/profil.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/mainpage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
