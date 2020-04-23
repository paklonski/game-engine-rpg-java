package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

/**
 * Czech Technical University in Prague
 * The Faculty of Electrical Engineering
 * The Department of Computer Science
 *
 * The RPG-game for children in the form of an arcade, which has one level with the possibility of expansion.
 * Developed as part of a semester project on the subject of B0B36PJV "Programming in JAVA".
 * Summer 2019
 *
 * @author Pavel Paklonski
 */
public class Main extends Application {

    public static Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        stage = primaryStage;
        stage.setTitle("Joueclub Game");
        stage.setScene(new MainMenu().getMainMenu());
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void switchScene(Scene scene) {
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}




