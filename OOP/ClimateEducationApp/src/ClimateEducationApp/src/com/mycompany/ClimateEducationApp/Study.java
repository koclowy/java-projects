package com.mycompany.ClimateEducationApp;

import static com.mycompany.ClimateEducationApp.Game.choice1;
import static com.mycompany.ClimateEducationApp.Game.choice2;
import static com.mycompany.ClimateEducationApp.Game.choice3;
import static com.mycompany.ClimateEducationApp.Game.choice4;
import static com.mycompany.ClimateEducationApp.Game.mainTextArea;
import static com.mycompany.ClimateEducationApp.Game.position;
import static com.mycompany.ClimateEducationApp.ChoiceHandler.enableAllButtons;

public class Study {
    // Displays screen for studying
    public static void study() {
        enableAllButtons();
        position = "study";
        mainTextArea.setText("Which area of Climate Change would you like to study about?");
        
        choice1.setText("Food");
        choice2.setText("Transport");
        choice3.setText("Shopping");
        choice4.setText("Go back");
    }
    
    // Displays page 1 of food study topic
    public static void foodPage1() {
        enableAllButtons();
        position = "foodPage1";
        mainTextArea.setText("""
                             Regarding meat, lamb produces an average of
                             20.44kg of C02 emissions/kg of product. Beef,
                             5kg fewer C02 emissions/kg than lamb.
                             Chicken however comes out on top, producing
                             only 2.33 kg of C02/kg.""");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays page 2 of food study topic
    public static void foodPage2() {
        position = "foodPage2";
        mainTextArea.setText("""
                             Dairy requires 9x more land than any
                             plant-based milk. Hazelnut milk thrives on rain and sequester carbon, creating a net benefit for
                             the climate. Oat milk and soy milk is tied for
                             most environment friendly milk!""");
        
        choice1.setText(">");
        choice2.setText("<");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays page 3 of food study topic
    public static void foodPage3() {
        position = "foodPage3";
        mainTextArea.setText("""
                             The carbon footprint of cheese is almost double
                             that of chicken. Soft cheese and plant-based
                             alternatives generally have a smaller footprint.
                             Hard cheese usually requires more milk than
                             soft, which means higher emissions associated
                             with livestock and farming.""");
        
        choice1.setText(">");
        choice2.setText("<");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays page 4 of food study topic
    public static void foodPage4() {
        position = "foodPage4";
        mainTextArea.setText("""
                             When shopping for tomatoes, consider buying
                             locally, as demand for local produce reduces
                             food miles and lessens greenhouse gas emission.
                             Opting for packaging-free produce is also a
                             good alternative.
                             """);
        
        choice1.setText("Read another topic");
        choice2.setText("<");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays transport study topic page
    public static void transportPage() {
        enableAllButtons();
        position = "transportPage";
        mainTextArea.setText("""
                             Transportation takes up to 1/5th of global
                             greenhouse gas emissions. Public transportation
                             is advised due to simple efficiency:
                             buses and trains can carry substantially more
                             than a single car.""");
        
        choice1.setText("Read another topic");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays page 1 of shopping study topic
    public static void shoppingPage1() {
        enableAllButtons();
        position = "shoppingPage1";
        mainTextArea.setText("""
                             Some businesses adopt sustainable practices.
                             For clothing brands, the ones leading the
                             fray are Nike, Adidas and Levi's, followed by
                             H&M as the middle tier. Puma and Uniqlo rank 
                             the worst of all.""");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays page 2 of shopping study topic
    public static void shoppingPage2() {
        position = "shoppingPage2";
        mainTextArea.setText("""
                             Even buying a new phone contributes to climate
                             change. Frequent changes and upgrades drives
                             the purchase of newer models and vice versa.
                             The issue lies not with the technology, but the
                             manufacturing process.""");
        
        choice1.setText(">");
        choice2.setText("<");
        choice3.setText("");
        choice4.setText("");
    }
    
    // Displays page 3 of shopping study topic
    public static void shoppingPage3() {
        position = "shoppingPage3";
        mainTextArea.setText("""
                             Regarding fast food, most of Taco Bell's are
                             recycleable, goal of all by 2025. Chipotle
                             tracks the footprint for each digital order.
                             McDonald’s have taken steps to find a
                             renewable solution for their waste.""");
        
        choice1.setText("Read another topic");
        choice2.setText("<");
        choice3.setText("");
        choice4.setText("");
    }
}
