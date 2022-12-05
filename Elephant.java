import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant, the player character.
 * 
 * @author Harithan Raveendran 
 * @version December 2022
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        // Removes apple if the elephant eats it.
        eat();
    }
    
    /**
     * Eats the apple and spawns a new one
     */   
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
        }
    }
