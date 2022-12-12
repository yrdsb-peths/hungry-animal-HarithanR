import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * THe world where our game takes place
 * 
 * @author Harithan Raveendran
 * @version December 2022
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    int espeedLeft = -3;
    int espeedRight = 3;
    public int eleSpeed = 1;
    Label speedLabel;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Adds the player character, being the elephant, to our game.
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
                
        
        Label titleScoreLabel = new Label("Score:", 30);
        addObject(titleScoreLabel, 50, 50);
        
        scoreLabel = new Label(0, 40);
        addObject(scoreLabel, 100, 50); 
        
        Label titleSpeedLabel = new Label("Speed:", 30);
        addObject(titleSpeedLabel, 50, 80);
        
        speedLabel = new Label(0, 40);
        addObject(speedLabel, 100, 80);
        speedLabel.setValue(eleSpeed); 
        
        createApple();
        elephant.setElephantSpeed(espeedLeft,espeedRight);
        }
    
    public void gameOver()
    {
        /**
         * Creates a lose condition for the player. In other words, once the
         * apple falls out of the player's reach, text saying "Game Over"
         * appears on the screen.
         */
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        /**
         * Keeps track of how many apples the player collected.
         */
        score++;
        scoreLabel.setValue(score);
        
        if(score % 5 == 0)
        {
            level += 1;
        }
        
         
        if(score % 5 == 0)
        {
            espeedLeft -= 3;
            espeedRight += 3;
            eleSpeed++;
            speedLabel.setValue(eleSpeed); 
        }

    }
    
       
    public void createApple()
    {
        /**
         * Creates an apple for the player to catch. The apple can appear
         * anywhere randomly on the top of the map. Once it has been
         * caught, another spawns in.
         */
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
       
    }
}
