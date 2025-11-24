package oneminute.controllers;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;
import oneminute.App;
import javafx.event.ActionEvent;

public class Storyline2ScreenController {

    @FXML private Button beginLabel;

    @FXML
    public void initialize() {
        //set button hidden and disabled
        beginLabel.setOpacity(0);
        beginLabel.setDisable(true);
        
        // make transition pause for a few seconds
        PauseTransition pause = new PauseTransition(Duration.seconds(3.8));

        // Set the action after delay
        pause.setOnFinished(event -> {
            //create a fade transition for the button to appear
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.8), beginLabel);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            
            fadeIn.setOnFinished(e -> beginLabel.setDisable(false));
            
            fadeIn.play(); 
        });

        pause.play();
    }
    
    @FXML
    void switchToShoppingScreen(ActionEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonStart");
        System.out.println("(Storyline2Screen) Begin label clicked! Switching to Shopping Screen.");
        App.setRoot("ShoppingScreen");
    }
}