package com.mycompany.ClimateEducationApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenHandler implements ActionListener {
    // 
    public void actionPerformed(ActionEvent event) {
        // Initializes userChoice with button User chooses
        String userChoice = event.getActionCommand();
        
        // Performs action depending on User's button choice
        switch(userChoice) {
            case "start":
                Game.createGameScreen();
                break;
            case "exit":
                exitButtonActionPerformed(event);
                break;
            case "restart":
                Game.window.dispose();
                new Game();                
                break;                
        }
    }
    
    // Closes game and opens Home page
    public static void exitButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        UserInterface UI = new UserInterface();       
        UI.setVisible(true);            // Sets UI visibility to true
        UI.pack();                        // Packs UI frame
        UI.setLocationRelativeTo(null); // Centers UI on screen
        // Closes Game window
        Game.window.dispose();
    }
}