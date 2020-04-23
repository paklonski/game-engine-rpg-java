package application;

import static application.Constants.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Create a window for a choosing of the main Hero.
 * @author Pavel Paklonski
 */
public class HeroesMenu {

    private final AnchorPane root;
    private static Scene scene;
    private final Canvas canvas;
    private final GraphicsContext graphicsContext;
    private final List<ImageView> buttonsOfHeroesMenu;
    private final ImageView kevinButton = new ImageView();
    private final ImageView oliviaButton = new ImageView();
    private final ImageView jacobButton = new ImageView();

    /**
     * Create an instance of HeroesMenu.
     * @throws java.io.FileNotFoundException
     */
    public HeroesMenu() throws FileNotFoundException {
        root = new AnchorPane();
        scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);
        canvas = new Canvas(STAGE_WIDTH, STAGE_HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        buttonsOfHeroesMenu = Arrays.asList(kevinButton, oliviaButton, jacobButton);
        createMenu();
        listen();
    }

    public static Scene getHeroesMenu() {
        return scene;
    }

    /**
     * Create the menu buttons, set a background.
     */
    private void createMenu() throws FileNotFoundException {
        kevinButton.setImage(new Image(new FileInputStream(PATH_IMAGE_KEVIN_BUTTON)));
        setButton(kevinButton, HEROES_MENU_LEFT_BORDER_LINE,
                HEROES_MENU_TOP_BORDER_LINE, HEROES_MENU_BUTTON_WIDTH, HEROES_MENU_BUTTON_HEIGHT);

        oliviaButton.setImage(new Image(new FileInputStream(PATH_IMAGE_OLIVIA_BUTTON)));
        setButton(oliviaButton, HEROES_MENU_LEFT_BORDER_LINE + HEROES_MENU_BUTTON_WIDTH +
                        HEROES_MENU_DISTANCE_BETWEEN_BUTTONS, HEROES_MENU_TOP_BORDER_LINE,
                HEROES_MENU_BUTTON_WIDTH, HEROES_MENU_BUTTON_HEIGHT);

        jacobButton.setImage(new Image(new FileInputStream(PATH_IMAGE_JACOB_BUTTON)));
        setButton(jacobButton, HEROES_MENU_LEFT_BORDER_LINE + 2 * HEROES_MENU_BUTTON_WIDTH +
                        2 * HEROES_MENU_DISTANCE_BETWEEN_BUTTONS, HEROES_MENU_TOP_BORDER_LINE,
                HEROES_MENU_BUTTON_WIDTH, HEROES_MENU_BUTTON_HEIGHT);

        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_BACKGROUNG)),
                0, 0, STAGE_WIDTH, STAGE_HEIGHT);

        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_LOGO)), LOGO_LEFT_BORDER_LINE,
                LOGO_TOP_BORDER_LINE, LOGO_WIDTH, LOGO_HEIGHT);

        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_TEXT)), HEROES_MENU_TEXT_COORDINATES[0],
                HEROES_MENU_TEXT_COORDINATES[1]);

        root.getChildren().addAll(canvas, kevinButton, oliviaButton, jacobButton);
    }

    /**
     * Listen to user's mouse input to select the hero.
     */
    public void listen() {

        for(ImageView button : buttonsOfHeroesMenu) {
            MainMenu.showChoice(button);
        }

        kevinButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Hero hero = new Hero("Kevin");
                    Enemy enemy = new Enemy();
                    Action action = new Action(hero, enemy);
                    Main.switchScene(action.getStartScene());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        oliviaButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Hero hero = new Hero("Olivia");
                    Enemy enemy = new Enemy();
                    Action action = new Action(hero, enemy);
                    Main.switchScene(action.getStartScene());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jacobButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Hero hero = new Hero("Jacob");
                    Enemy enemy = new Enemy();
                    Action action = new Action(hero, enemy);
                    Main.switchScene(action.getStartScene());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    Main.switchScene(MainMenu.getMainMenu());
                }
            }
        });
    }

    /**
     * Set a style of buttons on the Heroes Menu
     * @param button the image of a button
     * @param LayoutX the offset X
     * @param LayoutY the offset Y
     * @param buttonWidth the width of a button
     * @param buttonHeight the height of a button
     */
    private void setButton(ImageView button, int LayoutX, int LayoutY, int buttonWidth, int buttonHeight) {

        button.setX(LayoutX);
        button.setY(LayoutY);
        button.setFitWidth(buttonWidth);
        button.setFitHeight(buttonHeight);
    }
}