package application;

/**
 * Keep constants for classes of the project.
 * @author Pavel Paklonski
 */
public interface Constants {

    int STAGE_WIDTH = 900;
    int STAGE_HEIGHT = 630;

    int CANVAS_GAME_WIDTH = 900;
    int CANVAS_GAME_HEIGHT = 630;

    int DIALOG_WINDOW_WIDTH = 400;
    int DIALOG_WINDOW_HEIGHT = 220;

    int HELP_WINDOW_WIDTH = 700;
    int HELP_WINDOW_HEIGHT = 500;

    int MAP_WIDTH = 30;
    int MAP_HEIGHT = 20;
    int MAP_PIXEL_WIDTH = 30;
    int MAP_PIXEL_HEIGHT = 30;

    int MAIN_MENU_BUTTON_WIDTH = 200;
    int MAIN_MENU_BUTTON_HEIGHT = 75;
    int MAIN_MENU_BUTTON_TOP_BORDER_LINE = 200;
    int MAIN_MENU_BUTTON_LEFT_BORDER_LINE = 350;
    int MAIN_MENU_DISTANCE_BETWEEN_BUTTONS = 20;

    int HEROES_MENU_BUTTON_WIDTH = 160;
    int HEROES_MENU_BUTTON_HEIGHT = 220;
    int HEROES_MENU_TOP_BORDER_LINE = 330;
    int HEROES_MENU_LEFT_BORDER_LINE = 105;
    int HEROES_MENU_DISTANCE_BETWEEN_BUTTONS = 105;
    int[] HEROES_MENU_TEXT_COORDINATES = {115, 200};

    int OK_BUTTON_WIDTH = 120;
    int OK_BUTTON_HEIGHT = 45;
    int[] OK_BUTTON_COORDINATES = {290, 430};

    int RETURN_BUTTON_WIDTH = 140;
    int RETURN_BUTTON_HEIGHT = 55;
    int[] RETURN_BUTTON_COORDINATES = {130, 140};

    int GAMEOVER_IMAGE_WIDTH = 350;
    int GAMEOVER_IMAGE_HEIGHT = 75;
    int[] GAMEOVER_IMAGE_COORDINATES = {25, 35};

    int CONGRATS_IMAGE_WIDTH = 300;
    int CONGRATS_IMAGE_HEIGHT = 135;
    int[] CONGRATS_IMAGE_COORDINATES = {50, 20};

    int LOGO_WIDTH = 390;
    int LOGO_HEIGHT = 80;
    int LOGO_TOP_BORDER_LINE = 60;
    int LOGO_LEFT_BORDER_LINE = 255;

    char AXE = 'A';
    char CHEST_WITH_KEY = 'B';
    char EMPTY_CHEST = 'C';
    char CLOSED_DOOR = 'D';
    char AXE_AGAINST_ZOMBIES = 'E';
    char CASTLE = 'F';
    char GRASS = 'G';
    char HERO = 'H';
    char OPENED_DOOR = 'I';
    char OPENED_CHEST = 'J';
    char KEY = 'K';
    char CHEST_WITH_SPIKES = 'L';
    char MONEY = 'M';
    char CHEST_WITH_MONEY = 'N';
    char HEALTH = 'O';
    char WALL_WITH_KEY = 'P';
    char ZOMBIE_WITH_KEY = 'Q';
    char DESTROYED_WALL = 'R';
    char SOLDIER = 'S';
    char TREE = 'T';
    char WOOD = 'U';
    char CHEST_WITH_HEALTH = 'V';
    char WATER = 'W';
    char WALL = 'X';
    char ANGRY_SOLDIER = 'Y';
    char ZOMBIE = 'Z';
    char GROUND = '.';
    char FENCE_HOR = '/';
    char FENCE_VERT = ':';
    char SPIKES = '?';
    char BACKGROUND = '[';
    char CHOICE = ']';
    char ANGRY_ZOMBIE = '>';
    char ANGRY_ZOMBIE_WITH_KEY = '!';
    char ZOMBIE_WITH_AXE = '<';
    char ANGRY_ZOMBIE_WITH_AXE = ';';

    String PATH_MAP = "src/main/resources/Map.txt";
    String PATH_ITEMS = "src/main/resources/Items.txt";
    String PATH_HEALTH = "src/main/resources/Health.txt";
    String PATH_LAST_MAP = "src/main/resources/lastMap.txt";
    String PATH_LAST_ITEMS = "src/main/resources/lastItems.txt";
    String PATH_LAST_HEALTH = "src/main/resources/lastHealth.txt";

    String PATH_IMAGE_NEW_GAME_BUTTON = "src/main/resources/UI/newGame.png";
    String PATH_IMAGE_LOAD_GAME_BUTTON = "src/main/resources/UI/loadGame.png";
    String PATH_IMAGE_HELP_BUTTON = "src/main/resources/UI/help.png";
    String PATH_IMAGE_HELP_BACKGROUND = "src/main/resources/UI/helpBackground.png";
    String PATH_IMAGE_EXIT_BUTTON = "src/main/resources/UI/exit.png";
    String PATH_IMAGE_BACK = "src/main/resources/UI/back.png";
    String PATH_IMAGE_OK_BUTTON = "src/main/resources/UI/ok.png";
    String PATH_IMAGE_RETURN_TO_MENU_BUTTON = "src/main/resources/UI/returnToMenu.png";
    String PATH_IMAGE_SAVE_GAME = "src/main/resources/UI/save.png";
    String PATH_IMAGE_GAMEOVER = "src/main/resources/UI/gameOver.png";
    String PATH_IMAGE_CONGRATS = "src/main/resources/UI/congrats.png";
    String PATH_IMAGE_BACKGROUNG = "src/main/resources/UI/background.png";
    String PATH_IMAGE_DIALOG_BACKGROUNG = "src/main/resources/UI/dialogBackground.png";
    String PATH_IMAGE_ITEMS_BAR = "src/main/resources/UI/itemsBar.png";
    String PATH_IMAGE_LOGO = "src/main/resources/UI/logo.png";
    String PATH_IMAGE_TEXT = "src/main/resources/UI/text.png";
    String PATH_IMAGE_KEVIN_BUTTON = "src/main/resources/UI/kevinButton.png";
    String PATH_IMAGE_OLIVIA_BUTTON = "src/main/resources/UI/oliviaButton.png";
    String PATH_IMAGE_JACOB_BUTTON = "src/main/resources/UI/jacobButton.png";

    String PATH_IMAGE_KEVIN_UP = "src/main/resources/heroes/kevinUp.png";
    String PATH_IMAGE_KEVIN_DOWN = "src/main/resources/heroes/kevinDown.png";
    String PATH_IMAGE_KEVIN_LEFT = "src/main/resources/heroes/kevinLeft.png";
    String PATH_IMAGE_KEVIN_RIGHT = "src/main/resources/heroes/kevinRight.png";

    String PATH_IMAGE_OLIVIA_DOWN = "src/main/resources/heroes/oliviaDown.png";
    String PATH_IMAGE_OLIVIA_LEFT = "src/main/resources/heroes/oliviaLeft.png";
    String PATH_IMAGE_OLIVIA_UP = "src/main/resources/heroes/oliviaUp.png";
    String PATH_IMAGE_OLIVIA_RIGHT = "src/main/resources/heroes/oliviaRight.png";

    String PATH_IMAGE_JACOB_DOWN = "src/main/resources/heroes/jacobDown.png";
    String PATH_IMAGE_JACOB_LEFT = "src/main/resources/heroes/jacobLeft.png";
    String PATH_IMAGE_JACOB_UP = "src/main/resources/heroes/jacobUp.png";
    String PATH_IMAGE_JACOB_RIGHT = "src/main/resources/heroes/jacobRight.png";

    String PATH_IMAGE_SOLDIER_FORWARD = "src/main/resources/heroes/soldierForward.png";
    String PATH_IMAGE_SOLDIER_LEFT = "src/main/resources/heroes/soldierLeft.png";
    String PATH_IMAGE_SOLDIER_BACK = "src/main/resources/heroes/soldierBack.png";
    String PATH_IMAGE_SOLDIER_RIGHT = "src/main/resources/heroes/soldierRight.png";
    String PATH_IMAGE_ANGRY_SOLDIER = "src/main/resources/heroes/soldierAngry.png";

    String PATH_IMAGE_ZOMBIE_FORWARD = "src/main/resources/heroes/zombieForward.png";
    String PATH_IMAGE_ZOMBIE_LEFT = "src/main/resources/heroes/zombieLeft.png";
    String PATH_IMAGE_ZOMBIE_BACK = "src/main/resources/heroes/zombieBack.png";
    String PATH_IMAGE_ZOMBIE_RIGHT = "src/main/resources/heroes/zombieRight.png";
    String PATH_IMAGE_ANGRY_ZOMBIE = "src/main/resources/heroes/zombieAngry.png";

    String PATH_IMAGE_AXE = "src/main/resources/images/axe.png";
    String PATH_IMAGE_AXE_DIAMOND =  "src/main/resources/images/axeDiamond.png";
    String PATH_IMAGE_CASTLE = "src/main/resources/images/castle.png";
    String PATH_IMAGE_CHEST_CLOSED = "src/main/resources/images/chestClosed.png";
    String PATH_IMAGE_CHEST_OPENED = "src/main/resources/images/chestOpened.png";
    String PATH_IMAGE_CHOICE = "src/main/resources/images/choice.png";
    String PATH_IMAGE_DOOR_CLOSED = "src/main/resources/images/doorClosed.png";
    String PATH_IMAGE_DOOR_OPENED = "src/main/resources/images/doorOpened.png";
    String PATH_IMAGE_FENCE_HOR = "src/main/resources/images/fenceHor.png";
    String PATH_IMAGE_FENCE_VERT = "src/main/resources/images/fenceVert.png";
    String PATH_IMAGE_GRASS = "src/main/resources/images/grass.png";
    String PATH_IMAGE_GROUND = "src/main/resources/images/ground.png";
    String PATH_IMAGE_HEALTH = "src/main/resources/images/health.png";
    String PATH_IMAGE_KEY = "src/main/resources/images/key.png";
    String PATH_IMAGE_MONEY = "src/main/resources/images/money.png";
    String PATH_IMAGE_SPIKES = "src/main/resources/images/spikes.png";
    String PATH_IMAGE_TREE = "src/main/resources/images/tree.png";
    String PATH_IMAGE_WALL = "src/main/resources/images/wall.png";
    String PATH_IMAGE_WALL_DESTROYED = "src/main/resources/images/wallDestroyed.png";
    String PATH_IMAGE_WATER = "src/main/resources/images/water.png";
    String PATH_IMAGE_WOOD = "src/main/resources/images/wood.png";

}
