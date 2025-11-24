package oneminute.controllers;

import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import oneminute.App;
import oneminute.classes.Player;
import oneminute.data.usernameData;

public class RegisterScreenController {

    @FXML
    private Label loginLabel;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userId;

    @FXML
    private Button registerButton;

    @FXML
    void register(ActionEvent event) throws Exception {
        App.getAudioManager().playSoundEffect("buttonClick");
        try {
            if (!(userId.getText()).isEmpty() && !(password.getText().isEmpty())) {
                if (usernameData.isUserIdRegistered(userId.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Registration Failed!");
                    alert.setHeaderText("User already registered");
                    alert.showAndWait();
                    return; 
                }

                String encryptedPassword = usernameData.encrypt(password.getText());
                Player newPlayer = new Player(userId.getText(), encryptedPassword);

                System.out.println("New Player: " + newPlayer.getUserId() + ", " + newPlayer.getPassword());

                try (FileWriter account = new FileWriter("src/main/resources/oneminute/database/Player.txt", true);
                     PrintWriter accountWriter = new PrintWriter(account)) {

                    // Write new user into database
                    accountWriter.println(newPlayer.getUserId() + "," + newPlayer.getPassword());
                    System.out.println("New player registered: " + newPlayer.getUserId());

                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Sign up successful!");
                    alert.setHeaderText("Welcome " + userId.getText());
                    alert.showAndWait();
                }

                // Set current user into init object for later reference
                usernameData.initPlayerData.setUserId(newPlayer.getUserId());
                usernameData.initPlayerData.setPassword(encryptedPassword); // Store encrypted password
                App.setRoot("LoginScreen");

            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Sign up failed!");
                alert.setHeaderText("Please fill out all the required information.");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace(); // Debug: Print stack trace to diagnose issues
        }
    }

    @FXML
    void switchToLoginScreen(MouseEvent event) throws Exception {
        System.out.println("(RegisterScreen) Login Button Clicked! Switching to Login Screen.");
        App.setRoot("LoginScreen");
    }
}
