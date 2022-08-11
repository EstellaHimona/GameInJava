package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BeansPickup implements CollisionListener {

    private final GameLevel level;
    private final Game game;

    private final YellowPenguin penguin;

    //create a constructor for the beans pickup
    public BeansPickup(YellowPenguin s, GameLevel l, Game g){
        this.penguin = s;
        this.level = l;
        this.game = g;
    }

    //create the collision listener for the beans pickup
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof BeanCounter) {
            penguin.addBeansCount();
            e.getOtherBody().destroy();
            if (level.isComplete())
                game.goToNextLevel();
        }
    }
}