package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.awt.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent fxml;


    @FXML
    private TextField usernameSignIn;

    @FXML
    private TextField SignUpUsername;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private TextField Mail;

    @FXML
    private TextField Phone;

    @FXML
    private TextField Budget;

    @FXML
    private PasswordField SignInPassword;
    @FXML
    private ListView<?> UseItLater;

    @FXML
    private ListView<?> ShoppingList;

    @FXML
    private TextField NewItem;


    @FXML
    public void handleCloseButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/homepage2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void AddToTheList(javafx.event.ActionEvent actionEvent) {
    }
}
