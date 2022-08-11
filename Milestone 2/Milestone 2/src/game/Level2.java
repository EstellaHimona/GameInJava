package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class Level2 extends GameLevel {

    public Level2 (Game game) {
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

        //add the pile of bean counters
        for (int i=0; i<9; i++) {
            BeanCounter pileOfCounters = new BeanCounter(this);
            pileOfCounters.setPosition(new Vec2(random.nextInt(upperbound), random.nextInt(upperbound)));
        }

        //create the beans pickup
        BeansPickup pickup = new BeansPickup(getYellowPenguin(), this, game);
        getYellowPenguin().addCollisionListener(pickup);

        //create and position the flower pot on the platform
        Flowers flowers = new Flowers (this);
        flowers.setPosition(new Vec2(-5, 5));
        flowers.setGravityScale(0f);

        //create the flowers collision listener
        FlowersCollision flowersCollision = new FlowersCollision(this, game, getYellowPenguin());
        getYellowPenguin().addCollisionListener(flowersCollision);
    }


    //create the isComplete method to change the value of the boolean when level 2 is completed
    //after grabbing all the bean counters from the ground
    @Override
    public boolean isComplete() {
        if (getYellowPenguin().getBeansCount() == 10)
            return true;
        else
            return false;
    }
}
