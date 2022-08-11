package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.Random;

public class GameWorld extends World {

    private final YellowPenguin penguin;
    private BeanCounter pileOfCounters;
    public BeanCounter beanCounter;
    private final PenguinCoffee penguinCoffee;
    private Random random = new Random();
    private int upperbound = 10;


    public GameWorld() {
        super();

        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8.57f));


        // make a penguin character
        penguin = new YellowPenguin(this);
        penguin.setPosition(new Vec2(-8, 5));

        //make another penguin character
        penguinCoffee = new PenguinCoffee(this);
        penguinCoffee.setPosition(new Vec2 (100, 7));



        //create the pile of bean counters
        for (int i=0; i<5; i++) {
            pileOfCounters = new BeanCounter(this);
            pileOfCounters.setPosition(new Vec2(random.nextInt(upperbound), random.nextInt(upperbound)));
        }

        //make the walls not appearing on the screen
        Shape wallShape = new BoxShape(0.5f, 8);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-14.3f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(14.3f, -6));


        //create the beans pickup
//        BeansPickup pickup = new BeansPickup(penguin);
//        penguin.addCollisionListener(pickup);



    }

    //Yellow Penguin getter method
    public YellowPenguin getYellowPenguin() {
        return penguin;
    }

    //Penguin Coffee getter method
    public PenguinCoffee getPenguinCoffee () {
        return penguinCoffee;
    }

    //Bean Counters getter method
    public BeanCounter getBeanCounter() {
        return beanCounter;
    }


}