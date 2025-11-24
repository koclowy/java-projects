
package oneminute.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import oneminute.App;
import oneminute.classes.BaseController;
import oneminute.data.*;

public class PauseScreenController extends BaseController{

    @FXML private Button quitButton;
    @FXML private Button continueButton;
    @FXML private Button saveButton;


    // Method to handle Continue button action
   @FXML
    private void toContinue(MouseEvent event) throws Exception{
        System.out.println("(PauseScreen) Continue Button clicked! Switching to Home Screen.");
        App.setRoot("HomeScreen");
    }
    
    // Method to handle Save Button 
    @FXML
    private void toSave (MouseEvent event) {
        
        ArrayList <String> inventoryItems = new ArrayList <>(); // making a new arraylist with inventory
        inventoryItems.add("Battery");
        inventoryItems.add("Bug Spray");
        inventoryItems.add("Canned Food");
        inventoryItems.add("Deodorant");
        inventoryItems.add("Flashlight");
        inventoryItems.add("First Aid Kit");
        inventoryItems.add("Toilet Paper");
        inventoryItems.add("Water");

        playerData playerData = new playerData("user", 2 ,"Healthy","Healthy","Healthy", inventoryItems); // creating playerData object
       
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("GameData.bin"))) { // to save the file
            oos.writeObject(playerData);
            showInformationAlert("Data Saved", "Your player data has been saved successfully"); //window to pop up saying that your data has been saved
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("GameData.bin"))) { // to read the file
            playerData readPlayerData = (playerData) ois.readObject();
            System.out.println(readPlayerData);
            System.out.println("playerUID = " + readPlayerData.getPlayerUID());
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Method to handle Quit button action
    @FXML
    private void toQuit(MouseEvent event) {
        // Get the current stage and close it
        System.out.println("Quit button clicked! ");
        boolean confirmQuit = showConfirmationAlert("Quit Game", "Are you sure you want to quit the game?"); // for yes or no alert box to pop up
        
        if (confirmQuit) {
            System.out.println ("User confirmed quit. Exiting application"); // if yes has been clicked, platform.exit() will comence and exit the game
            Platform.exit();
        } else {
            System.out.println ("User cancelled quit. Application continued. "); // if no button been clicked
        }
    }

    //Yes or No Alert Box
     private boolean showConfirmationAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        
        ButtonType yesButton = new ButtonType ("Yes");
        ButtonType noButton = new ButtonType ("No");
        
        alert.getButtonTypes().setAll(yesButton, noButton);
        Optional<ButtonType> result = alert.showAndWait();
        
        return result.isPresent() && result.get() == yesButton;     
    }
     
    // Information Alert Box
    private void showInformationAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
 


