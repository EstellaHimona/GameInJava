package game;

import city.cs.engine.StepListener;
import city.cs.engine.StepEvent;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class MulletTracker implements StepListener {
    private Game game;
    private GameView view;

    private Random rand;
    // Control-Variables
    private int temp=0;
    private boolean isRunning=true;

    public MulletTracker(GameView view, Game game) {
        this.view = view;
        this.game = game;
        rand = new Random();
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        if (isRunning) {
            temp++;
            // Adjust this in increments of 60. 60 almost equals 1 second.
            if (temp % 500 == 0) {
                //add the mullet into the world when the timer fires
                new Mullet(game.getLevel(),
                        game.getLevel().getYellowPenguin().getPosition().add(new Vec2(-2, 0)),
                        6000,
                        game);
                temp = 0;
            }
        }
    }
}
