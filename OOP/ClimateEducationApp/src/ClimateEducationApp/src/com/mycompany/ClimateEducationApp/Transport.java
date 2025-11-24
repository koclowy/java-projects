package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.ChoiceHandler.*;

public class Transport {
    // Displays Transport Choice screen
    public static void setTransportChoice() {
        enableAllButtons();
        resetButton(!tookCar, choice1);
        resetButton(!tookPublic, choice2);
        resetButton(!tookBike, choice3);
        mainTextArea.setText("How are you going there?");
        
        choice1.setText("Self-drive");
        choice2.setText("Public Transport");
        choice3.setText("Bicycle");
        choice4.setText("<");        
    }
    
    // Sets position for Mall destination
    public static void toMall() {
        position = "toMall";
        setTransportChoice();
    }
    
    // Sets position for Supermarket destination
    public static void toSupermarket() {
        position = "toSupermarket";
        setTransportChoice();
    }
    
    // Sets position for Home destination
    public static void toHome() {
        // Checks if user has just arrived before going back home
        if(position.equals("arriveMall" ) && mallChoiceCounter == 0) {
                mainTextArea.setText("You just got here! It's way too early to go home\nright now. Go do something else.");
                choice4.setEnabled(false);                
        } else if(position.equals("arriveSupermarket") && supermarketChoiceCounter == 0) {
                mainTextArea.setText("You just got here! It's way too early to go home\nright now. Go do something else.");
                choice3.setEnabled(false);
        } else {
            position = "toHome";
            setTransportChoice();
        }
    }
}
