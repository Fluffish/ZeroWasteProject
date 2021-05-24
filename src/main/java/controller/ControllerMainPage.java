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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.User_Possess;
import model.Storage;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ControllerMainPage implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent fxml ;
    @FXML
    private TextFlow Budget;

    @FXML
    private Button AdminAccess;

    @FXML
    private ListView<Food> UseImmergency;

    @FXML
    private ListView<Food> YouCanUse;

    @FXML
    private ListView<Food> UseItLater;

    @FXML
    private ListView<User_Possess> ShoppingList;

    @FXML
    private TextField NewItem;

    @FXML
    private ListView<Food> ItemExisting;

    private Food selectedFood;

    private User_Possess deleted_food;

    @FXML
    private MenuButton SelectAFood;

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
    void SelectedFood(MouseEvent event) {
        selectedFood =this.ItemExisting.getSelectionModel().getSelectedItem();
        if(selectedFood.getFood_name().equals("Rentrez un nouvel aliment")){
            NewItem.setEditable(true);
            SelectAFood.setVisible(true);
        }else {
            NewItem.setEditable(false);
            SelectAFood.setVisible(false);

        }
    }

    @FXML
   public void DeleteAfood(javafx.event.ActionEvent event) {
        Main.session.utilities.removeFromShoppingList(deleted_food.getId_food());
        refresh();
    }

    @FXML
    void foodToAddtoTheList(MouseEvent event) {
        this.deleted_food = ShoppingList.getSelectionModel().getSelectedItem();

    }


    @FXML
    void AddaFood(javafx.event.ActionEvent event) {
        if (selectedFood.getFood_name().equals("Rentrez un nouvel aliment")) {
              String name_of_Food = NewItem.getText();
                Integer id_food = Main.session.utilities.addFood(name_of_Food,getSelectedFoodType);
                Main.session.utilities.addToShoppingList(id_food);
        }else {
                Main.session.utilities.addToShoppingList(selectedFood.getId_food());
               }
        refresh();
    }

    public void refresh(){
        ObservableList<User_Possess> Shoppingllist = FXCollections.observableArrayList(Main.session.utilities.getShoppingList());
        ShoppingList.setItems(Shoppingllist);
    }

    @FXML
    public void getCereal(javafx.event.ActionEvent event)
    {
        getSelectedFoodType = 8;
        SelectAFood.setText("Céréal");
    }

    @FXML
    public void getFeculent(javafx.event.ActionEvent event) {

        getSelectedFoodType = 7 ;
        SelectAFood.setText("Féculent");
    }

    @FXML
    public void getFromage(javafx.event.ActionEvent event) {
        getSelectedFoodType = 5;
        SelectAFood.setText("Fromage");
    }

    @FXML
    public void getFruit(javafx.event.ActionEvent event) {
        getSelectedFoodType = 3;
        SelectAFood.setText("Fruit");

    }

    @FXML
    public void getLaitage(javafx.event.ActionEvent event) {

        getSelectedFoodType = 4;
        SelectAFood.setText("Laitage");
    }

    @FXML
    public void getLegume(javafx.event.ActionEvent event) {

        getSelectedFoodType = 2;
        SelectAFood.setText("Légume");
    }

    @FXML
    public void getViande(javafx.event.ActionEvent event) {
        getSelectedFoodType = 1;
        SelectAFood.setText("Viande");
    }

    @FXML
    public void getYaourt(javafx.event.ActionEvent event) {
        getSelectedFoodType = 6;
        SelectAFood.setText("Yaourt");
    }

    @FXML
    public void handleCloseButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/Views/homepage2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void StorageRedirection(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/Stockage.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MyFoodRediction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/Food.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void AvailableDishes(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/dish.fxml"));
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
    void OnAdminPage(javafx.event.ActionEvent event) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/AdminPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(!Main.session.getUser().isIs_admin()) {
            AdminAccess.setVisible(false);
        }

        ObservableList<Food> emmergencyfoods = FXCollections.observableArrayList(Main.session.utilities.getVeryLimitedFood());
        this.UseImmergency.setItems(emmergencyfoods);

        ObservableList<Food> limitedfood = FXCollections.observableArrayList(Main.session.utilities.getLimitedFood());
        this.YouCanUse.setItems(limitedfood);

        ObservableList<Food> foods  = FXCollections.observableArrayList(Main.session.utilities.getNotUrgentFood());
        this.UseItLater.setItems(foods);

        Text budget = new Text( String.valueOf(Main.session.getUser().getUser_max_budget()));
        Budget.getChildren().add(budget);

        ObservableList<User_Possess> Shoppingllist = FXCollections.observableArrayList(Main.session.utilities.getShoppingList());
        ShoppingList.setItems(Shoppingllist);
        ObservableList<Food> listofFood = FXCollections.observableArrayList(Main.session.utilities.getFoodOfTableFood());
        ItemExisting.setItems(listofFood);
        ItemExisting.getItems().add(new Food("Rentrez un nouvel aliment"));
        NewItem.setEditable(false);
        SelectAFood.setVisible(false);


    }


}
