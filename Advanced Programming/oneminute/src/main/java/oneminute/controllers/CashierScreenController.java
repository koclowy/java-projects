package oneminute.controllers;

import java.io.IOException;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import oneminute.App;
import oneminute.classes.*;

public class CashierScreenController extends BaseController{

    @FXML private Button pauseButton;
    @FXML private Button startButton;
    @FXML private TilePane cashierinventoryTilePane;

    @FXML
    public void initialize() {
        App.getAudioManager().playSoundEffect("cashierRegister");
    }

    public void setSelectedItems(List<Button> items, List<Point2D> positions) {
        System.out.println("Setting selected items...");

        for (int i = 0; i < items.size(); i++) {
            Button item = items.get(i);
            Point2D position = positions.get(i);
            item.setLayoutX(position.getX());
            item.setLayoutY(position.getY());
            cashierinventoryTilePane.getChildren().add(item);

            System.out.println("Added item at position: " + position);
        }
    }

    @FXML
    void switchToDayCounterScreen(MouseEvent event) throws IOException {
        App.getAudioManager().playSoundEffect("buttonStart");
        System.out.println("(Cashier Screen) Start button clicked! Switching to Day Counter Screen.");
        
        // Proceed to DayCounterScreen
        App.setRoot("DayCounterScreen");
    }
}

