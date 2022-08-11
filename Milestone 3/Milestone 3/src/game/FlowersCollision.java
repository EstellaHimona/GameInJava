package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FlowersCollision implements CollisionListener {

    private GameLevel level;
    private Game game;

    private YellowPenguin penguin;

    //create a constructor for the flowers collision class
    public FlowersCollision(GameLevel level, Game game, YellowPenguin penguin) {
        this.level = level;
        this.game = game;
        this.penguin = penguin;
    }

    //create a collision event for the flowers pot
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Flowers) {
            penguin.addLives();
            e.getOtherBody().destroy();
        }
    }
}
