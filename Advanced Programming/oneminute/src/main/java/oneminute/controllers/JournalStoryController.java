package oneminute.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import oneminute.App;
import oneminute.classes.*;
import oneminute.lists.*;

public class JournalStoryController extends BaseController {

    @FXML private TextArea journalTextArea;
    @FXML private Button closeJournalStoryButton;
    @FXML private Button journalStatusButton;
    @FXML private Button journalStoryD1NOButton;
    @FXML private Button journalStoryD1YESButton;
    @FXML private Button goToDayCounterButton;
    @FXML private Button goToWinningStoryButton;

    private JournalStory journalStory = new JournalStory();
    private int currentPageIndex = 0;
    private ArrayList<String>[] pagesByDay = new ArrayList[14]; // Array to hold pages for each day

    @Override
    protected void callDayCounterApp() {
        System.out.println("(JournalStory) DayCounterApp set in onAppSet: " + dayCounterApp);
        initializePagesByDay();
        displayCurrentDayPage();
        goToWinningStoryButton.setVisible(false);
        goToWinningStoryButton.setDisable(true);
    }

    private void initializePagesByDay() {
        // Initialize each ArrayList in the pagesByDay array
        for (int i = 0; i < pagesByDay.length; i++) {
            pagesByDay[i] = new ArrayList<>();
        }

        // Populate pagesByDay with journal pages for each day
        for (int day = 1; day <= 14; day++) {
            pagesByDay[day - 1] = journalStory.getPagesForDay(day);
        }
    }

    private void displayCurrentDayPage() {
        resetScrollPosition();
        if (dayCounterApp != null) {
            int currentDay = dayCounterApp.getDayCounter().getCurrentDay();
            if (currentDay >= 1 && currentDay <= 14) {
                if (pagesByDay[currentDay - 1] != null && !pagesByDay[currentDay - 1].isEmpty()) {
                    displayPage(pagesByDay[currentDay - 1].get(currentPageIndex));
                }
            }
        }
    }

    private void displayPage(String pageContent) {
        journalTextArea.setText(pageContent);
    }

    @FXML
    private void handleCloseJournalStoryButton(MouseEvent event) {
        try {
            App.setRoot("HomeScreen");
            System.out.println("(JournalStoryScreen) Close Button clicked! Switching to Home Screen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleJournalStatusButton(MouseEvent event) {
        try {
            App.setRoot("JournalStatusScreen");
            System.out.println("(JournalStoryScreen) Journal Status tab button clicked! Switching to Journal Status Screen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToDayCounter(MouseEvent event) {
        try {
            App.setRoot("DayCounterScreen");
            System.out.println("(JournalStoryScreen-Outcome) Next Arrow Button clicked! Switching to Day Counter Screen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGoToWinningStoryButton(MouseEvent event) {
        try {
            App.setRoot("WinningStoryScreen");
            System.out.println("(JournalStoryScreen-LastDay) Complete Lockdown Button clicked! Switching to Winning Story Screen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateFamilyMemberStatus() {
        if (dayCounterApp != null && journalTextArea != null) {
            String status = dayCounterApp.getFormattedFamilyMembersStatus();
            journalTextArea.appendText("\n\n" + status); // Append the status at the bottom
        }
    }

    @FXML
    private void sayNo(MouseEvent event) {
        resetScrollPosition();
        if (dayCounterApp != null) {
            int currentDay = dayCounterApp.getDayCounter().getCurrentDay();
            switch (currentDay) {
                case 1:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(2));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setHunger(member.getHunger() - 10);
                    }
                    break;
                case 2:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(2));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setHunger(member.getHunger() + 10);
                    }
                    break;
                case 5:
                case 6:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(2));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() - 5);
                    }
                    if (currentDay == 6) {
                        for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                            member.setHealth(member.getHealth() - 5);
                        }
                    }
                    break;
                case 7:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(2));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() + 5);
                        member.setHealth(member.getHealth() + 5);
                        member.setThirst(member.getThirst() + 30);
                        member.setHunger(member.getHunger() + 30);
                    }
                    break;
                case 8:
                case 9:
                case 11:
                case 13:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(2));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() - 10);
                    }
                    if (currentDay == 9 || currentDay == 11 || currentDay == 13) {
                        for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                            member.setHealth(member.getHealth() - 10);
                        }
                    }
                    break;
                case 14:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(2));
                    updateFamilyMemberStatus();
                    goToWinningStoryButton.setVisible(true);
                    goToWinningStoryButton.setDisable(false);
                    journalStoryD1NOButton.setDisable(true);
                    journalStoryD1YESButton.setDisable(true);
                    goToDayCounterButton.setDisable(true);
                    break;
                default:
                    journalTextArea.setText("No text available for this day.");
                    break;
            }
            updateFamilyMemberStatus();
        }

        journalStoryD1NOButton.setVisible(false);
        journalStoryD1YESButton.setVisible(false);
        goToDayCounterButton.setVisible(true);
    }

    @FXML
    private void sayYes(MouseEvent event) {
        resetScrollPosition();
        if (dayCounterApp != null) {
            int currentDay = dayCounterApp.getDayCounter().getCurrentDay();
            switch (currentDay) {
                case 1:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setHealth(member.getHealth() - 10);
                    }
                    break;
                case 2:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setHunger(member.getHunger() + 10);
                    }
                    break;
                case 3:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setHealth(member.getHealth() + 10);
                        member.setMorale(member.getMorale() + 10);
                    }
                    break;
                case 4:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() - 10);
                    }
                    break;
                case 5:
                case 6:
                case 7:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() + 5);
                        member.setHealth(member.getHealth() + 5);
                        member.setThirst(member.getThirst() + 30);
                        member.setHunger(member.getHunger() + 30);
                    }
                    break;
                case 8:
                case 9:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() + 10);
                    }
                    break;
                case 10:
                case 11:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() + 10);
                        member.setHealth(member.getHealth() - 10);
                    }
                    break;
                case 12:
                case 13:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    for (FamilyMemberStatus member : dayCounterApp.getFamilyMembers()) {
                        member.setMorale(member.getMorale() + 5);
                    }
                    break;
                case 14:
                    journalTextArea.setText(pagesByDay[currentDay - 1].get(1));
                    updateFamilyMemberStatus();
                    goToWinningStoryButton.setVisible(true);
                    goToWinningStoryButton.setDisable(false);
                    journalStoryD1NOButton.setDisable(true);
                    journalStoryD1YESButton.setDisable(true);
                    goToDayCounterButton.setDisable(true);
                    break;
                default:
                    journalTextArea.setText("No text available for this day.");
                    break;
            }
            updateFamilyMemberStatus();
        }

        journalStoryD1NOButton.setVisible(false);
        journalStoryD1YESButton.setVisible(false);
        goToDayCounterButton.setVisible(true);
    }

    public void resetScrollPosition() {
        if (journalTextArea != null) {
            journalTextArea.setScrollTop(0); // Scroll to the top
        }
    }
}
