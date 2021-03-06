package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerProfil implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private TextFlow Username;

    @FXML
    private TextFlow Budget;

    @FXML
    private TextFlow Phone;

    @FXML
    private TextFlow Email;

    @FXML
    private TextField NewUsername;

    @FXML
    private TextField NewEmail;

    @FXML
    private TextField NewPhone;

    @FXML
    private TextField NewBudget;

    @FXML
    private PasswordField NewPassword;




    @FXML
    void ChangeTheBudget(javafx.event.ActionEvent event) {
    String new_budget = NewBudget.getText();
    Main.session.changeMaxBudget(Integer.parseInt(new_budget));
    refresh();

    }

    @FXML
    void ChangeTheMail(javafx.event.ActionEvent event) {
    String new_mail = NewEmail.getText();
    Main.session.changeMail(new_mail);
    refresh();

    }

    @FXML
    void ChangeThePassword(javafx.event.ActionEvent event) {
    String new_password = NewPassword.getText();
        Main.session.changePassword(new_password);

    }

    @FXML
    void ChangeThePhone(javafx.event.ActionEvent event) {
    String new_phone = NewPhone.getText();
        Main.session.changePhone(new_phone);
        refresh();
    }

    @FXML
    void ChangeTheUsername(javafx.event.ActionEvent event) {
    String new_username = NewUsername.getText();
        Main.session.changeUsername(new_username);
        refresh();
    }

    public void refresh(){
        Text username = new Text(Main.session.getUser().getUsername());
        Username.getChildren().clear();
        Username.getChildren().add(username);

        Text email = new Text(Main.session.getUser().getMail_user());
        Email.getChildren().clear();
        Email.getChildren().add(email);

        Text phone = new Text(Main.session.getUser().getTel_user());
        Phone.getChildren().clear();
        Phone.getChildren().add(phone);


        Text budget = new Text( String.valueOf(Main.session.getUser().getUser_max_budget()));
        Budget.getChildren().clear();
        Budget.getChildren().add(budget);

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text username = new Text(Main.session.getUser().getUsername());
        Username.getChildren().clear();
        Username.getChildren().add(username);

        Text email = new Text(Main.session.getUser().getMail_user());
        Email.getChildren().clear();
        Email.getChildren().add(email);

        Text phone = new Text(Main.session.getUser().getTel_user());
        Phone.getChildren().clear();
        Phone.getChildren().add(phone);


        Text budget = new Text( String.valueOf(Main.session.getUser().getUser_max_budget()));
        Budget.getChildren().clear();
        Budget.getChildren().add(budget);
    }


    public void MainPage(ActionEvent actionEvent) throws IOException {
        Parent homepage = FXMLLoader.load(getClass().getResource("/Views/mainpage2.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(homepage);
        stage.setScene(scene);
        stage.show();
    }
}
