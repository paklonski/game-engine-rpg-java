package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Unit testing of methods of the class Hero.java.
 * @author Pavel Paklonski
 */
public class HeroTest {

    /**
     * Test of checkEnemies method, of class Hero.
     * The test should determine the presence of a nearby angry enemy
     * and take away one unit of health of the main character.
     */
    @Test
    public void testCheckEnemies() {
        char[][] actualMapArray = new char[][]{
            {'.', '.', 'Y'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', '.', 'Y'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        
        List<Character> actualHealthList = new ArrayList<>();
        actualHealthList.add('O');
        actualHealthList.add('O');
        List<Character> excitedHealthList = Arrays.asList('O');
        
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin"); 
        DemoScenarios demoScenarios = new DemoScenarios();
        
        demoMap.setMapArray(actualMapArray);
        demoMap.setHealthList(actualHealthList);
        demoHero.setMap(demoMap);
        demoHero.setDemoScenarios(demoScenarios);
        demoScenarios.setMap(demoMap);
        
        demoHero.checkEnemies();
        
        assertEquals(demoMap.getHealthList(), excitedHealthList);
        
    }

    /**
     * Test of moveUp method, of class Hero.
     * The test should determine if the main character moves up.
     */
    @Test
    public void testMoveUp() {
        
        char[][] actualMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', 'H', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
        };
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        
        demoMap.setMapArray(actualMapArray);
        demoHero.setMap(demoMap);
        
        demoHero.moveUp();
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
    }

    /**
     * Test of moveDown method, of class Hero.
     * The test should determine if the main character moves down.
     */
    @Test
    public void testMoveDown() {
                
        char[][] actualMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', 'H', '.'}
        };
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        
        demoMap.setMapArray(actualMapArray);
        demoHero.setMap(demoMap);
        
        demoHero.moveDown();
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
        
    }

    /**
     * Test of moveLeft method, of class Hero.
     * The test should determine if the main character moves left.
     */
    @Test
    public void testMoveLeft() {
        
        char[][] actualMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', '.', '.'},
            {'H', '.', '.'},
            {'.', '.', '.'}
        };
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        
        demoMap.setMapArray(actualMapArray);
        demoHero.setMap(demoMap);
        
        demoHero.moveLeft();
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
    }

    /**
     * Test of moveRight method, of class Hero.
     * The test should determine if the main character moves right.
     */
    @Test
    public void testMoveRight() {
        
        char[][] actualMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', '.', 'H'},
            {'.', '.', '.'}
        };
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        
        demoMap.setMapArray(actualMapArray);
        demoHero.setMap(demoMap);
        
        demoHero.moveRight();
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
    }

    /**
     * Test of takeItem method, of class Hero.
     * The test should determine if the main character takes the key
     * and places it in the list of items.
     */
    @Test
    public void testTakeItem() {
        
        List<Character> actualItemsList = new ArrayList<>();
        actualItemsList.add('U');
        actualItemsList.add('M');
        List<Character> excitedItemsList = Arrays.asList('U', 'M', 'K');
        
        char[][] actualMapArray = new char[][]{
            {'.', 'K', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        DemoScenarios demoScenarios = new DemoScenarios();
        
        demoMap.setMapArray(actualMapArray);
        demoMap.setItemsList(actualItemsList);
        demoHero.setMap(demoMap);
        demoHero.setDemoScenarios(demoScenarios);
        demoScenarios.setMap(demoMap);
        
        demoHero.takeItem();
       
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
        assertEquals(demoMap.getItemsList(), excitedItemsList);
    }

    /**
     * Test of useItem method, of class Hero.
     * The test should determine if the main character uses money
     * from his list of items to eliminate the soldier.
     */
    @Test
    public void testUseItem() {
        
        List<Character> actualItemsList = new ArrayList<>();
        actualItemsList.add('U');
        actualItemsList.add('M');
        actualItemsList.add('K');
        List<Character> excitedItemsList = Arrays.asList('U', 'K');
        
        char[][] actualMapArray = new char[][]{
            {'.', 'Y', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', '.', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        DemoScenarios demoScenarios = new DemoScenarios();
        
        demoMap.setMapArray(actualMapArray);
        demoMap.setItemsList(actualItemsList);
        demoMap.setChosenItem(1);
        demoHero.setMap(demoMap);
        demoHero.setDemoScenarios(demoScenarios);
        demoScenarios.setMap(demoMap);
        
        demoHero.useItem();
        
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);
        assertEquals(excitedItemsList, demoMap.getItemsList());
    }

    /**
     * Test of open method, of class Hero.
     * The test should determine if the chest is opened,
     * if the main character wants to do this.
     */
    @Test
    public void testOpen() {
        
        char[][] actualMapArray = new char[][]{
            {'.', 'C', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        char[][] excitedMapArray = new char[][]{
            {'.', 'J', '.'},
            {'.', 'H', '.'},
            {'.', '.', '.'}
        };
        
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        DemoScenarios demoScenarios = new DemoScenarios();
        
        demoMap.setMapArray(actualMapArray);
        demoHero.setMap(demoMap);
        demoHero.setDemoScenarios(demoScenarios);
        demoScenarios.setMap(demoMap);
        
        demoHero.open();
        
        assertArrayEquals(demoMap.getMapArray(), excitedMapArray);   
    }

    /**
     * Test of switchItems method, of class Hero.
     * The test should determine if the item selection window moves
     * inside the item list.
     */
    @Test
    public void testSwitchItems() {
        
        List<Character> itemsList = Arrays.asList('U', 'K', 'M');
        int actualChosenItem = 1;
        int excitedChosenItem = 2;
        
        GMap demoMap = new GMap();
        DemoHero demoHero = new DemoHero("Kevin");
        DemoScenarios demoScenarios = new DemoScenarios();
        
        demoMap.setItemsList(itemsList);
        demoMap.setChosenItem(actualChosenItem);
        demoHero.setMap(demoMap);
        demoHero.setDemoScenarios(demoScenarios);
        
        demoHero.switchItems("RIGHT");
        
        assertEquals(demoMap.getChosenItem(), excitedChosenItem); 
    }
    
}
