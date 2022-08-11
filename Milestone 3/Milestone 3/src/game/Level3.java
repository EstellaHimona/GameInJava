package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Level3 extends GameLevel implements ActionListener {

    private Random rand;

    public Level3 (Game game) {
        //base case will create the penguins
        super(game);

        //create a new timer for the bad penguin
        Timer timer = new Timer (1000, this);
        timer.start();

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

        //create the beans pickup
        BeansPickup pickup = new BeansPickup(getYellowPenguin(), this, game);
        getYellowPenguin().addCollisionListener(pickup);

        //create some black pots when the level starts
        BlackPot blackPot = new BlackPot(this);
        blackPot.setPosition(new Vec2(-1, 10));
        blackPot.setGravityScale(0f);

        //create the collision listener for the black pot
        BlackPotCollision blackPotCollision = new BlackPotCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(blackPotCollision);

        //create and position the flower pot on the platform
        Flowers flowers = new Flowers (this);
        flowers.setPosition(new Vec2(-5, 6));
        flowers.setGravityScale(0f);
        //create the flowers collision listener
        FlowersCollision flowersCollision = new FlowersCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(flowersCollision);

        //add the mullet tracked into the level
        MulletTracker mulletTracker = new MulletTracker(game.getView(), game);
        this.addStepListener(mulletTracker);

    }

    //create the isComplete method to change the value of the boolean when level 3 is completed
    //after grabbing all the bean counters from the ground
    @Override
    public boolean isComplete() {
        if (getYellowPenguin().getBeansCount() == 35)
            return true;
        else
            return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //add the piles of bean counters
            BeanCounter pileOfCounters = new BeanCounter(this);
            pileOfCounters.setPosition(new Vec2(rand.nextInt(10), 5));
            pileOfCounters.setLinearVelocity(new Vec2(-1, 5));
            pileOfCounters.applyTorque(100f);


    }
}