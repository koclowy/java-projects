package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.ChoiceHandler.*;
import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.Score.totalGroceryScore;

public class Supermarket {
    // Displays main Supermarket screen
    public static void arriveSupermarket() {        
        goneOut = true;
        location = "supermarket";
        
        resetButton(boughtGrocery, choice1);
        if(!fullBelly) {
            resetButton(ateAtSupermarket, choice2);
        } else {
            choice2.setEnabled(false);
        }
        
        position = "arriveSupermarket";
        if(supermarketChoiceCounter > 0) {
            mainTextArea.setText("Let's take a look around somewhere else.");
        } else {
            mainTextArea.setText("Giant is always a reliable and cheap supermarket. This time you came here to...");
        }
        
        choice1.setText("Buy groceries");
        choice2.setText("Eat " + mealTime);
        choice3.setText("Go home");
        choice4.setText("");
    }
    
    // Displays Tomato choice screen
    public static void buyTomato() {
        enableAllButtons();
        position = "buyTomato";
        mainTextArea.setText("Let's see... first thing's first are tomatoes. You recall still having some at home... should you still buy fresh ones?");
        
        choice1.setText("No. Use leftovers");
        choice2.setText("Buy local produce");
        choice3.setText("Buy with packaging");
        choice4.setText("<");
    }
    
    // Displays Cheese choice screen
    public static void buyCheese() {
        position = "buyCheese";
        mainTextArea.setText("Jerry, your roommate, asked you to buy some cheese. He doesn't care what type, but you usually prefer hard cheese.");
        
        choice1.setText("Hard Cheese");
        choice2.setText("Soft Cheese");
        choice3.setText("Vegan Cheese");
        choice4.setText("<");
    }
    
    // Displays Milk choice screen
    public static void buyMilk() {
        position = "buyMilk";
        mainTextArea.setText("Oh yeah... you've ran out of fresh milk back at your place. Better choose a good one if you want to eat cereal.");
        
        choice1.setText("Hazelnut Milk");
        choice2.setText("Soy Milk");
        choice3.setText("Dairy Milk");
        choice4.setText("<");
    }
    
    // Displays Meat choice screen
    public static void buyMeat() {
        position = "buyMeat";
        mainTextArea.setText("Last one on the list... meat!");
        
        choice1.setText("Lamb");
        choice2.setText("Chicken");
        choice3.setText("Beef");
        choice4.setText("<");
    }
    
    // Displays Bag choice screen
    public static void buyBag() {
        position = "buyBag";
        mainTextArea.setText("You head to the counter to pay for your groceries. The cashier asks if you prefer a paper bag or a plastic one. You reply...");
        
        choice1.setText("Plastic");
        choice2.setText("Paper");
        choice3.setText("<");
        choice4.setText("");
    }
    
    // Displays screen after player bought grocery
    public static void paidGrocery() {
        totalGroceryScore();
        boughtGrocery = true;
        
        position = "paidGrocery";
        mainTextArea.setText("Total is around... RM79. You should head back quick before the grocery gets bad.");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
}
