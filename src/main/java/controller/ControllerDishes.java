package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.Recipe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDishes implements Initializable{

    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<Recipe> ListOfDishes;

    private Recipe selectedRecipe;

    @FXML
    private TextFlow DishSelected;


    @FXML
    private ListView<Food> SecondListRecipe;



    @FXML
    void DisplayTheDish(MouseEvent event) {
        this.selectedRecipe = ListOfDishes.getSelectionModel().getSelectedItem();
        refresh();

    }

    public void refresh(){
        ObservableList<Food> secondlist = FXCollections.observableArrayList(Main.session.utilities.getIngredientsOfARecipe(selectedRecipe.getId_recipe()));
        SecondListRecipe.setItems(secondlist);

    }

    public void StorageRedirection(ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/Stockage.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void MyProfil(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/profil.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/mainpage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    public void handleCloseButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/Views/homepage2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Recipe> listOfRecipe = FXCollections.observableArrayList(Main.session.utilities.getAvailableRecipes());
        ListOfDishes.setItems(listOfRecipe);

    }

    public void MyFoodRediction(ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/Food.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();


    }
}
