package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.User_Possess;
import model.Hibernate.Tables.Users;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdmin implements Initializable {

    private Stage stage;
    private Scene scene;

    private User_Possess deleted_food;

    private Users selected_user;

    @FXML
    private ListView<Users> listOfUsers;

    @FXML
    private ListView<User_Possess> listOfFood;


    @FXML
    void DeleteAFood(javafx.event.ActionEvent event) {

        Main.session.utilities.removeFoodUserPossess(selected_user,deleted_food.getId_food(),deleted_food.getId_storage(),deleted_food.getFood_add_date());
       refresh();
    }

    @FXML
    void MainPage(javafx.event.ActionEvent event) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/mainpage2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SelectedFood(MouseEvent event) {
        this.deleted_food = listOfFood.getSelectionModel().getSelectedItem();

    }

    public void refresh() {
        if (selected_user != null) {
            ObservableList<User_Possess> foods = FXCollections.observableArrayList(Main.session.utilities.getAllUsersPossess(selected_user));
            this.listOfFood.setItems(foods);
        }else {
            this.listOfFood.getItems().clear();
        }
            ObservableList<Users> users = FXCollections.observableArrayList(Main.session.utilities.getAllUsername());
            this.listOfUsers.setItems(users);

    }


    public void DeleteAUser(javafx.event.ActionEvent actionEvent) {
        Main.session.utilities.removeAUser(selected_user);
        selected_user = null;
        refresh();
    }


    @FXML
    void selectedUser(MouseEvent event) {
        this.selected_user=listOfUsers.getSelectionModel().getSelectedItem();
        refresh();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Users> users = FXCollections.observableArrayList(Main.session.utilities.getAllUsername());
        this.listOfUsers.setItems(users);

    }

    public void handleCloseButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/Views/homepage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }


}
