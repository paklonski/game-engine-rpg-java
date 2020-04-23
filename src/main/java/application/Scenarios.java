package application;

import static application.Constants.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The class describes the possible uses of certain items.
 * What and with what can be used, what the consequences will be.
 * @author Pavel Paklonski.
 */
public class Scenarios {

    private GMap map;
    private char[][] mapArray;
    private Map<Point2D, Character> neighbours;
    private final List<Object> memory = new ArrayList<>();

    public void setMap(GMap map) {
        this.map = map;
        neighbours = new HashMap<>();
    }

    public char[][] getMapArray() {
        return mapArray;
    }

    public List<Object> getMemory() {
        return memory;
    }

    public Map<Point2D, Character> getNeighbours() {
        return neighbours;
    }

    /**
     * Detect items near the main hero and fill a HashMap with that items depending on the radius.
     * @param row the number of row
     * @param col the number of column
     * @param radius the radius of neighbours searching
     */
    private void setNeighbours(int row, int col, int radius) {

        neighbours.put(new Point2D.Double(row-1, col), mapArray[row-1][col]);  // NORTH
        neighbours.put(new Point2D.Double(row, col+1), mapArray[row][col+1]); // EAST
        neighbours.put(new Point2D.Double(row+1, col), mapArray[row+1][col]); // SOUTH
        neighbours.put(new Point2D.Double(row, col-1), mapArray[row][col-1]); // WEST
        if (radius == 8) {
            neighbours.put(new Point2D.Double(row-1, col+1), mapArray[row-1][col+1]); // NORTH-EAST
            neighbours.put(new Point2D.Double(row+1, col+1), mapArray[row+1][col+1]); // SOUTH-EAST
            neighbours.put(new Point2D.Double(row+1, col-1), mapArray[row+1][col-1]); // SOUTH-WEST
            neighbours.put(new Point2D.Double(row-1, col-1), mapArray[row-1][col-1]); // NORTH-WEST
        }
    }

    /**
     * Check if the item is near the main character.
     * If yes, replace it according to the parameter; if not, do nothing.
     * @param beforeUsing the item before exposure
     * @param afterUsing the item which has to be after exposure
     * @param radius the radius of impact around the main character (how many cells around the impact is distributed)
     * @return false - if the item is not near the main hero,
     *         true - if the item is near the main hero and the change was applied
     */
    public boolean checkAndUse(char beforeUsing, char afterUsing, int radius) {

        mapArray = map.getMapArray();
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                if (mapArray[row][col] == HERO) {
                    setNeighbours(row, col, radius);
                    if (!neighbours.containsValue(beforeUsing)) {
                        neighbours.clear();
                        return false;
                    } else {
                        for (Point2D point : neighbours.keySet()) {
                            if (neighbours.get(point) == beforeUsing) {
                                    mapArray[(int)point.getX()][(int)point.getY()] = afterUsing;
                                break;
                            }
                        }
                        neighbours.clear();
                    }
                }
            }
        }
        return true;
    }

    /**
     * Draws a new item, which is removed from any after the impact of the main hero.
     * @param item the item which is removed
     */
    private void drawLoot(char item) {

        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                if (mapArray[row][col] == HERO) {
                    setNeighbours(row, col, 4);
                    for (Point2D point : neighbours.keySet()) {
                        if (neighbours.get(point) == GROUND) {
                            mapArray[(int)point.getX()][(int)point.getY()] = item;
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * The method includes scenarios, how one or another item of the main character is applied.
     * @param activeItem a used by the main character item
     * @return true - if the item can be applied,
     *         false - if not.
     */
    public boolean useItem(char activeItem) {

        switch (activeItem) {
            case AXE:
                if (checkAndUse(WALL_WITH_KEY, DESTROYED_WALL, 4)) {
                    drawLoot(KEY);
                } else {
                    return false;
                }
                break;
            case CHEST_WITH_KEY:
                if (checkAndUse(CHEST_WITH_KEY, OPENED_CHEST, 4)) {
                    drawLoot(KEY);
                } else {
                    return false;
                }
                break;
            case EMPTY_CHEST:
                if (!checkAndUse(EMPTY_CHEST, OPENED_CHEST, 4)) {
                    return false;
                }
                break;
            case CHEST_WITH_SPIKES:
                if (checkAndUse(CHEST_WITH_SPIKES, OPENED_CHEST, 4)) {
                    drawLoot(SPIKES);
                } else {
                    return false;
                }
                break;
            case CHEST_WITH_MONEY:
                if (checkAndUse(CHEST_WITH_MONEY, OPENED_CHEST, 4)) {
                    drawLoot(MONEY);
                } else {
                    return false;
                }
                break;
            case CHEST_WITH_HEALTH:
                if (checkAndUse(CHEST_WITH_HEALTH, OPENED_CHEST, 4)) {
                    drawLoot(HEALTH);
                } else {
                    return false;
                }
                break;
            case WOOD:
                if (!checkAndUse(WATER, GROUND, 4)) {
                    return false;
                };
                break;
            case KEY:
                if (!checkAndUse(CLOSED_DOOR, OPENED_DOOR, 4)) {
                    return false;
                };
                break;
            case MONEY:
                if (!checkAndUse(ANGRY_SOLDIER, GROUND, 8)) {
                    return false;
                };
                break;
            case AXE_AGAINST_ZOMBIES:
                if (!checkAndUse(ANGRY_ZOMBIE, GROUND, 8) &&
                        !checkAndUse(ANGRY_ZOMBIE_WITH_KEY, KEY, 8) &&
                        !checkAndUse(ANGRY_ZOMBIE_WITH_AXE, AXE, 8)) {
                    return false;
                };
                break;
            case SPIKES:
                for (int row = 0; row < MAP_HEIGHT; row++) {
                    for (int col = 0; col < MAP_WIDTH; col++) {
                        if (mapArray[row][col] == HERO && memory.size() < 3) {
                            memory.add(row);
                            memory.add(col);
                            memory.add(SPIKES);
                        }
                    }
                }
                break;
            default:
                break;
        }
        map.setMapArray(mapArray);
        return true;
    }
}
