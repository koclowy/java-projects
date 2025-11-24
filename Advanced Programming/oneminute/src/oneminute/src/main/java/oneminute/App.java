package oneminute;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oneminute.classes.Audio;
import oneminute.classes.BaseController;
import oneminute.classes.DayCounterApp;

import java.io.IOException;

public class App extends Application {
    /*
        Exisiting username account:
        Username : user
        Password : 123
    */

    private static Scene scene;
    private static Stage primaryStage;
    private static Audio audioManager;
    private static DayCounterApp dayCounterApp; 

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        audioManager = new Audio();
        audioManager.playBackgroundMusic("game");
        audioManager.setBackgroundMusicVolume("game", 0.5);

        dayCounterApp = DayCounterApp.getInstance();  
        System.out.println("DayCounterApp initialized: " + dayCounterApp);

        Parent root = loadFXML("RegisterScreen");
        scene = new Scene(root, 960, 540);
        stage.setResizable(false);
        stage.setTitle("One Minute");
        stage.setScene(scene);
        stage.show();
    }    

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = loadFXMLLoader(fxml);
        Parent root = fxmlLoader.load();

        Object controller = fxmlLoader.getController();
        if (controller instanceof BaseController) {
            ((BaseController) controller).setDayCounterApp(dayCounterApp);
            System.out.println("DayCounterApp set in controller: " + dayCounterApp);
        }

        scene.setRoot(root);
    }

    private static FXMLLoader loadFXMLLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/oneminute/fxml/" + fxml + ".fxml"));
        if (fxmlLoader.getLocation() == null) {
            throw new IllegalStateException("FXML file " + fxml + " not found");
        }
        return fxmlLoader;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = loadFXMLLoader(fxml);
        Parent root = fxmlLoader.load();

        Object controller = fxmlLoader.getController();
        System.out.println("Loaded FXML Controller: " + controller);
        if (controller instanceof BaseController) {
            ((BaseController) controller).setDayCounterApp(dayCounterApp);
            System.out.println("(App) DayCounterApp set in controller: " + dayCounterApp);
        }

        return root;
    }


    //Getters
    public static Audio getAudioManager() {
        return audioManager; // Provide access to the audio manager
    }

    public static DayCounterApp getDayCounterApp() {
        return dayCounterApp;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
