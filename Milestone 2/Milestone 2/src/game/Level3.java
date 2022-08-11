package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.util.Random;

public class Level3 extends GameLevel {

    public Level3 (Game game) {
        //base case will create the penguins
        super(game);

        Random random = new Random();
        int upperbound = 10;

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

        //add the piles of bean counters
        for (int j = 0; j < 10; j++) {
                BeanCounter pileOfCounters = new BeanCounter(this);
                pileOfCounters.setPosition(new Vec2((int)(8+(j*0.5)), 1));
                pileOfCounters.setLinearVelocity(new Vec2(-1, 5));
                pileOfCounters.applyTorque(100f);
        }


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

    }

    //create the isComplete method to change the value of the boolean when level 3 is completed
    //after grabbing all the bean counters from the ground
    @Override
    public boolean isComplete() {
        if (getYellowPenguin().getBeansCount() == 10)
            return true;
        else
            return false;
    }
}