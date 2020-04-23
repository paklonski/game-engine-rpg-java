package application;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit testing of methods of the class Enemy.java.
 * @author Pavel Paklonski
 */
public class EnemyTest {

    /**
     * Test of move method, of class Enemy.
     * The test determines if the enemy has moved to the points on the map
     * accessible to him.
     */
    @Test
    public void testMove() {
        
        char[][] actualMapArray = new char[][]{
            {'X', 'X', 'X', 'X', 'X'},
            {'X', 'S', 'G', '.', '.'},
            {'X', '.', 'S', 'T', '.'},
            {'X', '.', '.', '.', '.'}
        };
        
        char[][] excitedMapArray = new char[][]{
            {'X', 'X', 'X', 'X', 'X'},
            {'X', '.', 'G', '.', '.'},
            {'X', 'S', '.', 'T', '.'},
            {'X', '.', 'S', '.', '.'}
        };
        
        GMap demoMap = new GMap();
        DemoEnemy demoEnemy = new DemoEnemy();
        
        demoMap.setMapArray(actualMapArray);
        demoEnemy.setMap(demoMap);
        
        demoEnemy.move();
        
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
    }
}
