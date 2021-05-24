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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.Food_Type;
import model.Hibernate.Tables.User_Possess;
import model.Storage;
import org.bouncycastle.asn1.cms.TimeStampAndCRL;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ResourceBundle;

public class ControllerFood implements Initializable
{

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField ArticleName;

    private Food selectedFood;

    private Storage storage;

    private User_Possess deleted_food;

    @FXML
    private TextField quantité;

    @FXML
    private ListView<Food> ShowFood;

    @FXML
    private TextField DateLimte;

    @FXML
    private ListView<Storage> DisplayStockage;

    @FXML
    private MenuItem céréales;

    @FXML
    private MenuItem féculent;

    @FXML
    private MenuItem fromage;

    @FXML
    private MenuItem fruit;

    @FXML
    private MenuItem laitage;

    @FXML
    private MenuItem légume;

    @FXML
    private MenuItem viande;

    @FXML
    private MenuItem yaourt;
    private Integer getSelectedFoodType;
    @FXML
    private ListView<User_Possess> DisplayListofood;

    @FXML
    private TextField PriceOfTheArticle;

    @FXML
    private MenuButton FoodCheckBox;


    @FXML
    private MenuButton TypeOfFoodCheckBox;


    @FXML
     public void getCereal(javafx.event.ActionEvent event) {
        getSelectedFoodType = 8;
    }

    @FXML
    public void getFeculent(javafx.event.ActionEvent event) {
        getSelectedFoodType = 7 ;
    }

    @FXML
    public void getFromage(javafx.event.ActionEvent event) {
        getSelectedFoodType = 5;
    }

    @FXML
    public void getFruit(javafx.event.ActionEvent event) {
        getSelectedFoodType = 3;
    }

    @FXML
    public void getLaitage(javafx.event.ActionEvent event) {
        getSelectedFoodType = 4;
    }

    @FXML
    public void getLegume(javafx.event.ActionEvent event) {
        getSelectedFoodType = 2;
    }

    @FXML
    public void getViande(javafx.event.ActionEvent event) {
        getSelectedFoodType = 1;
    }

    @FXML
    public void getYaourt(javafx.event.ActionEvent event) {
        getSelectedFoodType = 6;
    }

    @FXML
    void SelectedStockage(MouseEvent event) {
        storage = this.DisplayStockage.getSelectionModel().getSelectedItem();
    }

    @FXML
    void AddAnAliment(javafx.event.ActionEvent event) {

        if (selectedFood.getFood_name().equals("Rentrez un nouvel aliment")) {

            try {
                String name_of_Food = ArticleName.getText();

                Float price_of_Food = Float.parseFloat(PriceOfTheArticle.getText());
                String quantity = quantité.getText();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = simpleDateFormat.parse(DateLimte.getText());
                Timestamp expery_date = new Timestamp(date.getTime());
                Integer id_food = Main.session.utilities.addFood(name_of_Food,getSelectedFoodType);
                Main.session.utilities.addUserPossess(storage.getIdStorage(),id_food,quantity,expery_date,price_of_Food);

            } catch (Exception exc) {
            }
        }else {
            try {
                Float price_of_Food = Float.parseFloat(PriceOfTheArticle.getText());
                String quantity = quantité.getText();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = simpleDateFormat.parse(DateLimte.getText());
                Timestamp expery_date = new Timestamp(date.getTime());
                Main.session.utilities.addUserPossess(storage.getIdStorage(),selectedFood.getId_food(),quantity,expery_date,price_of_Food);
            }catch (Exception exc){
            }
             }
        refresh();
    }

    @FXML
    void getFoodtoDelete(MouseEvent event) {
        this.deleted_food = DisplayListofood.getSelectionModel().getSelectedItem();

    }

    @FXML
    void DeleteAfood(ActionEvent event) {

        Main.session.utilities.removeFoodUserPossess(deleted_food.getId_food(),deleted_food.getId_storage(),deleted_food.getFood_add_date());
        refresh();
    }

    public void refresh(){
        ObservableList<User_Possess> listofUsersFood = FXCollections.observableArrayList(Main.session.utilities.getAllUsersPossess());
        DisplayListofood.setItems(listofUsersFood);

        ObservableList<Food> listofFood = FXCollections.observableArrayList(Main.session.utilities.getFoodOfTableFood());
        ShowFood.setItems(listofFood);
        ShowFood.getItems().add(new Food("Rentrez un nouvel aliment"));
        ArticleName.setEditable(false);
        TypeOfFoodCheckBox.setVisible(false);

    }


    @FXML
    void SelectedFood(MouseEvent event) {
        selectedFood =this.ShowFood.getSelectionModel().getSelectedItem();
        if(selectedFood.getFood_name().equals("Rentrez un nouvel aliment")){
            ArticleName.setEditable(true);
            TypeOfFoodCheckBox.setVisible(true);
             }else {
            ArticleName.setEditable(false);
            TypeOfFoodCheckBox.setVisible(false);

        }
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

    public void handleCloseButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/homepage2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<User_Possess> listofUsersFood = FXCollections.observableArrayList(Main.session.utilities.getAllUsersPossess());
        DisplayListofood.setItems(listofUsersFood);
        ObservableList<Food> listofFood = FXCollections.observableArrayList(Main.session.utilities.getFoodOfTableFood());
        ShowFood.setItems(listofFood);
        ShowFood.getItems().add(new Food("Rentrez un nouvel aliment"));
        ArticleName.setEditable(false);
        TypeOfFoodCheckBox.setVisible(false);
        ObservableList<Storage> listofStorage = FXCollections.observableArrayList(Main.session.utilities.getStorageRoom().values());
        DisplayStockage.setItems(listofStorage);

     }


    public void StorageRedirection(ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Stockage.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();
    }
}
