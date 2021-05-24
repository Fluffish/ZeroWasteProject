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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import model.Storage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStockage implements Initializable {


    private Stage stage;
    private Scene scene;
    private Storage deleted_item;

    @FXML
    private TextField Temperature;

    private String selected_storage;
    @FXML
    private MenuItem refrigerator;

    @FXML
    private MenuItem fridge;

    @FXML
    private MenuItem locker;

    @FXML
    private MenuItem warehouse;

    @FXML
    private MenuItem vault;

    @FXML
    private MenuButton Checkbox;

    @FXML
    private ListView<Storage> listView;


    //ajoute a la bdd un stockage et le rajoute dans la checkbock
    @FXML
    void addAStockage(javafx.event.ActionEvent event) {
        if (Temperature.getText().isEmpty()) {
            System.out.println("vous devez renseigner une température");

        } else {
            try {
                Float temp = Float.parseFloat(Temperature.getText());
                Main.session.utilities.addUserStorage(selected_storage, temp);
                refresh();
            } catch (NumberFormatException exc) {
                System.out.println("Veuillez renseigner un chiffre");
            }
        }
    }


    @FXML
    void NameOfTheItem(javafx.event.ActionEvent event) {
        selected_storage = refrigerator.getText();
        Checkbox.setText(selected_storage);
    }

    public void NameOfTheItem2(ActionEvent actionEvent) {
        selected_storage = fridge.getText();
        Checkbox.setText(selected_storage);
    }

    public void NameOfTheItem3(ActionEvent actionEvent) {
        selected_storage = locker.getText();
        Checkbox.setText(selected_storage);

    }

    public void NameOfTheItem4(ActionEvent actionEvent) {
        selected_storage = warehouse.getText();
        Checkbox.setText(selected_storage);

    }

    public void NameOfTheItem5(ActionEvent actionEvent) {
        selected_storage = vault.getText();
        Checkbox.setText(selected_storage);

    }


    @FXML
    public void MyFoodRediction(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/Food.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void AvailableDishes(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/dish.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MyProfil(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/profil.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void MainPage(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/mainpage2.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();

    }

    public void handleCloseButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent main_page = FXMLLoader.load(getClass().getResource("/Views/homepage2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteAStockage(ActionEvent event) {
        Main.session.utilities.removeStorageUserPossess(deleted_item.getIdStorage());
        refresh();
    }

    @FXML
    void SelectedItem(javafx.scene.input.MouseEvent event) {
        deleted_item = this.listView.getSelectionModel().getSelectedItem();
    }

    public void refresh() {
        ObservableList<Storage> listofStorage = FXCollections.observableArrayList(Main.session.utilities.getStorageRoom().values());
        listView.setItems(listofStorage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Storage> listofStorage = FXCollections.observableArrayList(Main.session.utilities.getStorageRoom().values());
        listView.setItems(listofStorage);


    }
}
