package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class YellowPenguinController implements KeyListener {

    private static final float MOVING_SPEED = 5;

    private float penguinSize = 5f;

    private Game game;

    private BodyImage leftImage;

    private BodyImage rightImage;


    //constructor for the yellow penguin controller class
    public YellowPenguinController(Game game){
        this.game = game;
        leftImage = new BodyImage("data/club penguin left.png",   game.getLevel().getYellowPenguin().getPenguinSize());
        rightImage = new BodyImage("data/club penguin right.png",   game.getLevel().getYellowPenguin().getPenguinSize());
    }

    //implement a key listener for when a specific key is typed
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //implement a key listener for when a specific key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_LEFT) {
            game.getLevel().getYellowPenguin().startWalking(-MOVING_SPEED);
            game.getLevel().getYellowPenguin().setYellowPenguinDirection(leftImage);
        }
        else if (code == KeyEvent.VK_RIGHT) {
            game.getLevel().getYellowPenguin().startWalking(MOVING_SPEED);
            game.getLevel().getYellowPenguin().setYellowPenguinDirection(rightImage);
        }
        else if (code == KeyEvent.VK_UP){
            game.getLevel().getYellowPenguin().jump (MOVING_SPEED*3);
        }
        else if (code == KeyEvent.VK_V) {
            game.getLevel().getYellowPenguin().destroy();
        }

        else if (code == KeyEvent.VK_SPACE){
            Mullet m = new Mullet(game.getLevel(),
                    game.getLevel().getYellowPenguin().getPosition().add(new Vec2(-2, 0)),
                    6000, game);
        }
    }

    //implement a key listener for when a specific key is released
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            game.getLevel().getYellowPenguin().stopWalking();
        }
        else if (code == KeyEvent.VK_RIGHT) {
            game.getLevel().getYellowPenguin().stopWalking();
        }
    }
}
