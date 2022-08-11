package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.Random;

public class GameWorld extends World {

    private final YellowPenguin penguin;
    private Hammer hammer;
    private BeanCounter pileofcounters;
    private BeanCounter beancounter;
    private final PenguinCoffee penguinCoffee;
    private Random random = new Random();
    private int upperbound = 10;


    public GameWorld() {
        super();

        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8.57f));


        // make a character
        penguin = new YellowPenguin(this);
        penguin.setPosition(new Vec2(-8, 5));


        penguinCoffee = new PenguinCoffee(this);
        penguinCoffee.setPosition(new Vec2 (100, 7));



        for (int i=0; i<5; i++) {
            pileofcounters = new BeanCounter(this);
            pileofcounters.setPosition(new Vec2(random.nextInt(upperbound), random.nextInt(upperbound)));
        }

        for (int i=0; i<2; i++) {
            hammer = new Hammer(this);
            hammer.setPosition(new Vec2(8+i*3, 10+i*3));
        }


        // walls
        Shape wallShape = new BoxShape(0.5f, 8);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-14.3f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(14.3f, -6));


        BeansPickup pickup = new BeansPickup(penguin);
        penguin.addCollisionListener(pickup);



    }

    public YellowPenguin getYellowPenguin() {
        return penguin;
    }
    
    public PenguinCoffee getPenguinCoffee () {
        return penguinCoffee;
    }

    public BeanCounter getBeanCounter() {
        return beancounter;
    }


}