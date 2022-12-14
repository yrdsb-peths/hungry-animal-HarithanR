import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our elephant
 * 
 * @author Harithan Raveendran
 * @version December 2022
 */
public class Apple extends Actor
{
    // The speed of which the apple falls to the ground.
    private int speed = 1;
    
    // The type of apple that is chosen to fall. 
    
    public void act()
    {
        /**
         * Sets the location for the apple and allows it to fall
         */
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        /**
         * Sets up the losing condition for the game. When the apple reaches
         * lower than the bottom of the world's height, text saying "Game
         * Over" will be placed in the middle of the screen.
         */
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
    
}
