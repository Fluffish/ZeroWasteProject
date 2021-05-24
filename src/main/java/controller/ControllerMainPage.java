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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Hibernate.Tables.Food;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainPage implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent fxml ;
    @FXML
    private TextFlow Budget;

    @FXML
    private ListView<Food> UseImmergency;

    @FXML
    private ListView<Food> YouCanUse;

    @FXML
    private ListView<Food> UseItLater;

    @FXML
    private ListView<?> ShoppingList;

    @FXML
    private TextField NewItem;



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
        ObservableList<Food> emmergencyfoods = FXCollections.observableArrayList(Main.session.utilities.getVeryLimitedFood());
        this.UseImmergency.setItems(emmergencyfoods);

        ObservableList<Food> limitedfood = FXCollections.observableArrayList(Main.session.utilities.getLimitedFood());
        this.YouCanUse.setItems(limitedfood);

        ObservableList<Food> foods  = FXCollections.observableArrayList(Main.session.utilities.getNotUrgentFood());
        this.UseItLater.setItems(foods);

        Text budget = new Text( String.valueOf(Main.session.getUser().getUser_max_budget()));
        Budget.getChildren().add(budget);

    }


}
