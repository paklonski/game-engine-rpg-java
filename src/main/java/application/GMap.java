package application;

import static application.Constants.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.*;
import java.util.List;

/**
 * Class for drawing and redrawing a game field, refreshing after changes, saving to and loading from the file
 * last instances of the map, items collection and a health condition.
 * @author Pavel Paklonski
 */
public class GMap extends Map {

    private Canvas gameField;
    private GraphicsContext graphicsContext;
    private Images images;

    public GMap() {
    }
    
    /**
     * Create the instance of game field including the map, an items bar and the health of the main character
     * @param heroName the name of the main character
     * @throws java.io.IOException
     */
    public GMap(String heroName) throws IOException {
        gameField = new Canvas(CANVAS_GAME_WIDTH, CANVAS_GAME_HEIGHT);
        graphicsContext = gameField.getGraphicsContext2D();
        images = new Images(heroName);
        loadMap();
        loadHealth();
        loadItems();
        drawItemsBar();
        drawMap();
        drawHealth();
        setChosenItem(itemsArray.size()-1);
        drawItems();
        drawHints();
    }

    /**
     * Update the game field after changes (moving, taking of items, losing of a health and etc.)
     */
    public void updateGame() {
        gameField.getGraphicsContext2D().clearRect(0, 0, STAGE_WIDTH, STAGE_HEIGHT);
        drawItemsBar();
        drawMap();
        drawHealth();
        drawItems();
        drawHints();
    }

    /**
     * Save a map array to the file.
     * @throws java.io.IOException
     */
    public void saveGame() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH_LAST_MAP)));
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                bw.write(mapArray[row][col]);
            }
            bw.newLine();
        }
        bw.close();
    }

    /**
     * Save an items array to the file.
     * @throws java.io.IOException
     */
    public void saveItems() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH_LAST_ITEMS)));
        for (int i = 0; i < itemsArray.size(); i++) {
            bw.write(itemsArray.get(i));
        }
        bw.close();
    }

    /**
     * Save a health array to the file.
     * @throws java.io.IOException
     */
    public void saveHealth() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH_LAST_HEALTH)));
        for (int i = 0; i < healthArray.size(); i++) {
            bw.write(healthArray.get(i));
        }
        bw.close();
    }
    
    public Canvas getGameField() {
        return gameField;
    }

    /**
     * Load the content of the file to array.
     * @param PATH the path of the file
     * @param array array at destination
     */
    private void loadFromFileToArray(String PATH, List<Character>array) throws IOException {
        String line;
        char[] line_array;
        if (new File(PATH).length() != 0) {
            line = new BufferedReader(new FileReader(new File(PATH))).readLine();
            line_array = line.toCharArray();
            for (int i = 0; i < line_array.length; i++) {
                array.add(line_array[i]);
            }
        }
    }

    /**
     * Load items depending on the selected game mode.
     */
    private void loadItems() throws IOException {
        if (MainMenu.getModeOfGame().equals("NewGame")) {
            loadFromFileToArray(PATH_ITEMS, itemsArray);
        } else {
            loadFromFileToArray(PATH_LAST_ITEMS, itemsArray);
        }
    }

    /**
     * Draw items to the game field.
     */
    private void drawItems() {
        int x_cursor = MAP_PIXEL_WIDTH;
        int y_cursor = 0;
        for (int i = 0; i < itemsArray.size(); i++) {
            images.drawImages(graphicsContext, itemsArray.get(i), x_cursor, y_cursor);
            x_cursor += MAP_PIXEL_WIDTH;
        }
        drawChoice();
    }

    /**
     * Draw the cursor of items bar.
     */
    private void drawChoice() {
        if (!itemsArray.isEmpty()) {
            images.drawImages(graphicsContext, CHOICE, MAP_PIXEL_WIDTH + chosenItem * MAP_PIXEL_WIDTH, 0);
        }
    }

    /**
     * Draw hints 'save' and 'back' on the panel of the game.
     */
    private void drawHints() {
        graphicsContext.drawImage(images.getImages().get("BACK"), 12 * MAP_PIXEL_WIDTH, 0, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
        graphicsContext.drawImage(images.getImages().get("SAVE"), 17 * MAP_PIXEL_WIDTH, 0, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
        graphicsContext.fillText(" - ESC", 13 * MAP_PIXEL_WIDTH, 20);
        graphicsContext.fillText(" - F6", 18 * MAP_PIXEL_WIDTH, 20);
    }

    /**
     * Load a health condition of the main hero.
     */
    private void loadHealth() throws IOException {
        if (MainMenu.getModeOfGame().equals("NewGame")) {
            loadFromFileToArray(PATH_HEALTH, healthArray);
        } else {
            loadFromFileToArray(PATH_LAST_HEALTH, healthArray);
        }
    }

    /**
     * Draw a health condition on the panel of the game.
     */
    private void drawHealth() {
        int x_cursor = (MAP_WIDTH-2) * MAP_PIXEL_WIDTH;
        int y_cursor = 0;
        for (int i = 0; i < healthArray.size(); i++) {
            images.drawImages(graphicsContext, HEALTH, x_cursor, y_cursor);
            x_cursor -= MAP_PIXEL_WIDTH;
        }
    }

    /**
     * Load a map from the file depending on the chosen mode of the game.
     */
    private void loadMap() throws IOException {

        String line;
        char[] lineArray;
        BufferedReader br;

        if (MainMenu.getModeOfGame().equals("NewGame")) {
            br = new BufferedReader(new FileReader(new File(PATH_MAP)));
        } else {
            br = new BufferedReader(new FileReader(new File(PATH_LAST_MAP)));
        }
        for (int row = 0; row < MAP_HEIGHT; row++) {
            line = br.readLine();
            lineArray = line.toCharArray();
            for (int col = 0; col < MAP_WIDTH; col++) {
                mapArray[row][col] = lineArray[col];
            }
        }
    }

    /**
     * Draw the current map to the game field.
     */
    private void drawMap() {
        int xCursor = 0;
        int yCursor = MAP_PIXEL_HEIGHT;
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                images.drawImages(graphicsContext, GROUND, xCursor, yCursor);
                images.drawImages(graphicsContext, mapArray[row][col], xCursor, yCursor);
                xCursor += MAP_PIXEL_WIDTH;
            }
            xCursor = 0;
            yCursor += MAP_PIXEL_HEIGHT;
        }
    }

    /**
     * Draw the items bar where all items of the main hero are.
     */
    private void drawItemsBar() {
        graphicsContext.drawImage(images.getImages().get("ITEMS_BAR"), 0, 0);
    }
}
