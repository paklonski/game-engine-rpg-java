package application;

import static application.Constants.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating a char array which contains a map, lists of items of the main hero and its health condition.
 * @author Pavel Paklonski
 */
public class Map {

    public char[][] mapArray = new char[MAP_HEIGHT][MAP_WIDTH];
    public List<Character> itemsArray = new ArrayList<>();
    public List<Character> healthArray = new ArrayList<>();
    public int chosenItem;

    public char[][] getMapArray() {
        return mapArray;
    }

    public void setMapArray(char[][] mapArray) {
        this.mapArray = mapArray;
    }

    public List<Character> getHealthList() {
        return healthArray;
    }
    
    public void setHealthList(List<Character> healthArray) {
        this.healthArray = healthArray;
    }

    public List<Character> getItemsList() {
        return itemsArray;
    }

    public void setItemsList(List<Character> itemsArray) {
        this.itemsArray = itemsArray;
    }
    
    public int getChosenItem() {
        return chosenItem;
    }

    public void setChosenItem(int chosenItem) {
        this.chosenItem = chosenItem;
    }

}
