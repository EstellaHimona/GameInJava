package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class Level4 extends GameLevel {


    public Level4 (Game game) {
        //base case will create the penguins
        super(game);

        Random random = new Random();
        int upperbound = 10;

        //need to set the positions of the characters cause at the
        //end of the previous level they were positioned
        //somewhere else
        getYellowPenguin().setPosition(new Vec2(-11, 0));
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
                pileOfCounters.setPosition(new Vec2(10, 1+j));
        }

        for (int j = 0; j < 5; j++) {
            BeanCounter pileOfCounters = new BeanCounter(this);
            pileOfCounters.setPosition(new Vec2(8, 1-j));
        }

        //create the beans pickup
        BeansPickup pickup = new BeansPickup(getYellowPenguin(), this, game);
        getYellowPenguin().addCollisionListener(pickup);

        //create some black pots when the level starts
        BlackPot blackPot = new BlackPot(this);
        blackPot.setPosition(new Vec2(-4, 10));
        blackPot.setGravityScale(0f);

        //create the collision listener for the black pot
        BlackPotCollision blackPotCollision = new BlackPotCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(blackPotCollision);


        //create and position the flower pot on the platform
        Flowers flowers = new Flowers (this);
        flowers.setPosition(new Vec2(-8, 6));
        flowers.setGravityScale(0f);

        //create the flowers collision listener
        FlowersCollision flowersCollision = new FlowersCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(flowersCollision);

        //create and position the fish on the platform
        Fish fish = new Fish (this);
        fish.setPosition(new Vec2(4, 3));
        fish.setGravityScale(0f);

        //create the fish collision listener
        FishCollision fishCollision = new FishCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(fishCollision);
    }


    //create the isComplete method to change the value of the boolean when level 4 is completed
    //after grabbing all the bean counters from the ground
    @Override
    public boolean isComplete() {
        if (getYellowPenguin().getBeansCount() == 15)
            return true;
        else
            return false;
    }
}