package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Level1 extends GameLevel {

    public Level1 (Game game) {
        //base case will create the penguins
        super(game);

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
        for (int i=0; i<5; i++) {
            BeanCounter pileOfCounters = new BeanCounter(this);
            pileOfCounters.setPosition(new Vec2(8, 5));
            pileOfCounters.setLinearVelocity(new Vec2(-2, 10));
            pileOfCounters.applyTorque(100f);
        }

        //create the beans pickup
        BeansPickup pickup = new BeansPickup(getYellowPenguin(), this, game);
        getYellowPenguin().addCollisionListener(pickup);
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
}
