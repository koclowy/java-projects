package oneminute.controllers;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;
import oneminute.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class StorylineScreenController {
    @FXML private Button continueButton;
    @FXML private Label plotLabel;
    
    @FXML
    public void initialize() {
        initializeText();
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
       plotLabel.setOpacity(0);
       plotLabel.setDisable(true);
        
       PauseTransition pause = new PauseTransition(Duration.seconds(0.8));
       
        pause.setOnFinished(event -> {
            //create a fade transition for the Label to appear
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.8), plotLabel);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            
            fadeIn.setOnFinished(e -> plotLabel.setDisable(false));
            
            fadeIn.play(); 
        });

        pause.play();
    }
    
    @FXML
    void switchToStoryline2Screen(ActionEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonTick");
        System.out.println("(StorylineScreen) Continue label clicked! Switching to Storyline 2 Screen.");
        App.setRoot("Storyline2Screen");
    }

}