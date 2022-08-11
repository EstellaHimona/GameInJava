package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BlackPotCollision implements CollisionListener {

    private final GameLevel level;
    private final Game game;

    private final YellowPenguin penguin;

    //create the black pot collision class constructor
    public BlackPotCollision(GameLevel level, Game game, YellowPenguin penguin) {
        this.level = level;
        this.game = game;
        this.penguin = penguin;
    }

    //create a collision event for the black pot
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof BlackPot) {
            penguin.subtractLives();
            e.getOtherBody().destroy();
        }
    }
}
