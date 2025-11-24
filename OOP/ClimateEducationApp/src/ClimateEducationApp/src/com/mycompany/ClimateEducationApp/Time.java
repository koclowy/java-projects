package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.ateAtHome;
import static com.mycompany.ClimateEducationApp.Game.ateAtMall;
import static com.mycompany.ClimateEducationApp.Game.ateAtSupermarket;
import static com.mycompany.ClimateEducationApp.Game.fullBelly;
import static com.mycompany.ClimateEducationApp.Game.mealTime;
import static com.mycompany.ClimateEducationApp.Game.timeCounter;
import static com.mycompany.ClimateEducationApp.Game.timeLabelNumber;

public class Time {
    // Method for incrementing timeCounter depending on parameters
    public static void timePassed(int hour) {
        timeCounter += hour;
        
        // Updates time value in Game header
        if(timeCounter == 12) {
            timeLabelNumber.setText(timeCounter + " PM");
            timeCounter = 0;
        } else if(timeCounter > 12 && timeLabelNumber.getText().contains("AM")) {
            timeCounter -= 12;
            timeLabelNumber.setText(timeCounter + " PM");
        } else if(timeLabelNumber.getText().contains("AM")) {
            timeLabelNumber.setText(timeCounter + " AM");
        } else {
            timeLabelNumber.setText(timeCounter + " PM");
        }
        
        // Resets player hunger status if lunch or dinner time
        if(timeCounter > 5 && timeLabelNumber.getText().contains("PM")) {
            ateAtHome = false;
            ateAtMall = false;
            ateAtSupermarket = false;
            fullBelly = false;
            mealTime = "dinner";
        } else if((timeCounter < 6 && timeLabelNumber.getText().contains("PM")) || timeLabelNumber.getText().contains("12 PM")) {
            ateAtHome = false;
            ateAtMall = false;
            ateAtSupermarket = false;
            fullBelly = false;
            mealTime = "lunch";
        }
    }
}
