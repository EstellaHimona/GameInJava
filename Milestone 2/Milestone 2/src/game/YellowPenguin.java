package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class YellowPenguin extends Walker {

    //create the shape for the yellow penguin
    private static final Shape startingPenguinShape = new PolygonShape(
            -2.16f,2.35f, -0.59f,-2.11f, 1.78f,-1.27f, 1.61f,2.37f);

    //implement the image for the yellow penguin
    private static BodyImage startingImage =
            new BodyImage("data/club penguin left.png", 5f);

    //implement variables for the beans count and the lives
    private int BeansCount;
    private int Lives;

    //implement a constructor for the yellow penguin class
    public YellowPenguin(World world) {
        super(world, startingPenguinShape);
        addImage(startingImage);
        this.setPosition(new Vec2(-8, 5));

        //initialise the beans count and lives variables
        BeansCount = 0;
        Lives = 3;
    }

    //setter for the yellow penguin direction
    //changes when several keys are pressed
    public void setYellowPenguinDirection (BodyImage direction) {
        removeAllImages();
        YellowPenguin.startingImage = direction;
        addImage(startingImage);
    }

    //implement a method to increase the value of bean count by one and print it on the screen
    public void addBeansCount() {
        BeansCount++;
        System.out.println (BeansCount);
    }

    //getter for the beans count
    public int getBeansCount(){
        return BeansCount;
    }

    //setter for the beans count
    public void setBeansCount(int beansCount) {
        BeansCount = beansCount;
    }

    //implement a method to increase the value of the lives by one
    public void addLives() {
        Lives = Lives + 1;
    }

    //implement a method to decrease the value of the lives by one
    public void subtractLives(){
        Lives --;
    }

    //implement a method to increase the value of the lives by five
    public void addLives5 () {
        Lives = Lives+5;
    }

    //getter for the lives
    public int getLives () {
        return Lives;
    }


}


