package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.Food.foodMall;
import static com.mycompany.ClimateEducationApp.ChoiceHandler.*;

public class Mall {
    // Displays main Mall screen
    public static void arriveMall() {
        goneOut = true;
        location = "mall";
        position = "arriveMall";
        
        if(!fullBelly) {
            resetButton(ateAtMall, choice1);
        } else { choice1.setEnabled(false); }
        resetButton(shoppedClothes, choice2);
        resetButton(shoppedPhone, choice3);
        
        if(mallChoiceCounter > 0) { 
            mainTextArea.setText("What else can we do?");
        } else {
            mainTextArea.setText("You've arrived at the mall.\nYour first action is to...");
        }

        choice1.setText("Eat " + mealTime);
        choice2.setText("Shop for clothes");
        choice3.setText("Shop for phone");
        choice4.setText("Go home");
    }
    
    // Checks if player is hungry before showing food choices
    public static void eatMall() {
        if(fullBelly) {
            mainTextArea.setText("You already ate " + mealTime + "! You're still full.");
            choice1.setEnabled(false);
        } else {
            if(!ateAtMall) { choice1.setEnabled(true); }
            foodMall();
        }
    }
    
    // Checks if player has shopped clothes before showing clothing choices
    public static void clothesChoice() {
        if(shoppedClothes) {
            mainTextArea.setText("Bought too much. Wouldn't want to spend all your allowance in a day, right?");
            choice2.setEnabled(false);
        } else {
            enableAllButtons();
            position = "clothesChoice";
            mainTextArea.setText("You got the budget, just not the style. Which will it be?");

            choice1.setText("H&M");
            choice2.setText("Nike");
            choice3.setText("Prada");
            choice4.setText("<");
        }
    }
    
    // Displays screen after player has shopped clothes
    public static void choseClothes() {
        enableAllButtons();
        mallScreenCounter++;
        shoppedClothes = true;
        
        position = "choseClothes";
        mainTextArea.setText("That'll cover the new few months of your fashion... let's see what else we can do.");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Checks if player has shopped phone before showing phone choices
    public static void phoneChoice() {
        if(shoppedPhone) {
            mainTextArea.setText("You've already bought a phone! How many do you need?!");
            choice3.setEnabled(false);
        } else { 
            enableAllButtons();
            position = "phoneChoice";
            mainTextArea.setText("Your current phone is already 10 years old... time to buy a new one. iPhone sounds good, but which model?");

            choice1.setText("iPhone X");
            choice2.setText("iPhone 13 PRO MAX");
            choice3.setText("iPhone 15");
            choice4.setText("<"); 
        }
    }
    
    // Displays screen after player has shopped phone
    public static void chosePhone() {
        enableAllButtons();
        mallScreenCounter++;
        shoppedPhone = true;
        
        position = "chosePhone";
        mainTextArea.setText("That was a bit of a hefty price... let's see what else we can do.");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
}
