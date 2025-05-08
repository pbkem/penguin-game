import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tux here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tux extends Actor
{
    //declare method that tracks balloons popped
    private int balloonsPopped = 0;
    private int fishesCaught = 0;
    private int win = 45;
    private int toWin = 15;
    
    public void act()
    {
        checkKeyPress();
        lookOut();
    }
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-1, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+1, getY());
        } 
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-1);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+1);
        }
    }
    private void lookOut(){
        /**
         * if tux touches balloon remove balloon
         * import pop sound when tux pops balloon
         * when balloon is popped add + to score
         */
        
        if(isTouching(Balloon.class))
        {
            removeTouching(Balloon.class);
            Greenfoot.playSound("pop.wav");
            balloonsPopped++;
        }
            getWorld().showText("Balloons Popped: " + balloonsPopped,100,30);
            
            if(balloonsPopped == toWin)
            {
                Greenfoot.playSound("fanfare.wav");
                getWorld().showText("Congratulations! You've popped" + toWin + "ballons",getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.stop();
            }
        if(isTouching(Fish.class))
        {
            removeTouching(Fish.class);
            Greenfoot.playSound("pop.wav");
            fishesCaught++;
        }
                getWorld().showText("Fishes Caught: " + fishesCaught,100,50);
                
                if(fishesCaught == toWin)
                {
                    Greenfoot.playSound("fanfare.wav");
                    getWorld().showText("Congratulations! You've caught" + win + "Fishes, You Win!",getWorld().getWidth()/2, getWorld().getHeight()/2);
                    Greenfoot.stop();
                }
        if(isTouching(Bomb.class))
        {
            removeTouching(Bomb.class);
            Greenfoot.playSound("au.wav");
            getWorld().showText("You Lose!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
            }
    }