package application;

import static application.Constants.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manage the main character of the game.
 * @author Pavel Paklonski
 */
public class Hero {

    private final String name;
    private GMap map;
    private char[][] mapArray;
    private Scenarios scenarios;
    private final List<Character> takeAllowedItems = 
            Arrays.asList(AXE, AXE_AGAINST_ZOMBIES, KEY, MONEY, 
                    HEALTH, WOOD, SPIKES);
    private final List<Character> openAllowedItems = 
            Arrays.asList(CHEST_WITH_KEY, EMPTY_CHEST, CLOSED_DOOR, 
                    CHEST_WITH_SPIKES, CHEST_WITH_MONEY, CHEST_WITH_HEALTH);
    private List<Character> items = new ArrayList<>();
    private List<Character> health = new ArrayList<>();
    private char activeItem;

    /**
     * Create an instance of the hero with a specific name
     * @param name name of the main character
     */
    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMap(GMap map) {
        this.map = map;
    }

    public void setScenarios(Scenarios scenarios) {
        this.scenarios = scenarios;
    }

    /**
     * After the step, the main character checks if there are enemies around him.
     * If there is - the calm enemy becomes evil,
     * if the enemy is evil - then the main character loses a health unit.
     * If the hero's health amount is empty, the 'gameover' window appears and the game repeats from the beginning.
     */
    public void checkEnemies() {

        mapArray = map.getMapArray();
        health = map.getHealthList();

        if (scenarios.checkAndUse(ANGRY_SOLDIER, ANGRY_SOLDIER, 8) ||
                scenarios.checkAndUse(ANGRY_ZOMBIE, ANGRY_ZOMBIE, 8) ||
                scenarios.checkAndUse(ANGRY_ZOMBIE_WITH_KEY, ANGRY_ZOMBIE_WITH_KEY, 8) ||
                scenarios.checkAndUse(ANGRY_ZOMBIE_WITH_AXE, ANGRY_ZOMBIE_WITH_AXE, 8)) {
            if (!health.isEmpty()) {
                health.remove(health.size() - 1);
            }
            map.setMapArray(scenarios.getMapArray());
        } else {
            scenarios.checkAndUse(SOLDIER, ANGRY_SOLDIER, 8);
            scenarios.checkAndUse(ZOMBIE, ANGRY_ZOMBIE, 8);
            scenarios.checkAndUse(ZOMBIE_WITH_KEY, ANGRY_ZOMBIE_WITH_KEY, 8);
            scenarios.checkAndUse(ZOMBIE_WITH_AXE, ANGRY_ZOMBIE_WITH_AXE, 8);
            map.setMapArray(scenarios.getMapArray());
        }
        if (health.isEmpty()) {
            try {
                Action.makeDialog("GAMEOVER");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        map.updateGame();
    }

    /**
     * If the hero applies an item that he leaves on the playing field,
     * the method remembers the position. After being released by hero, an item appears in its place.
     */
    private void setPutItems() {
        if (!scenarios.getMemory().isEmpty()) {
            int row = (int)scenarios.getMemory().get(0);
            int col = (int)scenarios.getMemory().get(1);
            char item = (char)scenarios.getMemory().get(2);
            mapArray[row][col] = item;
            scenarios.getMemory().clear();
        }
    }

    /**
     * Moves the main character up.
     */
    public void moveUp() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row-1][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row-1][col] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row-1][col] == OPENED_DOOR) && (mapArray[row-2][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row-2][col] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row-1][col] == CASTLE)) {
                    try {
                        mapArray[row][col] = GROUND;
                        map.setMapArray(mapArray);
                        map.updateGame();
                        Action.makeDialog("CONGRATS");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Images.setHeroDirectionImage("HERO_UP");
        map.setMapArray(mapArray);
        map.updateGame();
    }

    /**
     * Moves the main character down.
     */
    public void moveDown() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row+1][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row+1][col] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row+1][col] == OPENED_DOOR) && (mapArray[row+2][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row+2][col] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row+1][col] == CASTLE)) {
                    try {
                        mapArray[row][col] = GROUND;
                        map.setMapArray(mapArray);
                        map.updateGame();
                        Action.makeDialog("CONGRATS");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Images.setHeroDirectionImage("HERO_DOWN");
        map.setMapArray(mapArray);
        map.updateGame();
    }

    /**
     * Moves the main character left.
     */
    public void moveLeft() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row][col-1] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col-1] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row][col-1] == OPENED_DOOR) && (mapArray[row][col-2] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col-2] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row][col-1] == CASTLE)) {
                    try {
                        mapArray[row][col] = GROUND;
                        map.setMapArray(mapArray);
                        map.updateGame();
                        Action.makeDialog("CONGRATS");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Images.setHeroDirectionImage("HERO_LEFT");
        map.setMapArray(mapArray);
        map.updateGame();
    }

    /**
     * Moves the main character right.
     */
    public void moveRight() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row][col+1] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col+1] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row][col+1] == OPENED_DOOR) && (mapArray[row][col+2] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col+2] = HERO;
                    setPutItems();
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row][col+1] == CASTLE)) {
                    try {
                        mapArray[row][col] = GROUND;
                        map.setMapArray(mapArray);
                        map.updateGame();
                        Action.makeDialog("CONGRATS");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Images.setHeroDirectionImage("HERO_RIGHT");
        map.setMapArray(mapArray);
        map.updateGame();
    }

    /**
     * Check if the item can be taken. If yes - the hero adds the item to the list.
     */
    public void takeItem() {
        items = map.getItemsList();
        health = map.getHealthList();
        for (char item : takeAllowedItems) {
            if (scenarios.checkAndUse(item, '.', 4)) {
                if (item == HEALTH) {
                    health.add(HEALTH);
                } else {
                    items.add(item);
                }
                break;
            }
        }
        map.setMapArray(scenarios.getMapArray());
        map.setItemsList(items);
        map.setHealthList(health);
        map.setChosenItem(items.size()-1);
        map.updateGame();
    }

    /**
     * Check if the item can be used. If yes - the hero uses the item according to scenarios.
     */
    public void useItem() {
        items = map.getItemsList();
        if (!items.isEmpty()) {
            int idxItem = map.getChosenItem();
            activeItem = items.get(idxItem);
            if (scenarios.useItem(activeItem)) {
                items.remove(idxItem);
                map.setItemsList(items);
                map.setChosenItem(items.size()-1);
                map.updateGame();
            }
        }
    }

    /**
     * Check if the item can be opened. If yes - the hero opens the item according to scenarios.
     */
    public void open() {
        for (char item : openAllowedItems) {
            scenarios.useItem(item);
        }
        map.setItemsList(items);
        map.updateGame();
    }

    /**
     * Move the cursor in hero's list of items and select them.
     * @param direction cursor to left or to right
     */
    public void switchItems(String direction) {
        items = map.getItemsList();
        if (!items.isEmpty()) {
            int currentItem = map.getChosenItem();
            if (direction.equals("LEFT") && currentItem > 0) {
                currentItem--;
            } else if (direction.equals("RIGHT") && currentItem < items.size() - 1){
                currentItem++;
            }
            map.setChosenItem(currentItem);
            map.updateGame();
        }
    }
}
