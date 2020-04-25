# Game engine for a role-playing game with GUI

The first JAVA project that was developed as a semester project of JAVA Programming Course at the CTU in Prague.

-------------------------------------

**ABOUT THE GAME**     

The game world includes the main character, soldiers, zombies, river, chests, various types of axes, keys, money for bribing soldiers and so on.         

The game consists of one game level. The user selects the game mode: new game or last saved one. Then there is the possibility of choosing the main character, on behalf of whom the game will take place. Next, the game begins.    

The main character can move, collect items and use them. The main goal is to go through all the rooms of the playing field to reach the final point - the castle.        

If the hero on the way to the castle loses his health due to meeting the enemies, the game ends with a loss, if the castle is reached - the game ends with success and can theoretically be continued with subsequent game levels.      

Game field control keys: 

**W** - to move up      
**A** - to move left       
**S** - to move down         
**D** - to move right           
**LEFT** - to move the selection frame on the items bar to the left          
**RIGHT** - to move the selection frame on the items bar to the right          
**ENTER** - to use the item inside the frame according to the use of this one           
**F** - to take an item from the game field            
**R** - to open an item on the game field          
**ESC** - to go to the menu           
**F6** - to save a current game state   

----------------------------------------

**MANUAL FOR DEVELOPERS**          

**Project files:**        

package **application**:          

**Action.java** - a class for managing events on the playing field, accepting keyboard input and creating dialog windows when users lose or win.           
**Constants.java** - an interface which contains the necessary constant values for the project, paths to files and images.            
**Enemy.java** - class for manipulating enemies on the game board.            
**GMap.java** - class for loading and storing various game states in the form of text files, drawing the playing field according to the included files, updating the playing field if any changes are applied.            
**Hero.java** - class for manipulating the main character on the game board.             
**HeroesMenu.java** - class for creating the main character selection menu.                
**Images.java** - сlass for loading and storing images needed by the project.              
**Main.java** - launch of the project.                
**MainMenu.java** - сlass for creating the main menu of the game.            
**Map.java** - сlass for storing a game map as a 'char' array, storing a list of items and the health condition of the main hero.           
**Scenarios.java** - class describes the possible interaction of objects on the playing field and their result.          

package **test.application**:         

**DemoEnemy.java** - a copy of the class Enemy.java, which doesn't include functions that cause the redrawing of the playing field as an array of images. Created for unit testing of methods of class Enemy.java.           
**DemoHero.java** - a copy of the class Hero.java, which doesn't include functions that cause the redrawing of the playing field as an array of images. Created for unit testing of methods of class Hero.java.          
**DemoScenarios.java** - a copy of the class Scenarios.java, which doesn't include functions that cause the redrawing of the playing field as an array of images. Created for unit testing of methods of class Scenarios.java.         
**EnemyTest.java** - unit testing of methods of the class Enemy.java.           
**HeroTest.java** - unit testing of methods of the class Hero.java.           

package **resources**:         
   
**Health.txt** - text file containing signs of health units of the main character.        
**Items.txt** - text file including the inventory of the main character.          
**Map.txt** - text file including the state of the map of the playing field.         
**lastHealth.txt** - text file containing the last saved signs of health units of the main character.         
**lastItems.txt** - text file including the last saved inventory of the main character.          
**lastMap.txt** - text file including the last saved state of the map of the playing field.        

package **UI**:         

images for creating user interface.         
 
package **heroes**:        
    
images for creating the look of the characters on the playing field.        

package **images**:        

images for creating the look of the playing field. 

--------------------------

Values of text file symbols for creating new maps, lists of items and health states of the main character:       

**'A'** - AXE;         
**'B'** - CHEST_WITH_KEY;       
**'C'** - EMPTY_CHEST;        
**'D'** - CLOSED_DOOR;        
**'E'** - AXE_AGAINST_ZOMBIES;        
**'F'** - CASTLE;        
**'G'** - GRASS;        
**'H'** - HERO;        
**'I'** - OPENED_DOOR;        
**'J'** - OPENED_CHEST;        
**'K'** - KEY;        
**'L'** - CHEST_WITH_SPIKES;        
**'M'** - MONEY;        
**'N'** - CHEST_WITH_MONEY;        
**'O'** - HEALTH;        
**'P'** - WALL_WITH_KEY;        
**'Q'** - ZOMBIE_WITH_KEY;        
**'R'** - DESTROYED_WALL;        
**'S'** - SOLDIER;        
**'T'** - TREE;        
**'U'** - WOOD;        
**'V'** - CHEST_WITH_HEALTH;        
**'W'** - WATER;        
**'X'** - WALL;        
**'Y'** - ANGRY_SOLDIER;        
**'Z'** - ZOMBIE;        
**'.'** - GROUND;        
**'/'** - FENCE_HORIZONTAL;        
**':'** - FENCE_VERTICAL;        
**'?'** - SPIKES;        
**'['** - BACKGROUND;        
**']'** - CHOICE;        
**'>'** - ANGRY_ZOMBIE;        
**'!'** - ANGRY_ZOMBIE_WITH_KEY;        
**'<'** - ZOMBIE_WITH_AXE;        
**';'** - ANGRY_ZOMBIE_WITH_AXE.        
