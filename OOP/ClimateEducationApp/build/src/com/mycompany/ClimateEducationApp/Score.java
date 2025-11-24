package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.*;
import static com.mycompany.ClimateEducationApp.Mall.*;
import static com.mycompany.ClimateEducationApp.Supermarket.*;
import static com.mycompany.ClimateEducationApp.Home.arriveHome;
import static com.mycompany.ClimateEducationApp.Food.goodMeal;
import static com.mycompany.ClimateEducationApp.Time.timePassed;

public class Score {
    // Declare variables for grocery scoring
    public static int tomato;
    public static int cheese;
    public static int milk;
    public static int meat;
    public static int bag;
    
    // Updates header data in game
    public static void updateScore() {
        scoreLabelNumber.setText("" + environmentalScore);
    }
    
    // Updates score from transport choice
    public static void transportScore(String position, String transport) {
        timePassed(1);
        switch(transport) {
            case "Self-drive":
                tookCar = true;
                tookPublic = false;
                tookBike = false;
                environmentalScore += 1;              
                break;
            case "Public Transport":
                tookCar = false;
                tookPublic = true;
                tookBike = false;
                environmentalScore += 5;
                break;                
            case "Bicycle":
                tookCar = false;
                tookPublic = false;
                tookBike = true;
                environmentalScore += 9;
                break;
        }
        
        // Displays screen depending on location
        switch(position) {
            case "toMall":
                arriveMall();
                break;
            case "toSupermarket":
                arriveSupermarket();
                break;
            case "toHome":
                arriveHome();
                break;
        }
    }
    
    // Updates score from food choice
    public static void foodScore(String position, String food) {
        timePassed(1);
        // Different scores for different locations
        switch(position) {
            case "foodMall":
                switch(food) {
                    case "Domino's Pizza":
                        environmentalScore += 1;
                        break;
                    case "Chipotle":
                        environmentalScore += 9;
                        break;
                    case "McDonald's":
                        environmentalScore += 5;
                        break;
                }
                goodMeal("Mall");
                break;
                
            case "foodSupermarket":
                switch(food) {
                    case "Local Cafe nearby":
                        environmentalScore += 8;
                        break;
                    case "Foreign restaurant":
                        environmentalScore += 2;
                        break;
                }
                goodMeal("Supermarket");
                break;
                
            case "foodHome":
                switch(food) {
                    case "Steak":
                        environmentalScore += 1;
                        break;
                    case "Vegetable Stir-Fry":
                        environmentalScore += 7;
                        break;
                    case "Cereal":
                        environmentalScore += 7;
                        break;
                }
                goodMeal("Home");
                break;
        }
    }
    
    // Updates score from clothes choice
    public static void clothesScore(String brand) {
        timePassed(2);
        switch(brand) {
            case "H&M":
                environmentalScore += 5;
                break;
            case "Nike":
                environmentalScore += 9;
                break;
            case "Prada":
                environmentalScore += 1;
                break;
        }
        mallChoiceCounter++;
        choseClothes();
    }
    
    // Updates score from phone choice
    public static void phoneScore(String model) {
        timePassed(2);
        switch(model) {
            case "iPhone 10":
                environmentalScore += 9;
                break;
            case "iPhone 13 PRO MAX":
                environmentalScore += 5;
                break;
            case "iPhone 15":
                environmentalScore += 1;
                break;
        }
        mallChoiceCounter++;
        chosePhone();
    }
    
    // Updates score from tomato choice
    public static void tomatoScore(String tomatoChoice) {
        switch(tomatoChoice) {
            case "No. Use leftovers":
                tomato = 9;
                break;
            case "Buy local produce":
                tomato = 5;
                break;
            case "Buy with packaging":
                tomato = 1;
                break;
        }
        buyCheese();
    }

    // Updates score from cheese choice
    public static void cheeseScore(String cheeseChoice) {
        switch(cheeseChoice) {
            case "Hard Cheese":
                cheese = 1;
                break;
            case "Soft Cheese":
                cheese = 5;
                break;
            case "Vegan Cheese":
                cheese = 9;
                break;
        }
        buyMilk();
    }

    // Updates score from milk choice
    public static void milkScore(String milkChoice) {
        switch(milkChoice) {
            case "Hazelnut Milk":
                milk = 5;
                break;
            case "Soy Milk":
                milk = 9;
                break;
            case "Dairy Milk":
                milk = 1;
                break;
        }
        buyMeat();
    }
            
    // Updates score from meat score
    public static void meatScore(String meatChoice) {
        switch(meatChoice) {
            case "Lamb":
                meat = 1;
                break;
            case "Chicken":
                meat = 9;
                break;
            case "Beef":
                meat = 5;
                break;
        }
        buyBag();
    }
            
    // Updates score from grocery bag choice
    public static void bagScore(String bagChoice) {
        switch(bagChoice) {
            case "Plastic":
                bag = 1;
                break;
            case "Paper":
                bag = 10;
                break;
        }
        paidGrocery();
    }
    
    // Calculates total score from grocery choices
    public static void totalGroceryScore() {
        timePassed(3);
        boughtGrocery = true;
        supermarketScreenCounter++;
        supermarketChoiceCounter++;
        environmentalScore += (tomato + cheese + milk + meat + bag);
    }
}
