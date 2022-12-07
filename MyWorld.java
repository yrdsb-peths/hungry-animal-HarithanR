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
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50); 
        
        createApple();
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
