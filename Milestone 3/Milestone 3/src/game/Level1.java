package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Level1 extends GameLevel implements ActionListener {

    private final Random rand;
    
    public Level1 (Game game) {
        //base case will create the penguins
        super(game);

        //create a new random variable for the position of the bean counters
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


        //add a timer the bean counters
        Timer beanTimer = new Timer(1000, this);
        beanTimer.start();

        Tracker badPenguin = new Tracker(game.getView(), game);
        this.addStepListener(badPenguin);

        //create the beans pickup
        BeansPickup pickup = new BeansPickup(getYellowPenguin(), this, game);
        getYellowPenguin().addCollisionListener(pickup);


        //create the bad penguin into the world when the timer fires
        BadPenguin badPengu = new BadPenguin(this);
        badPengu.setPosition(new Vec2(100, 5));

        badPengu.addCollisionListener(new CollisionListener() {
            @Override
            public void collide(CollisionEvent collisionEvent) {
                if (collisionEvent.getOtherBody() instanceof YellowPenguin) {
                    System.exit(0);
                }
            }
        });
    }


    //create the isComplete method to change the value of the boolean when level 1 is completed
    //after grabbing all the bean counters from the ground
    @Override
    public boolean isComplete() {
        if (getYellowPenguin().getBeansCount() == 5)
            return true;
        else
            return false;
    }

    //create an action performed method to keep track of when the timer fires
    @Override
    public void actionPerformed(ActionEvent e) {

        //create the bean counters into the world when the timer fires
        //and set their random position, linear velocity and torque
        BeanCounter pileOfCounters = new BeanCounter(this);
        pileOfCounters.setPosition(new Vec2(rand.nextInt(10), 5));
        pileOfCounters.setLinearVelocity(new Vec2(-2, 10));
        pileOfCounters.applyTorque(100f);
    }


}
