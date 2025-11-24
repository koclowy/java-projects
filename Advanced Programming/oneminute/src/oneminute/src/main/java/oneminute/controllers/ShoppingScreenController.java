package oneminute.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import oneminute.App;
import oneminute.classes.*;
import oneminute.lists.*;

public class ShoppingScreenController {
    private ArrayList<Item> itemList;
    private Inventory inventory = new Inventory();

    private List<Button> selectedItems = new ArrayList<>();
    private List<Point2D> itemPositions = new ArrayList<>();
    private int seconds = 62;

    private Timeline timeline;

    @FXML private TilePane tilePane1;
    @FXML private TilePane tilePane2;
    @FXML private TilePane inventoryTilePane;
    @FXML private Label itemDescription;
    @FXML private Label itemName;
    @FXML private Label timerLabel;
    @FXML private Button button_arrowRight;

    @FXML
    public void initialize() {
        App.getAudioManager().playBackgroundMusic("shopping");
        App.getAudioManager().setBackgroundMusicVolume("shopping", 0.5);
        try {
            itemList = new ItemList().getItemList(); // Initialize itemList
            loadImagesFromArrayList();
            startTimer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load images into children of TilePane based on itemList
    public void loadImagesFromArrayList() {
        if (itemList == null) {
            System.err.println("Item list is null. Initialization failed.");
            return;
        }

        for (int i = 0; i < 12; i++) {
            if (i < tilePane1.getChildren().size()) {
                Item item = itemList.get(i);
                if (tilePane1.getChildren().get(i) instanceof Button) {
                    Button button = (Button) tilePane1.getChildren().get(i);
                    updateButtonWithImage(button, item);
                }
            }
        }

        for (int i = 12; i < 24; i++) {
            int indexInPane2 = i - 12;
            if (indexInPane2 < tilePane2.getChildren().size()) {
                Item item = itemList.get(i);
                if (tilePane2.getChildren().get(indexInPane2) instanceof Button) {
                    Button button = (Button) tilePane2.getChildren().get(indexInPane2);
                    updateButtonWithImage(button, item);
                }
            }
        }
    }

    private void updateButtonWithImage(Button button, Item item) {
        if (inventoryTilePane.getChildren().size() >= 8) {
            System.out.println("Inventory is full. Cannot add more items.");
            return;
        }
        try {
            Image image = new Image(getClass().getResource(item.getItemUrl()).toExternalForm());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);
            button.setGraphic(imageView);
            button.setUserData(item);

            Tooltip tooltip = new Tooltip(item.getDescription());
            Tooltip.install(button, tooltip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void moveItemToInventory(Button itemButton) {
        TilePane parentPane = (TilePane) itemButton.getParent();
        if (parentPane != null) {
            parentPane.getChildren().remove(itemButton);
        }
        inventoryTilePane.getChildren().add(itemButton);
        Object userData = itemButton.getUserData();
        if (userData instanceof Item) {
            Item item = (Item) userData;
            inventory.addItem(item);
        }
    }

    @FXML
    private void handleButtonClick(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        moveItemToInventory(clickedButton);
    }

    @FXML
    private void handleMouseEnter(MouseEvent event) {
        Button hoveredButton = (Button) event.getSource();
        Item item = (Item) hoveredButton.getUserData();
        if (item != null) {
            itemDescription.setText(item.getDescription());
            itemName.setText(item.getItemname());
        }
    }

    @FXML
    private void handleMouseExit(MouseEvent event) {
        itemDescription.setText("");
        itemName.setText("");
    }

    @FXML
    private void handleItemClick(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (!selectedItems.contains(clickedButton)) {
            selectedItems.add(clickedButton);
        } else {
            selectedItems.remove(clickedButton);
        }
    }

    // settings for timer
    private void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (seconds > 0) {
                seconds--;
                timerLabel.setText(formatTime(seconds));
            } else {
                switchToCashierScreen();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private String formatTime(int seconds) {
        return String.valueOf(seconds);
    }

    //settings for switching scenes
    @FXML
    public void switchToCashierScreen() {
        App.getAudioManager().playBackgroundMusic("game");
        if (timeline != null) {
            timeline.stop();
        }
        try {
            System.out.println("(ShoppingScreen) Timer ended! Automatically switching to Cashier Screen.");
            App.setRoot("CashierScreen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleArrowClick(MouseEvent event) {
        App.getAudioManager().playSoundEffect("buttonTick");
        System.out.println("(Shopping Screen) Right Arrow Button Clicked! Switching to Cashier Screen.");
        switchToCashierScreen();
    }
}
