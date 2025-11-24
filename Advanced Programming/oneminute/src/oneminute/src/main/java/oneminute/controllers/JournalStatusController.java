package oneminute.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import oneminute.classes.*;
import oneminute.App;

public class JournalStatusController extends BaseController {

    private Stage primaryStage;
    private Map<String, FamilyMemberStatus> familyMemberMap = new HashMap<>();

    @FXML
    private ImageView susanHealthBar;
    @FXML
    private ImageView susanHungerBar;
    @FXML
    private ImageView susanThirstBar;
    @FXML
    private ImageView susanMoraleBar;

    @FXML
    private ImageView robertHealthBar;
    @FXML
    private ImageView robertHungerBar;
    @FXML
    private ImageView robertThirstBar;
    @FXML
    private ImageView robertMoraleBar;

    @FXML
    private ImageView gwenHealthBar;
    @FXML
    private ImageView gwenHungerBar;
    @FXML
    private ImageView gwenThirstBar;
    @FXML
    private ImageView gwenMoraleBar;

    @FXML
    public void initialize() {
        if (dayCounterApp != null) {
            // Initialize family member map
            for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                familyMemberMap.put(member.getName(), member);
            }
            updateStatusBars();
        } else {
            System.out.println("DayCounterApp is null in initialize method.");
        }
    }

    @FXML
    private void handleCloseJournalStatusButton(MouseEvent event) {
        try {
            if (dayCounterApp != null) {
                App.setRoot("HomeScreen");
                System.out.println("(JournalStatusScreen) Close Button clicked! Switching to Home Screen.");
            } else {
                System.out.println("(JournalStatus--Close) DayCounterApp instance is null!"); // Debug statement
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleJournalStoryButton(MouseEvent event) {
        try {
            if (dayCounterApp != null) {
                App.setRoot("JournalStoryScreen");
                System.out.println("(JournalStatusScreen) Journal Story tab Button clicked! Switching to Journal Story Screen.");
            } else {
                System.out.println("(JournalStatus--JournalStory) DayCounterApp instance is null!"); // Debug statement
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusBars() {
        if (familyMemberMap.isEmpty()) {
            System.out.println("Family member map is empty. Cannot update status bars.");
            return;
        }

        updateStatusBar(susanHealthBar, familyMemberMap.get("Susan").getHealth());
        updateStatusBar(susanHungerBar, familyMemberMap.get("Susan").getHunger());
        updateStatusBar(susanThirstBar, familyMemberMap.get("Susan").getThirst());
        updateStatusBar(susanMoraleBar, familyMemberMap.get("Susan").getMorale());

        updateStatusBar(robertHealthBar, familyMemberMap.get("Robert").getHealth());
        updateStatusBar(robertHungerBar, familyMemberMap.get("Robert").getHunger());
        updateStatusBar(robertThirstBar, familyMemberMap.get("Robert").getThirst());
        updateStatusBar(robertMoraleBar, familyMemberMap.get("Robert").getMorale());

        updateStatusBar(gwenHealthBar, familyMemberMap.get("Gwen").getHealth());
        updateStatusBar(gwenHungerBar, familyMemberMap.get("Gwen").getHunger());
        updateStatusBar(gwenThirstBar, familyMemberMap.get("Gwen").getThirst());
        updateStatusBar(gwenMoraleBar, familyMemberMap.get("Gwen").getMorale());
    }

    private void updateStatusBar(ImageView bar, int value) {
        if (bar != null) {
            double percentage = value / 100.0;
            bar.setFitWidth(percentage * bar.getImage().getWidth());
            // You may want to update the height or other properties based on your design
        } else {
            System.out.println("ImageView is null for updating status bar.");
        }
    }
}
