package oneminute.controllers;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import oneminute.App;

public class WinningStoryScreenController {

    @FXML
    private Button continueButton;

    @FXML
    private Label winningStoryText;

    @FXML
    public void initialize() {
        //set button hidden and disabled
        continueButton.setOpacity(0);
        continueButton.setDisable(true);
        
        // make transition pause for a few seconds
        PauseTransition pause = new PauseTransition(Duration.seconds(3.8));

        // Set the action after delay
        pause.setOnFinished(event -> {
            //create a fade transition for the button to appear
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.8), continueButton);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            
            fadeIn.setOnFinished(e -> continueButton.setDisable(false));
            
            fadeIn.play(); 
        });

        pause.play();
    }
    
    public void initializeText() {
        winningStoryText.setOpacity(0);
        winningStoryText.setDisable(true);
         
        PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
        
         pause.setOnFinished(event -> {
             //create a fade transition for the Label to appear
             FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.8), winningStoryText);
             fadeIn.setFromValue(0);
             fadeIn.setToValue(1);
             
             fadeIn.setOnFinished(e -> winningStoryText.setDisable(false));
             
             fadeIn.play(); 
         });
 
         pause.play();
     }
    
    @FXML
    void switchToWinningScreen(ActionEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonTick");
        System.out.println("Continue label clicked! Switching to Winning Screen.");
        App.setRoot("WinningScreen");
    }
}
