package oneminute.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import oneminute.App;

public class StartScreenController {
    @FXML
    public void switchToStorylineScreen(ActionEvent event) throws Exception {
        App.getAudioManager().playSoundEffect("buttonStart");
        System.out.println("(StartScreen) Play Button clicked! Switching to Storyline Screen.");
        App.setRoot("StorylineScreen");
    }
}
