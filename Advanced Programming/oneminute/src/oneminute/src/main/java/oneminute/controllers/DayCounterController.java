package oneminute.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import oneminute.App;
import oneminute.classes.*;

public class DayCounterController extends BaseController {

    @FXML private Text dayText;
    @FXML private Button closeDayCounterButton;
    @FXML private Button onEventCompleteButton;

    @Override
    protected void callDayCounterApp() {
        updateDayText(); 
        System.out.println("DayCounterApp is set in HomeScreenController: " + dayCounterApp);
    }

    public void updateDayText() {
        if (dayText != null && dayCounterApp != null) {
            DayCounter dayCounter = dayCounterApp.getDayCounter();
            if (dayCounter != null) {
                dayText.setText("DAY " + dayCounter.getCurrentDay());
            } else {
                System.out.println("DayCounter is null in updateDayText method.");
            }
        }
    }

    public void nextDay() throws Exception {
        if (dayCounterApp != null && dayCounterApp.getDayCounter() != null && !dayCounterApp.getDayCounter().isMaxDayReached()) {
            dayCounterApp.getDayCounter().incrementDay();
            updateFamilyMembersStatus();
            updateDayText();
            System.out.println("(DayCounterScreen) Next Arrow Button Clicked! Today is Day " + dayCounterApp.getDayCounter().getCurrentDay());
        } else {
            System.out.println("Day limit reached. Cannot increment further.");
        }
    }

    private void updateFamilyMembersStatus() {
        if (dayCounterApp != null && dayCounterApp.getFamilyMembers() != null) {
            for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                member.setHunger(member.getHunger() - 5);
                member.setThirst(member.getThirst() - 5);
                member.setMorale(member.getMorale() - 1);
                member.setHealth(member.getHealth() - 2);
            }
            JournalStatusController statusController = dayCounterApp.getStatusController();
            if (statusController != null) {
                statusController.updateStatusBars();
            }
        }
    }

    @FXML
    public void onEventComplete(MouseEvent event) throws Exception {
        if (dayCounterApp != null && App.getPrimaryStage() != null) {
            nextDay();
        } else {
            System.out.println("App or primaryStage is null!");
        }
    }

    @FXML
    private void handleCloseDayCounterButton(MouseEvent event) throws IOException {
        try {
            App.setRoot("HomeScreen");
            System.out.println("(DayCounterScreen) Close Button clicked! Switching to Home Screen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
