package oneminute.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import oneminute.App;
import oneminute.classes.Player;
import oneminute.data.usernameData;

public class ResetPasswordScreenController {

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private PasswordField newPassword;
    
    @FXML
    private TextField userId;

    @FXML
    private Button resetButton;

    private List<Player> players;

    public void initialize() {
        players = usernameData.loadPlayerDataFromDatabase(); // Load player data from database
    }

    @FXML
    void handleIncomplete(ActionEvent event) {
        App.getAudioManager().playSoundEffect("buttonClick");
        showAlert(AlertType.WARNING, "Incomplete Fields", "Please fill in all fields.");
    }

    @FXML
    void handleResetButton(ActionEvent event) throws IOException {
        if (isAnyFieldIncomplete()) { 
            App.getAudioManager().playSoundEffect("buttonClick");
            handleIncomplete(event); 
        } else {
            validateAndShowDialog(); 
        }
    }

    private boolean isAnyFieldIncomplete() {
        return userId.getText().isEmpty() || newPassword.getText().isEmpty() || confirmPassword.getText().isEmpty();
    }

    private boolean isUserIdValid(String userId) {
        return players.stream().anyMatch(player -> player.getUserId().equals(userId));
    }

    private void validateAndShowDialog() throws IOException {
        String userIdInput = userId.getText();
        String newPwd = newPassword.getText();
        String confirmPwd = confirmPassword.getText();

        if (!isUserIdValid(userIdInput)) {
            showAlert(AlertType.ERROR, "Invalid User ID", "The user ID does not exist in the database.");
        } else if (newPwd.equals(confirmPwd)) {
            showResetSuccess(); 
        } else {
            showAlert(AlertType.ERROR, "Password mismatch", "New password and confirm password do not match.");
        }
    }

    private void showResetSuccess() throws IOException {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Password Reset Successful");
        alert.setHeaderText(null);
        alert.setContentText("Your password has been successfully reset.");
        alert.showAndWait();

        String userIdInput = userId.getText();
        String newPwd = newPassword.getText();
        updatePasswordInDatabase(userIdInput, newPwd);

        switchToLoginScreen(null); 
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updatePasswordInDatabase(String userId, String newPassword) {
        String encryptedPassword = usernameData.encrypt(newPassword);
        File originalFile = new File("src/main/resources/oneminute/database/Player.txt");
        File tempFile = new File("src/main/resources/oneminute/database/Player_temp.txt");
    
        try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
             FileWriter writer = new FileWriter(tempFile);
             PrintWriter printWriter = new PrintWriter(writer)) {
    
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedUsername = parts[0].trim(); // Trim to handle whitespace
                String storedEncryptedPassword = parts[1].trim(); // Trim to handle whitespace
    
                if (storedUsername.equals(userId)) {
                    printWriter.println(userId + "," + encryptedPassword);
                } else {
                    printWriter.println(line);
                }
            }
    
        } catch (IOException e) {
            showAlert(null, "Error", "An error occurred while updating the password.");
            e.printStackTrace();
        }
    
        // Delete the original file
        if (!originalFile.delete()) {
            showAlert(null, "Error", "Failed to delete the original file.");
            return;
        }
    
        // Rename temp file to original file
        if (!tempFile.renameTo(originalFile)) {
            showAlert(null, "Error", "Failed to update the password.");
        } else {
            System.out.println("Password updated successfully.");
        }
    }
    
    @FXML
    void switchToLoginScreen(MouseEvent event) throws IOException {
        System.out.println("(ResetPasswordScreen) Reset Button Clicked! Switching to Login Screen.");
        App.setRoot("LoginScreen");
    }
}