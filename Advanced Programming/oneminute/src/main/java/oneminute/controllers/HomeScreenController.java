package oneminute.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import oneminute.App;
import oneminute.classes.BaseController;

public class HomeScreenController extends BaseController {

    @Override
    protected void callDayCounterApp() {
        System.out.println("DayCounterApp is set in HomeScreenController: " + dayCounterApp);
    }

    @FXML
    private void handlePauseButton(MouseEvent event) {
        try {
            if (dayCounterApp != null) {
                App.setRoot("PauseScreen");
            } else {
                System.out.println("(Home--Pause) DayCounterApp instance is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleJournalButton(MouseEvent event) {
        try {
            App.setRoot("JournalStoryScreen");
            System.out.println("(HomeScreen) Journal Button clicked! Switching to Journal Story Screen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
