package application;

import static application.Constants.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manage an enemy of the game.
 * @author Pavel Paklonski
 */
public class Enemy {

    private final List<Character> enemies;
    private final ArrayList<Point2D> allowedSteps;
    private final ArrayList<Point2D> closedPositions;
    private char[][] mapArray;
    private GMap map;

    /**
     * Set the list of enemies, lists of allowed and closed map positions for the enemies move.
     */
    public Enemy() {
        enemies = Arrays.asList(SOLDIER, ANGRY_SOLDIER, ZOMBIE, ZOMBIE_WITH_KEY, ZOMBIE_WITH_AXE, ANGRY_ZOMBIE,
                ANGRY_ZOMBIE_WITH_KEY, ANGRY_ZOMBIE_WITH_AXE);
        closedPositions = new ArrayList<>();
        allowedSteps = new ArrayList<>();
    }

    public void setMap(GMap map) {
        this.map = map;
    }

    /**
     * Look for the enemy and move it on the game field. After passing the entire map, the map is updated.
     */
    public void move() {
        mapArray = map.getMapArray();
        for (int row = 0; row < MAP_HEIGHT; row++) {
            for (int col = 0; col < MAP_WIDTH; col++) {
                for (Character enemy : enemies) {
                    if ((mapArray[row][col] == enemy) && !closedPositions.contains(new Point2D.Double(row, col))) {
                        moveEnemy(enemy, row, col);
                    }
                }
            }
        }
        closedPositions.clear();
        map.setMapArray(mapArray);
        map.updateGame();
    }

    /**
     * Randomly choose the step and do it after the set of the list of allowed steps on the game field.
     * If the place of a new step has spikes, the enemy disappears. New coordinates of the enemy add
     * to the list of closed positions to avoid a double enemy move.
     * @param enemy kind of the enemy who does a step
     * @param row a number of the row
     * @param col a number of the column
     */
    private void moveEnemy(char enemy, int row, int col) {
        setAllowedSteps(row, col);
        if (!allowedSteps.isEmpty()) {
            int stepIdx = (int)(Math.random() * allowedSteps.size());
            int newRowForEnemy = (int)allowedSteps.get(stepIdx).getX();
            int newColForEnemy = (int)allowedSteps.get(stepIdx).getY();
            if (mapArray[newRowForEnemy][newColForEnemy] == SPIKES) {
                mapArray[newRowForEnemy][newColForEnemy] = GROUND;
            } else {
                mapArray[newRowForEnemy][newColForEnemy] = enemy;
            }
            mapArray[row][col] = GROUND;
            closedPositions.add(new Point2D.Double(newRowForEnemy, newColForEnemy));
            allowedSteps.clear();
        }
    }

    /**
     * Set the list of enemy's allowed steps on the map of the game
     * @param row a number of the row
     * @param col a number of the column
     */
    private void setAllowedSteps(int row, int col) {
        if (mapArray[row][col+1] == GROUND || mapArray[row][col+1] == SPIKES) {
            allowedSteps.add(new Point2D.Double(row, col+1));
        }
        if (mapArray[row+1][col] == GROUND || mapArray[row+1][col] == SPIKES) {
            allowedSteps.add(new Point2D.Double(row+1, col));
        }
        if (mapArray[row][col-1] == GROUND || mapArray[row][col-1] == SPIKES) {
            allowedSteps.add(new Point2D.Double(row, col-1));
        }
        if (mapArray[row-1][col] == GROUND || mapArray[row-1][col] == SPIKES) {
            allowedSteps.add(new Point2D.Double(row-1, col));
        }
    }
}
