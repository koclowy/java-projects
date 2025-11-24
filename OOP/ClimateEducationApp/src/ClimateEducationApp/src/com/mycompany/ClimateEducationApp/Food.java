package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.ChoiceHandler.*;

public class Food {
    // Displays screen after a meal
    public static void goodMeal(String place) {
        fullBelly = true;
        position = "goodMeal" + place;
        mainTextArea.setText("Ahhh... that was a delicious meal. Let's see what else we can do.");

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
        
        // Modifies counter variables depending on location
        switch(place) {
            case "Mall":
                mallScreenCounter++;
                mallChoiceCounter++;
                ateAtMall = true;
                break;
            case "Supermarket":
                supermarketScreenCounter++;
                supermarketChoiceCounter++;
                ateAtSupermarket = true;
                break;
            case "Home":
                ateAtHome = true;
        }
    }
    
    // Displays screen for food choices at mall
    public static void foodMall() {
        enableAllButtons();
        position = "foodMall";
        mainTextArea.setText("You're starting to feel hungry... it's already time for " + mealTime + ".\nWhere do you feel like eating?");

        choice1.setText("Domino's Pizza");
        choice2.setText("Chipotle");
        choice3.setText("McDonald's");
        choice4.setText("<");
    }
    
    // Displays screen for food choices at supermarket
    public static void foodSupermarket() {
        enableAllButtons();
        position = "foodSupermarket";
        mainTextArea.setText("You're starting to feel hungry... it's already time for " + mealTime + ".\nWhere do you feel like eating?");

        choice1.setText("Local Cafe nearby");
        choice2.setText("Foreign restaurant");
        choice3.setText("Go to the mall");
        choice4.setText("<");
    }
    
    // Displays screen for food choices at home
    public static void foodHome() {
        enableAllButtons();
        position = "foodHome";
        mainTextArea.setText("What would you like to cook?");
        
        choice1.setText("Steak");
        choice2.setText("Vegetable Stir-Fry");
        choice3.setText("Cereal");
        choice4.setText("<");        
    }
}
