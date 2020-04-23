package application;

import static application.Constants.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * Create a window for a choosing of the game mode.
 * @author Pavel Paklonski
 */
public class MainMenu {

    private final AnchorPane root;
    private static Scene scene;
    private final Canvas canvas;
    private final GraphicsContext graphicsContext;
    private final List<ImageView> buttonsOfMainMenu;
    private final ImageView newGameButton = new ImageView();
    private final ImageView loadLastGameButton = new ImageView();
    private final ImageView helpButton = new ImageView();
    private final ImageView exitButton = new ImageView();
    private static String modeOfGame;

    /**
     * Create an instance of the main menu with an ability to select downloading of a new game, saved game and help.
     * @throws java.io.FileNotFoundException
     */
    public MainMenu() throws FileNotFoundException {

        root = new AnchorPane();
        scene = new Scene(root, STAGE_WIDTH, STAGE_HEIGHT);
        canvas = new Canvas(STAGE_WIDTH, STAGE_HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();
        buttonsOfMainMenu = Arrays.asList(newGameButton, loadLastGameButton, helpButton, exitButton);
        createMenu();
        listen();
    }

    public static Scene getMainMenu() {
        return scene;
    }

    public static String getModeOfGame() {
        return modeOfGame;
    }

    /**
     * Create the menu buttons, set a background.
     */
    private void createMenu() throws FileNotFoundException {

        newGameButton.setImage(new Image(new FileInputStream(PATH_IMAGE_NEW_GAME_BUTTON)));
        setButton(newGameButton, MAIN_MENU_BUTTON_LEFT_BORDER_LINE,
                MAIN_MENU_BUTTON_TOP_BORDER_LINE, MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);

        loadLastGameButton.setImage(new Image(new FileInputStream(PATH_IMAGE_LOAD_GAME_BUTTON)));
        setButton(loadLastGameButton, MAIN_MENU_BUTTON_LEFT_BORDER_LINE, MAIN_MENU_BUTTON_TOP_BORDER_LINE +
                        MAIN_MENU_BUTTON_HEIGHT + MAIN_MENU_DISTANCE_BETWEEN_BUTTONS,
                MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);

        helpButton.setImage(new Image(new FileInputStream(PATH_IMAGE_HELP_BUTTON)));
        setButton(helpButton, MAIN_MENU_BUTTON_LEFT_BORDER_LINE, MAIN_MENU_BUTTON_TOP_BORDER_LINE +
                        2 * MAIN_MENU_BUTTON_HEIGHT + 2 * MAIN_MENU_DISTANCE_BETWEEN_BUTTONS,
                MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);

        exitButton.setImage(new Image(new FileInputStream(PATH_IMAGE_EXIT_BUTTON)));
        setButton(exitButton, MAIN_MENU_BUTTON_LEFT_BORDER_LINE, MAIN_MENU_BUTTON_TOP_BORDER_LINE +
                        3 * MAIN_MENU_BUTTON_HEIGHT + 3 * MAIN_MENU_DISTANCE_BETWEEN_BUTTONS,
                MAIN_MENU_BUTTON_WIDTH, MAIN_MENU_BUTTON_HEIGHT);

        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_BACKGROUNG)), 0, 0,
                STAGE_WIDTH, STAGE_HEIGHT);

        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_LOGO)), LOGO_LEFT_BORDER_LINE,
                LOGO_TOP_BORDER_LINE, LOGO_WIDTH, LOGO_HEIGHT);

        root.getChildren().addAll(canvas, newGameButton, loadLastGameButton, helpButton, exitButton);
    }

    /**
     * Listen to user's mouse input to select the game mode.
     */
    public void listen() {

        for (final ImageView button : buttonsOfMainMenu) {
            showChoice(button);
        }

        newGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HeroesMenu heroesMenu = null;
                try {
                    modeOfGame = "NewGame";
                    heroesMenu = new HeroesMenu();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Main.switchScene(heroesMenu.getHeroesMenu());
            }
        });

        loadLastGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                HeroesMenu heroesMenu = null;
                try {
                    modeOfGame = "LastGame";
                    heroesMenu = new HeroesMenu();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Main.switchScene(heroesMenu.getHeroesMenu());
            }
        });

        helpButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { ;
                try {
                    makeHelpWindow();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Main.getStage().close();
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

    /**
     * Create a new window if the player chooses HELP.
     */
    private static void makeHelpWindow() throws FileNotFoundException {

        AnchorPane root = new AnchorPane();
        final Stage helpWindow = new Stage();
        Scene helpScene = new Scene(root, HELP_WINDOW_WIDTH, HELP_WINDOW_HEIGHT);
        Canvas canvas = new Canvas(HELP_WINDOW_WIDTH, HELP_WINDOW_HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        final ImageView okButton = new ImageView();

        okButton.setImage(new Image(new FileInputStream(PATH_IMAGE_OK_BUTTON)));
        okButton.setX(OK_BUTTON_COORDINATES[0]);
        okButton.setY(OK_BUTTON_COORDINATES[1]);
        okButton.setFitWidth(OK_BUTTON_WIDTH);
        okButton.setFitHeight(OK_BUTTON_HEIGHT);
        graphicsContext.drawImage(new Image(new FileInputStream(PATH_IMAGE_HELP_BACKGROUND)),0, 0,
                HELP_WINDOW_WIDTH, HELP_WINDOW_HEIGHT);
        root.getChildren().addAll(canvas, okButton);

        helpWindow.setTitle("HELP");
        helpWindow.setScene(helpScene);
        helpWindow.initModality(Modality.WINDOW_MODAL);
        helpWindow.initOwner(Main.getStage());
        helpWindow.show();

        showChoice(okButton);
        okButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helpWindow.close();
            }
        });
    }

    /**
     * To show a little button offset if the mouse is entered or exited from the button.
     * @param button the image of the button
     */
    public static void showChoice(final ImageView button) {

            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    button.setX(button.getX() + 2);
                    button.setY(button.getY() + 2);
                }
            });
            button.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    button.setX(button.getX() - 2);
                    button.setY(button.getY() - 2);
                }
            });
    }
}
