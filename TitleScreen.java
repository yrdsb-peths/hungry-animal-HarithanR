import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of the game.
 * 
 * @author Harithan Raveendran
 * @version December 2022
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        /**
         * The title screen, placed in the center of a world different from
         * MyWorld.
         */
        Label titleLabel = new Label("Hungry Elephant", 80);
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    public void act(){
        /**
         * Allows the player to play the game by pressing space on the title
         * screen.
         */
        if(Greenfoot.isKeyDown("space")){
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        /**
         * Adds the elephant to the title screen world.
         */
        Elephant elephant = new Elephant();
        addObject(elephant,310,114);
        elephant.setLocation(519,124);

        /**
         * Adds text telling the player what they should do to properly
         * start playing the game in the title screen.
         */

        Label label = new Label("Press <space> to Start", 40);
        addObject(label,258,333);
        label.setLocation(284,255);

        /**
         * Adds text giving the player instructions on how to play the game
         * in the title screen.
         */

        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,282,287);
        label2.setLocation(284,285);


        elephant.setLocation(269,115);
        Apple apple = new Apple();
        addObject(apple,375,330);

        apple.setLocation(376,336);
        removeObject(apple);
    }
}
