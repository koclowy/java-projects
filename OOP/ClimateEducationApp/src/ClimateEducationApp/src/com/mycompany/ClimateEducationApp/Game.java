package com.mycompany.ClimateEducationApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import static com.mycompany.ClimateEducationApp.Home.arriveHome;

public class Game {
    // Declaring Game window components
    public static JFrame window;
    public static Container con;
    public static JPanel
            titleNamePanel,
            startButtonPanel,
            exitButtonPanel,
            mainTextPanel,
            choiceButtonPanel,
            playerPanel,
            gameOverTitlePanel,
            gameOverTextPanel,
            yesButtonPanel,
            noButtonPanel;
    public static JLabel
            titleNameLabel,
            timeLabel,
            timeLabelNumber,
            scoreLabel,
            scoreLabelNumber,
            gameOverTitleLabel;
    public static JButton
            startButton,
            exitButton,
            choice1,
            choice2,
            choice3,
            choice4,
            yesButton,
            noButton;
    public static JTextArea mainTextArea, gameOverTextArea;
    
    // Initializing fonts for text
    public static Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public static Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    public static Font exitFont = new Font("Times New Roman", Font.PLAIN, 10);
    
    // Declaring Game variables
    public static int 
            environmentalScore,
            timeCounter,
            mallScreenCounter,
            mallChoiceCounter,
            supermarketScreenCounter,
            supermarketChoiceCounter;
    public static String
            position,
            location,
            mealTime;
    public static boolean
            goneOut,
            tookBike, 
            tookCar, 
            tookPublic, 
            fullBelly, 
            ateAtHome, 
            ateAtMall, 
            ateAtSupermarket, 
            shoppedClothes, 
            shoppedPhone, 
            boughtGrocery;
    public static TitleScreenHandler tsHandler = new TitleScreenHandler();
    public static ChoiceHandler choiceHandler = new ChoiceHandler();
    
    // Game constructor
    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ONE  DAY");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 375, 200, 50);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setActionCommand("start");
        startButton.setFocusPainted(false);
        
        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(725, 15, 40, 50);
        exitButtonPanel.setBackground(Color.black);
        
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.setFont(exitFont);
        exitButton.addActionListener(tsHandler);
        exitButton.setActionCommand("exit");
        exitButton.setFocusPainted(false);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        exitButtonPanel.add(exitButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(exitButtonPanel);
    }
    
    // Create starting game screen
    public static void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false); 
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);
        
        choice1 = new JButton();
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        
        choice2 = new JButton();
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        
        choice3 = new JButton();
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        
        choice4 = new JButton();
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);
        
        timeLabel = new JLabel("TIME:");
        timeLabel.setForeground(Color.white);
        timeLabel.setFont(normalFont);
        playerPanel.add(timeLabel);
        
        timeLabelNumber = new JLabel();
        timeLabelNumber.setForeground(Color.white);
        timeLabelNumber.setFont(normalFont);
        playerPanel.add(timeLabelNumber);
        
        scoreLabel = new JLabel("SCORE:");
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(normalFont);
        playerPanel.add(scoreLabel);
        
        scoreLabelNumber = new JLabel();
        scoreLabelNumber.setForeground(Color.white);
        scoreLabelNumber.setFont(normalFont);
        playerPanel.add(scoreLabelNumber);
        
        gameSetup();
    }
    
    // Initializes game's variables
    public static void gameSetup() {
        timeCounter = 8;
        timeLabelNumber.setText(timeCounter + " AM");
        environmentalScore = 0;
        scoreLabelNumber.setText("" + environmentalScore);
        
        goneOut = false; 
        tookBike = true; 
        tookCar = true;
        tookPublic = true; 
        fullBelly = false; 
        ateAtHome = false; 
        ateAtMall = false; 
        ateAtSupermarket = false; 
        shoppedClothes = false;
        shoppedPhone = false; 
        boughtGrocery = false;
        
        mealTime = "breakfast";
        mallScreenCounter = 0;
        mallChoiceCounter = 0;
        supermarketScreenCounter = 0;
        supermarketChoiceCounter = 0;
        
        arriveHome();
    }
    
    // Toggles game over screen if user played long enough
    public static void showGameOverScreen() {
        if(timeCounter > 7 && timeLabelNumber.getText().contains("PM")) {
            playerPanel.setVisible(false);
            mainTextPanel.setVisible(false);
            choiceButtonPanel.setVisible(false);
            exitButtonPanel.setVisible(false);            
            
            gameOverTitlePanel = new JPanel();
            gameOverTitlePanel.setBounds(100, 100, 600, 150);
            gameOverTitlePanel.setBackground(Color.black);
            gameOverTitleLabel = new JLabel("GAME OVER");
            gameOverTitleLabel.setForeground(Color.white);
            gameOverTitleLabel.setFont(titleFont);

            gameOverTitlePanel.add(gameOverTitleLabel);
            con.add(gameOverTitlePanel);
            
            gameOverTextPanel = new JPanel();
            gameOverTextPanel.setBounds(100, 250, 600, 150);
            gameOverTextPanel.setBackground(Color.black);

            gameOverTextArea = new JTextArea();
            gameOverTextArea.setBounds(100, 100, 600, 150);
            gameOverTextArea.setBackground(Color.black);
            gameOverTextArea.setForeground(Color.white);
            gameOverTextArea.setFont(normalFont);
            gameOverTextArea.setText("It's already too late in the day... time to rest. "
                    + "You've achieved a highscore of " + scoreLabelNumber.getText() + "!"
                    + "\nWould you like to play again?");
            gameOverTextArea.setLineWrap(true);
            gameOverTextArea.setEditable(false);
            mainTextPanel.add(mainTextArea);

            gameOverTextPanel.add(gameOverTextArea);
            con.add(gameOverTextPanel);

            yesButtonPanel = new JPanel();
            yesButtonPanel.setBounds(200, 400, 200, 50);
            yesButtonPanel.setBackground(Color.black);
            yesButton = new JButton("YES");
            yesButton.setBackground(Color.black);
            yesButton.setForeground(Color.white);
            yesButton.setFont(normalFont);
            yesButton.addActionListener(tsHandler);
            yesButton.setActionCommand("restart");
            yesButton.setFocusPainted(false);
       
            yesButtonPanel.add(yesButton);
            con.add(yesButtonPanel);
            
            noButtonPanel = new JPanel();
            noButtonPanel.setBounds(400, 400, 200, 50);
            noButtonPanel.setBackground(Color.black);
            noButton = new JButton("NO");
            noButton.setBackground(Color.black);
            noButton.setForeground(Color.white);
            noButton.setFont(normalFont);
            noButton.addActionListener(tsHandler);
            noButton.setActionCommand("exit");
            noButton.setFocusPainted(false);
            
            noButtonPanel.add(noButton);            
            con.add(noButtonPanel);
        }
    }
}