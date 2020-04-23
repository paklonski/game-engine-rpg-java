package application;

import static application.Constants.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;

/**
 * Manage the game by accepting key and mouse events from the user.
 * @author Pavel Paklonski
 */
public class Action {

    private final AnchorPane root = new AnchorPane();;
    private final Scene scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);
    private Canvas gameField;
    private final GMap map;
    private final Scenarios scenarios;
    private final Hero hero;
    private final Enemy enemy;

    /**
     * Create the instance of the playing field and set participants of the game to start this one
     * @param hero instance of the protagonist of the game
     * @param enemy instance of enemies of the game
     * @throws java.io.IOException
     */
    public Action(Hero hero, Enemy enemy) throws IOException {
        this.hero = hero;
        this.enemy = enemy;
        map = new GMap(hero.getName());
        scenarios = new Scenarios();
        scenarios.setMap(map);
        hero.setScenarios(scenarios);
        hero.setMap(map);
        enemy.setMap(map);
        setGameField(map.getGameField());
        root.getChildren().add(gameField);
        listen();
    }

    public void setGameField(Canvas canvas) {
        this.gameField = canvas;
    }

    public Scene getStartScene() {
        return scene;
    }

    /**
     * Listen to keyboard input and perform actions in the game.
     */
    private void listen() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                root.getChildren().clear();
                switch(event.getCode()) {
                    case W:
                        hero.moveUp();
                        enemy.move();
                        hero.checkEnemies();
                        break;
                    case A:
                        hero.moveLeft();
                        enemy.move();
                        hero.checkEnemies();
                        break;
                    case S:
                        hero.moveDown();
                        enemy.move();
                        hero.checkEnemies();
                        break;
                    case D:
                        hero.moveRight();
                        enemy.move();
                        hero.checkEnemies();
                        break;
                    case F:
                        hero.takeItem();
                        break;
                    case R:
                        hero.open();
                        break;
                    case LEFT:
                        hero.switchItems("LEFT");
                        break;
                    case RIGHT:
                        hero.switchItems("RIGHT");
                        break;
                    case ENTER:
                        hero.useItem();
                        break;
                    case F6:
                        try {
                            map.saveGame();
                            map.saveItems();
                            map.saveHealth();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case ESCAPE:
                        Main.switchScene(HeroesMenu.getHeroesMenu());
                        return;
                    default:
                        break;
                }
                root.getChildren().add(map.getGameField());
                Main.switchScene(scene);
            }
        });
    }

    /**
     * Create a new window if the player has finished the game.
     * @param mode variety of the end of the game
     * @throws java.io.FileNotFoundException
     */
    public static void makeDialog(String mode) throws FileNotFoundException {

        AnchorPane root = new AnchorPane();
        final Stage dialogStage = new Stage();
        Scene dialog = new Scene(root, DIALOG_WINDOW_WIDTH, DIALOG_WINDOW_HEIGHT);
        Canvas canvas = new Canvas(DIALOG_WINDOW_WIDTH, DIALOG_WINDOW_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        final ImageView returnButton = new ImageView();

        returnButton.setImage(new Image(new FileInputStream(PATH_IMAGE_RETURN_TO_MENU_BUTTON)));
        returnButton.setX(RETURN_BUTTON_COORDINATES[0]);
        returnButton.setY(RETURN_BUTTON_COORDINATES[1]);
        returnButton.setFitWidth(RETURN_BUTTON_WIDTH);
        returnButton.setFitHeight(RETURN_BUTTON_HEIGHT);
        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_DIALOG_BACKGROUNG)),0, 0,
                DIALOG_WINDOW_WIDTH, DIALOG_WINDOW_HEIGHT);

        if (mode.equals("GAMEOVER")) {
            graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_GAMEOVER)), GAMEOVER_IMAGE_COORDINATES[0],
                    GAMEOVER_IMAGE_COORDINATES[1], GAMEOVER_IMAGE_WIDTH, GAMEOVER_IMAGE_HEIGHT);
        } else if (mode.equals("CONGRATS")) {
            graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_CONGRATS)), CONGRATS_IMAGE_COORDINATES[0],
                    CONGRATS_IMAGE_COORDINATES[1], CONGRATS_IMAGE_WIDTH, CONGRATS_IMAGE_HEIGHT);
        }
        root.getChildren().addAll(canvas, returnButton);

        dialogStage.setScene(dialog);
        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(Main.getStage());
        dialogStage.show();

        MainMenu.showChoice(returnButton);
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    dialogStage.close();
                    Main.switchScene(new MainMenu().getMainMenu());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
