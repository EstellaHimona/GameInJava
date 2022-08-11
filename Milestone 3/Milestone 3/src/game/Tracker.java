package game;

import city.cs.engine.StepListener;
import city.cs.engine.StepEvent;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class Tracker implements StepListener {
    private Game game;
    private GameView view;

    private Random rand;
    // Control-Variables
    private int temp=0;
    private boolean isRunning=true;

    public Tracker(GameView view, Game game) {
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
            if (temp % 300 == 0) {
                //create the bad penguin into the world when the timer fires
                new BadPenguin(game.getLevel()).setPosition(new Vec2(rand.nextInt(10), 5));
                temp = 0;
            }
        }
    }
}
