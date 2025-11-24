package oneminute.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import oneminute.App;
import oneminute.data.usernameData;

public class LoginScreenController {

    @FXML private Label forgetPasswordLabel;
    @FXML private PasswordField password;
    @FXML private Button playButton;
    @FXML private ImageView playButtonImage; 
    @FXML private Label registerLabel;
    @FXML private TextField userId;

    @FXML
    void logIn(ActionEvent event) {
        boolean found = false;

        try (BufferedReader infoR = new BufferedReader(
                new FileReader("src/main/resources/oneminute/database/Player.txt"))) {
            String line = "";

            while ((line = infoR.readLine()) != null) {
                StringTokenizer infoToken = new StringTokenizer(line, ",");
                String Username = infoToken.nextToken();
                String encryptedPassword = infoToken.nextToken();
                String decryptedPassword = usernameData.decrypt(encryptedPassword);

                // Checking if username & password match any records in database
                if (userId.getText().equals(Username) && password.getText().equals(decryptedPassword)) {
                    found = true;
                    usernameData.initPlayerData.setUserId(userId.getText());
                    usernameData.initPlayerData.setPassword(password.getText());
                    System.out.println("(Login Screen) Login successful! Switching to Start Screen.");
                    App.setRoot("StartScreen");
                    break;
                }
            }

            if (!found) {
                showAlert("Credentials incorrect", "Please enter your credentials correctly");
            }

        } catch (IOException e) {
            showAlert("Error", "An error occurred while accessing the user database.");
            e.printStackTrace();
        }
    }

    @FXML
    void switchToRegisterScreen(MouseEvent event) throws IOException {
        System.out.println("(Login Screen) Register label clicked! Switching to Register Screen.");
        App.setRoot("RegisterScreen");
    }

    @FXML
    void switchToResetPasswordScreen(MouseEvent event) throws IOException {
        System.out.println("(Login Screen) Forget Password label clicked! Switching to Reset Password Screen.");
        App.setRoot("ResetPasswordScreen");
    }

    @FXML
    void switchToStartScreen(ActionEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonClick");
        // Check if userId or password fields are empty
        if (userId.getText().isEmpty() || password.getText().isEmpty()) {
            showAlert("Incomplete Fields", "Please fill out both userId and password.");
            return;
        }else{
            System.out.println("(Login Screen) Play button clicked! Switching to Start Screen.");
        }

        // Validate if the user is registered before allowing to proceed
        if (isRegistered(userId.getText(), password.getText())) {
            App.setRoot("StartScreen");
            System.out.println("(LoginScreen) Login successful! Username: " + userId.getText());
        } else {
            showAlert("Registration Required", "Please register before proceeding.");
        }
    }


    private boolean isRegistered(String username, String password) {
        boolean registered = false;
        try (BufferedReader infoR = new BufferedReader(
                new FileReader("src/main/resources/oneminute/database/Player.txt"))) {
            String line = "";
            while ((line = infoR.readLine()) != null) {
                StringTokenizer infoToken = new StringTokenizer(line, ",");
                String storedUsername = infoToken.nextToken();
                String storedEncryptedPassword = infoToken.nextToken();
                String storedDecryptedPassword = usernameData.decrypt(storedEncryptedPassword);
                

                if (username.equals(storedUsername)) {
                    // Check if input password matches the registered password
                    if (!password.equals(storedDecryptedPassword)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Password Error");
                        alert.setHeaderText("Password does not match.");
                        alert.setContentText("Please enter the correct password.");
                        alert.showAndWait();
                        return false;
                    }
                    return true; // Password matches, user is registered
                }
            }
        } catch (IOException e) {
            showAlert("Error", "An error occurred while accessing the user database.");
            e.printStackTrace();
        }
        return registered;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.showAndWait();
    }
}