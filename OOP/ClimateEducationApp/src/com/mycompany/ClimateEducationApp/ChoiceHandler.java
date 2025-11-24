package com.mycompany.ClimateEducationApp;

import javax.swing.JButton;
import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.Mall.*;
import static com.mycompany.ClimateEducationApp.Supermarket.*;
import static com.mycompany.ClimateEducationApp.Score.*;
import static com.mycompany.ClimateEducationApp.Home.*;
import static com.mycompany.ClimateEducationApp.Food.*;
import static com.mycompany.ClimateEducationApp.Transport.*;
import static com.mycompany.ClimateEducationApp.Time.timePassed;
import static com.mycompany.ClimateEducationApp.Study.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {
    /**
     *
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // Initializes userChoice with button User chooses
        String userChoice = event.getActionCommand();
        
        // Performs action depending on current game page
        switch(position) {
            case "arriveHome":
                switch(userChoice) {
                    case "c1":
                        checkMallOptions(position);
                        break;
                    case "c2":
                        checkSupermarketOptions();
                        break;
                    case "c3": 
                         if(fullBelly) {
                             mainTextArea.setText("You're still full... maybe some other time.");
                             choice3.setEnabled(false);
                         } else { foodHome(); }
                        break;
                    case "c4":
                        study();
                        break;
                }
                break;
            
            case "toMall":
                switch(userChoice) {
                    case "c1":
                        transportScore(position, choice1.getText());
                        break;
                    case "c2": 
                        transportScore(position, choice2.getText());
                        break;
                    case "c3": 
                        transportScore(position, choice3.getText());
                        break;
                    case "c4":
                        arriveHome();
                        break;
                }
                break;

            case "arriveMall":
                switch(userChoice) {
                    case "c1":
                        eatMall();
                        break;
                    case "c2":
                        clothesChoice();
                        break;
                    case "c3":
                        phoneChoice();
                        break;
                    case "c4":
                        toHome();
                        break;
                }
                break;

            case "foodMall":
                switch(userChoice) {
                    case "c1":
                        foodScore(position, choice1.getText());
                        break;
                    case "c2":
                        foodScore(position, choice2.getText());
                        break;
                    case "c3":
                        foodScore(position, choice3.getText());
                        break;
                    case "c4":
                        arriveMall();
                        break;
                }
                break;

            case "toSupermarket":
                switch(userChoice) {
                    case "c1":
                        transportScore(position, choice1.getText());
                        break;
                    case "c2": 
                        transportScore(position, choice2.getText());
                        break;
                    case "c3": 
                        transportScore(position, choice3.getText());
                        break;
                    case "c4":
                        arriveHome();
                        break;
                }
                break;
            
            case "arriveSupermarket":
                switch(userChoice) {
                    case "c1":
                        if(boughtGrocery) {
                            mainTextArea.setText("You still have groceries at home!");
                            choice1.setEnabled(false);
                        } else { buyTomato(); }
                        break;
                    case "c2":
                        foodSupermarket();
                        break;
                    case "c3":
                        toHome();
                        break;
                }
                break;
                
            case "buyTomato":
                switch(userChoice) {
                    case "c1":
                        tomatoScore(choice1.getText());
                        break;
                    case "c2":
                        tomatoScore(choice2.getText());
                        break;
                    case "c3":
                        tomatoScore(choice3.getText());
                        break;
                    case "c4":
                        arriveSupermarket();
                        break;
                }
                break;
                
            case "buyCheese":
                switch(userChoice) {
                    case "c1":
                        cheeseScore(choice1.getText());
                        break;
                    case "c2":
                        cheeseScore(choice2.getText());
                        break;
                    case "c3":
                        cheeseScore(choice3.getText());
                        break;
                    case "c4":
                        buyTomato();
                        break;
                }
                break;
                
            case "buyMilk":
                switch(userChoice) {
                    case "c1":
                        milkScore(choice1.getText());
                        break;
                    case "c2":
                        milkScore(choice2.getText());
                        break;
                    case "c3":
                        milkScore(choice3.getText());
                        break;
                    case "c4":
                        buyCheese();
                        break;
                }
                break;
                
            case "buyMeat":
                switch(userChoice) {
                    case "c1":
                        meatScore(choice1.getText());
                        break;
                    case "c2":
                        meatScore(choice2.getText());
                        break;
                    case "c3":
                        meatScore(choice3.getText());
                        break;
                    case "c4":
                        buyMilk();
                        break;
                }
                break;
                
            case "buyBag":
                switch(userChoice) {
                    case "c1":
                        bagScore(choice1.getText());
                        break;
                    case "c2":
                        bagScore(choice2.getText());
                        break;
                }
                break;
                
            case "paidGrocery":
                switch(userChoice) {
                    case "c1":
                        arriveSupermarket();
                        break;
                }
                break;
                
            case "foodSupermarket":
                switch(userChoice) {
                    case "c1":
                        foodScore(position, choice1.getText());
                        break;
                    case "c2":
                        foodScore(position, choice2.getText());
                        break;
                    case "c3":
                        checkMallOptions(position);
                        break;
                    case "c4":
                        arriveSupermarket();
                        break;
                }
                break;
                
            case "toHome":
                switch(userChoice) {
                    case "c1":
                        transportScore(position, choice1.getText());
                        break;
                    case "c2": 
                        transportScore(position, choice2.getText());
                        break;
                    case "c3": 
                        transportScore(position, choice3.getText());
                        break;
                    case "c4":
                        if(location.equals("mall")) {
                            arriveMall();
                        } else { arriveSupermarket(); }
                        break;
                }
                break;

            case "goodMealMall":
                switch(userChoice) {
                    case "c1":
                        arriveMall();
                }
                break;
                
            case "goodMealSupermarket":
                switch(userChoice) {
                    case "c1":
                        arriveSupermarket();
                        break;
                }
                break;
                
            case "clothesChoice":
                switch(userChoice) {
                    case "c1":
                        clothesScore(choice1.getText());
                        break;                        
                    case "c2":
                        clothesScore(choice2.getText());
                        break;                        
                    case "c3":
                        clothesScore(choice3.getText());
                        break;                        
                    case "c4":
                        arriveMall();
                        break;
                }
                break;
            
            case "choseClothes":
                switch(userChoice) {
                    case "c1":
                        arriveMall();
                        break;
                }
                break;
            
            case "phoneChoice":
                switch(userChoice) {
                    case "c1":
                        phoneScore(choice1.getText());
                        break;                        
                    case "c2":
                        phoneScore(choice2.getText());
                        break;                        
                    case "c3":
                        phoneScore(choice3.getText());
                        break;
                    case "c4":
                        arriveMall();
                        break;
                }
                break;
                
            case "chosePhone":
                switch(userChoice) {
                    case "c1":
                        arriveMall();
                        break;
                }
                break;
                
            case "foodHome":
                switch(userChoice) {
                    case "c1":
                        foodScore(position, choice1.getText());
                        break;
                    case "c2":
                        foodScore(position, choice2.getText());
                        break;
                    case "c3":
                        if(!boughtGrocery) {
                            mainTextArea.setText("Oh no, You've run out of milk! Maybe you should go buy some.");
                            choice3.setEnabled(false);
                        } else { foodScore(position, choice3.getText()); }
                        break;
                    case "c4":
                        arriveHome();
                        break;
                }
                break;
                
            case "goodMealHome":
                switch(userChoice) {
                    case "c1":
                        arriveHome();
                        break;
                }
                break;
                
            case "study":
                switch(userChoice) {
                    case "c1":
                        foodPage1();
                        break;
                    case "c2":
                        transportPage();
                        break;
                    case "c3":
                        shoppingPage1();
                        break;
                    case "c4":
                        arriveHome();
                        break;
                }
                break;
                
            case "foodPage1":
                switch(userChoice) {
                    case "c1":
                        foodPage2();
                        break;
                }
                break;
                
            case "foodPage2":
                switch(userChoice) {
                    case "c1":
                        foodPage3();
                        break;
                    case "c2":
                        foodPage1();
                        break;
                }
                break;
            
            case "foodPage3":
                switch(userChoice) {
                    case "c1":
                        foodPage4();
                        break;
                    case "c2":
                        foodPage2();
                        break;
                }
                break;
                
            case "foodPage4":
                switch(userChoice) {
                    case "c1":
                        study();
                        timePassed(3);
                        break;
                    case "c2":
                        foodPage3();
                }
                break;
            
            case "transportPage":
                switch(userChoice) {
                    case "c1":
                        study();
                        timePassed(2);
                        break;
                }
                break;
                
            case "shoppingPage1":
                switch(userChoice) {
                    case "c1":
                        shoppingPage2();
                        break;
                }
                break;
            
            case "shoppingPage2":
                switch(userChoice) {
                    case "c1":
                        shoppingPage3();
                        break;
                    case "c2":
                        shoppingPage1();
                        break;
                }
                break;
                
            case "shoppingPage3":
                switch(userChoice) {
                    case "c1":
                        study();
                        timePassed(3);
                        break;
                    case "c2":
                        shoppingPage2();
                        break;
                }
                break;
        }
        updateScore();
        showGameOverScreen();
    }
    
    // Enables/disables button depending on boolean variable
    public static void resetButton(boolean check, JButton buttonChoice) {
        if(check) { 
            buttonChoice.setEnabled(false);
        } else { buttonChoice.setEnabled(true); }
    }
    
    // Enables all buttons
    public static void enableAllButtons() {
        choice1.setEnabled(true);
        choice2.setEnabled(true);
        choice3.setEnabled(true);
        choice4.setEnabled(true);
    }
}
