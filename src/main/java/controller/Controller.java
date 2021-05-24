package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import model.connectionManager.ConnectingSession;
import model.connectionManager.SignUp;

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
        Parent main_page = FXMLLoader.load(getClass().getResource("/Views/homepage2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(main_page);
        stage.setScene(scene);
        stage.show();
    }

//Connexion
    @FXML
    public void SignInButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {

        String username = usernameSignIn.getText();
        String password = SignInPassword.getText();
        Main.session = new ConnectingSession(username, password);
       if (Main.session.isConnected()) {
            Parent main_page = FXMLLoader.load(getClass().getResource("/Views/mainpage2.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(main_page);
            stage.setScene(scene);
            stage.show();
        } else
            System.out.println("ca marche pas");
    }


//Inscription
    @FXML
    public void SignUpButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        String username = SignUpUsername.getText();
        String password =SignUpPassword.getText();
        String mail =Mail.getText();
        String phone =Phone.getText();
        Integer budget =Integer.parseInt(Budget.getText());
        if(!SignUp.createUser(username,password,mail,phone,budget,budget)) {
            System.out.println("Username is already used");

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
