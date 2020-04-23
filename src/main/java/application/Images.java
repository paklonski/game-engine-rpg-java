package application;

import static application.Constants.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create a HashMap of images which the game uses
 * @author Pavel Paklonski
 */
public class Images {

    private final Map<String, Image> images;
    private final List<String> PATHES_TO_HERO_IMAGES;
    private static String heroDirectionImage = "HERO_RIGHT";

    /**
     * Create a HashMap of images depending on the selected main character. Fill the List
     * of directories of the main character images.
     * @param heroName the name of the main character
     * @throws java.io.FileNotFoundException
     */
    public Images(String heroName) throws FileNotFoundException {
        images = new HashMap<>();
        if (heroName.equals("Kevin")) {
            PATHES_TO_HERO_IMAGES = Arrays.asList(PATH_IMAGE_KEVIN_UP, PATH_IMAGE_KEVIN_DOWN,
                    PATH_IMAGE_KEVIN_LEFT, PATH_IMAGE_KEVIN_RIGHT);
        } else if (heroName.equals("Olivia")) {
            PATHES_TO_HERO_IMAGES = Arrays.asList(PATH_IMAGE_OLIVIA_UP, PATH_IMAGE_OLIVIA_DOWN,
                    PATH_IMAGE_OLIVIA_LEFT, PATH_IMAGE_OLIVIA_RIGHT);
        } else {
            PATHES_TO_HERO_IMAGES = Arrays.asList(PATH_IMAGE_JACOB_UP, PATH_IMAGE_JACOB_DOWN,
                    PATH_IMAGE_JACOB_LEFT, PATH_IMAGE_JACOB_RIGHT);
        }
        setImages();
    }

    public Map<String, Image> getImages() {
        return images;
    }

    public static void setHeroDirectionImage(String heroDirectionImage) {
        Images.heroDirectionImage = heroDirectionImage;
    }

    /**
     * Set a HashMap of images.
     */
    private void setImages() throws FileNotFoundException {

        images.put("AXE", new Image(new FileInputStream(PATH_IMAGE_AXE)));
        images.put("AXE_AGAINST_ZOMBIES", new Image(new FileInputStream(PATH_IMAGE_AXE_DIAMOND)));
        images.put("BACK", new Image(new FileInputStream(PATH_IMAGE_BACK)));
        images.put("BACKGROUND", new Image(new FileInputStream(PATH_IMAGE_BACKGROUNG)));
        images.put("CASTLE", new Image(new FileInputStream(PATH_IMAGE_CASTLE)));
        images.put("CLOSED_CHEST", new Image(new FileInputStream(PATH_IMAGE_CHEST_CLOSED)));
        images.put("OPENED_CHEST", new Image(new FileInputStream(PATH_IMAGE_CHEST_OPENED)));
        images.put("CHOICE", new Image(new FileInputStream(PATH_IMAGE_CHOICE)));
        images.put("CLOSED_DOOR", new Image(new FileInputStream(PATH_IMAGE_DOOR_CLOSED)));
        images.put("OPENED_DOOR", new Image(new FileInputStream(PATH_IMAGE_DOOR_OPENED)));
        images.put("FENCE_HOR", new Image(new FileInputStream(PATH_IMAGE_FENCE_HOR)));
        images.put("FENCE_VERT", new Image(new FileInputStream(PATH_IMAGE_FENCE_VERT)));
        images.put("GRASS", new Image(new FileInputStream(PATH_IMAGE_GRASS)));
        images.put("GROUND", new Image(new FileInputStream(PATH_IMAGE_GROUND)));
        images.put("HEALTH", new Image(new FileInputStream(PATH_IMAGE_HEALTH)));
        images.put("HERO_UP", new Image(new FileInputStream(PATHES_TO_HERO_IMAGES.get(0))));
        images.put("HERO_DOWN", new Image(new FileInputStream(PATHES_TO_HERO_IMAGES.get(1))));
        images.put("HERO_LEFT", new Image(new FileInputStream(PATHES_TO_HERO_IMAGES.get(2))));
        images.put("HERO_RIGHT", new Image(new FileInputStream(PATHES_TO_HERO_IMAGES.get(3))));
        images.put("KEY", new Image(new FileInputStream(PATH_IMAGE_KEY)));
        images.put("MONEY", new Image(new FileInputStream(PATH_IMAGE_MONEY)));
        images.put("SPIKES", new Image(new FileInputStream(PATH_IMAGE_SPIKES)));
        images.put("TREE", new Image(new FileInputStream(PATH_IMAGE_TREE)));
        images.put("WALL", new Image(new FileInputStream(PATH_IMAGE_WALL)));
        images.put("DESTROYED_WALL", new Image(new FileInputStream(PATH_IMAGE_WALL_DESTROYED)));
        images.put("WATER", new Image(new FileInputStream(PATH_IMAGE_WATER)));
        images.put("WOOD", new Image(new FileInputStream(PATH_IMAGE_WOOD)));
        images.put("ZOMBIE", new Image(new FileInputStream(PATH_IMAGE_ZOMBIE_RIGHT)));
        images.put("ANGRY_ZOMBIE", new Image(new FileInputStream(PATH_IMAGE_ANGRY_ZOMBIE)));
        images.put("SOLDIER", new Image(new FileInputStream(Constants.PATH_IMAGE_SOLDIER_RIGHT)));
        images.put("ANGRY_SOLDIER", new Image(new FileInputStream(PATH_IMAGE_ANGRY_SOLDIER)));
        images.put("ITEMS_BAR", new Image(new FileInputStream(PATH_IMAGE_ITEMS_BAR)));
        images.put("SAVE", new Image(new FileInputStream(PATH_IMAGE_SAVE_GAME)));
    }

    /**
     * Draw images depending on the selected image label.
     * @param graphicsContext graphics context of the canvas
     * @param imageLabel kind of image
     * @param xCursor the offset X
     * @param yCursor the offset Y
     */
    public void drawImages(GraphicsContext graphicsContext, char imageLabel, int xCursor, int yCursor) {
        switch (imageLabel) {
            case ANGRY_SOLDIER:
                graphicsContext.drawImage(images.get("ANGRY_SOLDIER"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case AXE:
                graphicsContext.drawImage(images.get("AXE"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case AXE_AGAINST_ZOMBIES:
                graphicsContext.drawImage(images.get("AXE_AGAINST_ZOMBIES"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case BACKGROUND:
                graphicsContext.drawImage(images.get("BACKGROUND"), xCursor, yCursor, STAGE_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case CASTLE:
                graphicsContext.drawImage(images.get("CASTLE"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case EMPTY_CHEST:
            case CHEST_WITH_KEY:
            case CHEST_WITH_SPIKES:
            case CHEST_WITH_MONEY:
            case CHEST_WITH_HEALTH:
                graphicsContext.drawImage(images.get("CLOSED_CHEST"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case OPENED_CHEST:
                graphicsContext.drawImage(images.get("OPENED_CHEST"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case CHOICE:
                graphicsContext.drawImage(images.get("CHOICE"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case CLOSED_DOOR:
                graphicsContext.drawImage(images.get("CLOSED_DOOR"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case OPENED_DOOR:
                graphicsContext.drawImage(images.get("OPENED_DOOR"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case FENCE_HOR:
                graphicsContext.drawImage(images.get("FENCE_HOR"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case FENCE_VERT:
                graphicsContext.drawImage(images.get("FENCE_VERT"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case GRASS:
                graphicsContext.drawImage(images.get("GRASS"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case GROUND:
                graphicsContext.drawImage(images.get("GROUND"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case HEALTH:
                graphicsContext.drawImage(images.get("HEALTH"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case HERO:
                graphicsContext.drawImage(images.get(heroDirectionImage), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case KEY:
                graphicsContext.drawImage(images.get("KEY"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case MONEY:
                graphicsContext.drawImage(images.get("MONEY"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case SOLDIER:
                graphicsContext.drawImage(images.get("SOLDIER"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case SPIKES:
                graphicsContext.drawImage(images.get("SPIKES"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case TREE:
                graphicsContext.drawImage(images.get("TREE"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case DESTROYED_WALL:
                graphicsContext.drawImage(images.get("DESTROYED_WALL"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case WALL:
            case WALL_WITH_KEY:
                graphicsContext.drawImage(images.get("WALL"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case WATER:
                graphicsContext.drawImage(images.get("WATER"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case WOOD:
                graphicsContext.drawImage(images.get("WOOD"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case ZOMBIE:
            case ZOMBIE_WITH_KEY:
            case ZOMBIE_WITH_AXE:
                graphicsContext.drawImage(getImages().get("ZOMBIE"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            case ANGRY_ZOMBIE:
            case ANGRY_ZOMBIE_WITH_KEY:
            case ANGRY_ZOMBIE_WITH_AXE:
                graphicsContext.drawImage(images.get("ANGRY_ZOMBIE"), xCursor, yCursor, MAP_PIXEL_WIDTH, MAP_PIXEL_HEIGHT);
                break;
            default:
                break;
        }
    }
}
