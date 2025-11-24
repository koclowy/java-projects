package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.Transport.*;
import static com.mycompany.ClimateEducationApp.ChoiceHandler.enableAllButtons;
import static com.mycompany.ClimateEducationApp.ChoiceHandler.resetButton;

public class Home {
    // Displays main Home screen
    public static void arriveHome() {
        // Resets variable values
        enableAllButtons();
        location = "home";
        tookCar = true;
        tookPublic = true;
        tookBike = true;        
        mallScreenCounter = 0;
        supermarketScreenCounter = 0;
        mallChoiceCounter = 0;
        supermarketChoiceCounter = 0;
        if(!fullBelly) {
            resetButton(ateAtHome, choice3);
        } else { choice3.setEnabled(false); }
        
        position = "arriveHome";
        if(!goneOut) {
            mainTextArea.setText("It's a brand new day! You have the day off so\nyou're feeling energetic. What shall we do today?");
        } else {
            mainTextArea.setText("Welcome back home. What else can we do?");
        }        
             
        choice1.setText("Head to the mall");
        choice2.setText("Go to supermarket");
        choice3.setText("Make " + mealTime);
        choice4.setText("Study climate change");
    }
    
    // Checks if mall has available choices before displaying mall screen
    public static void checkMallOptions(String position) {
        if(shoppedClothes && shoppedPhone && ateAtMall && fullBelly) {
            if(position.equals("arriveHome")) {
                choice1.setEnabled(false);
            } else { choice3.setEnabled(false); }
            mainTextArea.setText("There's nothing left to do at the mall. Check again later.");
        } else { toMall(); }
    }
    
    // Checks if supermarket has available choices before displaying supermarket screen
    public static void checkSupermarketOptions() {
        if(supermarketChoiceCounter >= 2 && fullBelly) {
            choice2.setEnabled(false);
            mainTextArea.setText("Done the groceries. Not feeling very hungry either...");
        } else { toSupermarket(); }
    }
}
