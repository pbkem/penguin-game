import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Kem Atayi
 * @version 03/28/2024
 */

public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * @param this sets the width of the world wihtout hardcoding
     * @param this sets the height of the owrld without hardcoding
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750,550,1); 
        prepare();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("s"))
        {
           prepare();
        }
        
    }
    private void prepare()
    {
        //Call actor objects to add
        gameInstructions();
        addBalloons(75);
        addFish(20);
        addRandomBomb(13);
        addTux(); //add Tux seperatley, make sure it is at bottom right 
    }
    /**
     * constuct prepare method to set background image
     */
    /**
     * Use showText method too display instructions to players
     */
    public void gameInstructions()
    {
         String instructions ="Use keys to control Tux.15 fishes,Pop 45 balloons. Touch a bomb you lose.";
         //set text slightly above  geometric center.
         int xPosition = getWidth()/2;
         int yPosition = getHeight()/3;
         showText(instructions, xPosition, yPosition);
    }
    private void addBalloons(int numBalloons)
    {
        for (int i = 0; i < numBalloons; i++)
        {
            addObject(new Balloon(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }
    }
    private void addFish(int numFish) 
    {
        for (int i = 0; i < numFish; i++)
        {
            addObject(new Fish(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }
    }
    private void addRandomBomb( int numRandomBomb)
    {
       for (int i = 0; i < numRandomBomb; i++)
        {
            addObject(new Bomb(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        }
    }
    //construct method that spawns tux at bottom right
    private void addTux()
    {
        addObject(new Tux(),getWidth() -1, getHeight() -1);
    }
}
