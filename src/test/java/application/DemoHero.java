package application;

import static application.Constants.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A shortened version of the Hero.java class without lines of the code
 * that call methods which draw images onto the game panel,
 * perform any operations with them and create new windows.
 * @author Pavel Paklonski
 */
public class DemoHero {

    private GMap map;
    private char[][] mapArray;
    private final String name;
    private DemoScenarios scenarios;
    private final List<Character> takeAllowedItems = Arrays.asList(AXE, AXE_AGAINST_ZOMBIES, KEY, MONEY, HEALTH, WOOD, SPIKES);
    private final List<Character> openAllowedItems = Arrays.asList(CHEST_WITH_KEY, EMPTY_CHEST, CLOSED_DOOR, CHEST_WITH_SPIKES,
            CHEST_WITH_MONEY, CHEST_WITH_HEALTH);
    private List<Character> items = new ArrayList<>();
    private List<Character> health = new ArrayList<>();
    private char activeItem;

    /**
     * Create an instance of the demo version of hero with a specific name.
     * @param name name of the main character
     */
    public DemoHero(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMap(GMap map) {
        this.map = map;
    }

    public void setDemoScenarios(DemoScenarios scenarios) {
        this.scenarios = scenarios;
    }

    /**
     * A shortened version of the method checkEnemies() of the class Hero.java.
     * Created for the Unit Testing of the method.
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
    }
    
    /**
     * A shortened version of the method moveUp() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void moveUp() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[0].length; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row-1][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row-1][col] = HERO;
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row-1][col] == OPENED_DOOR) && (mapArray[row-2][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row-2][col] = HERO;
                    break rewrite;
                }
            }
        }
        map.setMapArray(mapArray);
    }

    /**
     * A shortened version of the method moveDown() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void moveDown() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[0].length; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row+1][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row+1][col] = HERO;
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row+1][col] == OPENED_DOOR) && (mapArray[row+2][col] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row+2][col] = HERO;
                    break rewrite;
                }
            }
        }
        map.setMapArray(mapArray);
    }

    /**
     * A shortened version of the method moveLeft() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void moveLeft() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[0].length; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row][col-1] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col-1] = HERO;
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row][col-1] == OPENED_DOOR) && (mapArray[row][col-2] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col-2] = HERO;
                    break rewrite;
                }
            }
        }
        map.setMapArray(mapArray);
    }

    /**
     * A shortened version of the method moveRight() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void moveRight() {
        mapArray = map.getMapArray();
        rewrite:
        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[0].length; col++) {
                if ((mapArray[row][col] == HERO) && (mapArray[row][col+1] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col+1] = HERO;
                    break rewrite;
                }
                if ((mapArray[row][col] == HERO) && (mapArray[row][col+1] == OPENED_DOOR) && (mapArray[row][col+2] == GROUND)) {
                    mapArray[row][col] = GROUND;
                    mapArray[row][col+2] = HERO;
                    break rewrite;
                }
            }
        }
        map.setMapArray(mapArray);
    }

    /**
     * A shortened version of the method takeItem() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void takeItem() {
        items = map.getItemsList();
        health = map.getHealthList();
        for (char item : takeAllowedItems) {
            if (scenarios.checkAndUse(item, '.', 4)) {
                if (item == HEALTH) {
                    health.add(HEALTH);
                } else {
                    System.out.println(item);
                    items.add(item);
                }
                break;
            }
        }
        map.setMapArray(scenarios.getMapArray());
        map.setItemsList(items);
        map.setHealthList(health);
    }

    /**
     * A shortened version of the method useItem() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void useItem() {
        items = map.getItemsList();
        if (!items.isEmpty()) {
            int idxItem = map.getChosenItem();
            activeItem = items.get(idxItem);
            if (scenarios.useItem(activeItem)) {
                items.remove(idxItem);
                map.setItemsList(items);
            }
        }
    }
    
    /**
     * A shortened version of the method open() of the class Hero.java.
     * Created for the Unit Testing of the method.
     */
    public void open() {
        for (char item : openAllowedItems) {
            scenarios.useItem(item);
        }
    }

    /**
     * A shortened version of the method switchItems() of the class Hero.java.
     * Created for the Unit Testing of the method.
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
        }
    }
}
