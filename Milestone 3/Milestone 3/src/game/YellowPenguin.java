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
    private int beansCount;
    private int lives;

    //implement boolean variables to check whether the add/subtract lives methods have been called
    boolean lives1HasBeenCalled = false;
    boolean lives2HasBeenCalled = false;
    boolean lives5HasBeenCalled = false;

    //implement a float to keep track of the penguin size
    private float penguinSize = 5.0f;


    //implement a constructor for the yellow penguin class
    public YellowPenguin(World world) {
        super(world, startingPenguinShape);
        addImage(startingImage);
        this.setPosition(new Vec2(-8, 5));

        //initialise the beans count and lives variables
        beansCount = 0;
        lives = 3;
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
        beansCount++;
        System.out.println (beansCount);
    }

    //getter for the beans count
    public int getBeansCount(){
        return beansCount;
    }

    //setter for the beans count
    public void setBeansCount(int beansCount) {
        this.beansCount = beansCount;
    }

    //implement a method to increase the value of the lives by one
    public void addLives() {
        lives = lives + 1;
        lives1HasBeenCalled = true;
    }

    //implement a method to decrease the value of the lives by one
    public void subtractLives(){
        lives --;
        lives2HasBeenCalled = true;
    }

    //implement a method to decrease the value of the lives by 3
    public void subtractLives3 () {
        lives = lives - 3;
    }

    //implement a method to increase the value of the lives by five
    public void addLives5 () {
        lives = lives+5;
        lives5HasBeenCalled = true;
    }

    //getter for the lives
    public int getLives () {
        return lives;
    }

    public float getPenguinSize () {

        if (lives1HasBeenCalled)
            this.penguinSize = 5f;
        else if (lives2HasBeenCalled)
            this.penguinSize = 3f;
        else if (lives5HasBeenCalled)
            this.penguinSize = 10f;

        return this.penguinSize;

    }


}


