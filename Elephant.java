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
     * Allows the elephant to make noise. This noise triggers everytime the 
     * player catches an apple.
     */
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    /**
     * Allows the elephant to sway their trunk back and forth in an animation.
     */
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    public int speedLeft = -3;
    public int speedRight = 3;
    
    private int espeed = 0;
    
    String facing = "right";   
    SimpleTimer animationTimer = new SimpleTimer();
    
    boolean left = Greenfoot.isKeyDown("left");
    boolean right = Greenfoot.isKeyDown("right");
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);            
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    
    
    /**
     * Sets the speed for the elephant's idle animation. In other words, it
     * makes sure the animation for it is not going unnaturally fast or slow.
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        
        else 
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;            
        }
    }
    public void setElephantSpeed(int speed)
    {
        speedLeft = -speed;
        speedRight = speed;
        //espeed = speed;
     }
     public void increaseSpeed()
    {
         speedLeft -= 3;
         speedRight += 3;
        //espeed = speed;
     }
       public void act()
    {
        /**
         * Allows the character to move left or right depending on the keys
         * they press.
         */
        if(Greenfoot.isKeyDown("left"))
        {
            move(speedLeft);
            facing = "left";
        }
        
        else if(Greenfoot.isKeyDown("right"))
        {
            move(speedRight);
            facing = "right";
        }
        
        // Removes apple if the elephant eats it.
        eat();
        
        animateElephant();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
    }

}
