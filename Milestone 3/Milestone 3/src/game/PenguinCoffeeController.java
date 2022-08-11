package game;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PenguinCoffeeController implements KeyListener {

    private static float MOVING_SPEED = 2;

    private Game game;

    //create a constructor for the penguin coffee controller class
    public PenguinCoffeeController(Game game){
        this.game = game;
    }

    //implement a key listener when a specific key is typed
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //implement a key listener when a specific key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_V) {
            game.getLevel().getPenguinCoffee().setPosition(new Vec2(-5, 20));
            System.out.println("GAME OVER! YOUR PENGUIN CANNOT CARRY SO MUCH WEIGHT!!!");
        }
        if (code == KeyEvent.VK_LEFT) {
            game.getLevel().getPenguinCoffee().startWalking(-MOVING_SPEED);
        }
        else if (code == KeyEvent.VK_RIGHT) {
            game.getLevel().getPenguinCoffee().startWalking(MOVING_SPEED);
        }
    }

    //implement a key listener when a specific key is released
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            game.getLevel().getPenguinCoffee().stopWalking();
        }
        else if (code == KeyEvent.VK_RIGHT) {
            game.getLevel().getPenguinCoffee().stopWalking();
        }
    }
}

