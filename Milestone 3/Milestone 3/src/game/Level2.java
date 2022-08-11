package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Level2 extends GameLevel implements ActionListener {

    private Random rand;

    public Level2(Game game) {
        //base case will create the penguins
        super(game);

        //create a new timer
        Timer timer = new Timer(7000, this);
        timer.setInitialDelay(1000);
        timer.start();
        timer.setRepeats(false);

        //create a new random variable for the position of the bad penguin
        rand = new Random();

        //need to set the positions of the characters cause at the
        //end of the previous level they were positioned
        //somewhere else
        getYellowPenguin().setPosition(new Vec2(-8, 5));
        getPenguinCoffee().setPosition(new Vec2(100, 7));

        // make the ground
        Shape groundShape = new BoxShape(13, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8.57f));

        //make the walls not appearing on the screen
        Shape wallShape = new BoxShape(0.5f, 100);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-14.3f, 0));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(14.3f, 0));

        //create the beans pickup
        BeansPickup pickup = new BeansPickup(getYellowPenguin(), this, game);
        getYellowPenguin().addCollisionListener(pickup);

        //create and position the flower pot on the platform
        Flowers flowers = new Flowers(this);
        flowers.setPosition(new Vec2(-1, 5));
        flowers.setGravityScale(0f);

        //create the flowers collision listener
        FlowersCollision flowersCollision = new FlowersCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(flowersCollision);

        //create a controller for the bad penguin
        //and add a collision listener to it
//        BadPenguinController badPenguinController = new BadPenguinController(game);
//        this.getYellowPenguin().addCollisionListener(badPenguinController);
    }


    //create the isComplete method to change the value of the boolean when level 2 is completed
    //after grabbing all the bean counters from the ground
    @Override
    public boolean isComplete() {
        if (getYellowPenguin().getBeansCount() == 15)
            return true;
        else
            return false;
    }

    //create an action performed method to keep track of when the timer fires
    @Override
    public void actionPerformed(ActionEvent ae) {

        //create the bad penguin into the world when the timer fires
        BadPenguin badPenguin = new BadPenguin(this);
        badPenguin.setPosition(new Vec2(rand.nextInt(10), 5));

        badPenguin.addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent collisionEvent) {
                if (collisionEvent.getOtherBody() instanceof YellowPenguin) {
                    System.exit(0);
                }
            }
        });

        //create the bean counters into the world when the timer fires
        for (int i = 0; i < 10; i++) {
            BeanCounter pileOfCounters = new BeanCounter(this);
            pileOfCounters.setPosition(new Vec2(-8, 5+i));
        }
    }
}
