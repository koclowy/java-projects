package oneminute.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import oneminute.App;

public class WinningScreenController {

    @FXML
    private Button mainMenuButton;

    @FXML
    void switchToStartScreen(ActionEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonTick");
        System.out.println("Main Menu Button clicked! Switching to Start Screen.");
        App.setRoot("StartScreen");
    }

}
