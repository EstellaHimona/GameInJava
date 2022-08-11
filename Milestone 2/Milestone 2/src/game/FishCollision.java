package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class FishCollision implements CollisionListener {

    private GameLevel level;
    private Game game;

    private YellowPenguin penguin;

    //create a constructor for the fish collision class
    public FishCollision(GameLevel level, Game game, YellowPenguin penguin) {
        this.level = level;
        this.game = game;
        this.penguin = penguin;
    }

    //create a collision event for the fish
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Fish) {
            penguin.addLives5();
            e.getOtherBody().destroy();
        }
    }
}
