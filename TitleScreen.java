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
        Label titleLabel = new Label("Hungry Elephant", 80);
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    public void act(){
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
        Elephant elephant = new Elephant();
        addObject(elephant,310,114);
        elephant.setLocation(519,124);
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,258,333);
        label.setLocation(284,335);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,282,287);
        label2.setLocation(284,385);

        elephant.setLocation(269,115);
    }
}
