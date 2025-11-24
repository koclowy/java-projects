package oneminute.controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import oneminute.App;
public class DefeatScreenController {

    @FXML private Button retryButton;
    @FXML private Button quitButton;

    @FXML
    void switchToStartScreen(ActionEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonTick");
        System.out.println("Retry Button clicked! Switching to Start Screen.");
        App.setRoot("StartScreen");
    }

    @FXML
    void exitGame(ActionEvent event) {
        App.getAudioManager().playSoundEffect("buttonTick");
        System.out.println("Quit button clicked! Closing the game.");
        Platform.exit();
    }
}
