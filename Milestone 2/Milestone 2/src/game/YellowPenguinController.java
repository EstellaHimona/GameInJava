package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class YellowPenguinController implements KeyListener {

    private static final float MOVING_SPEED = 5;

    private YellowPenguin startingPenguin;

    //constructor for the yellow penguin controller class
    public YellowPenguinController(YellowPenguin penguin){
        this.startingPenguin = penguin;
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
            startingPenguin.startWalking(-MOVING_SPEED);
            startingPenguin.setYellowPenguinDirection(new BodyImage("data/club penguin left.png", 5f));
        }
        else if (code == KeyEvent.VK_RIGHT) {
            startingPenguin.startWalking(MOVING_SPEED);
            startingPenguin.setYellowPenguinDirection(new BodyImage("data/club penguin right.png", 5f));
        }
        else if (code == KeyEvent.VK_UP){
            startingPenguin.jump (MOVING_SPEED*3);
        }
        else if (code == KeyEvent.VK_SPACE) {
            startingPenguin.destroy();
        }
    }

    //implement a key listener for when a specific key is released
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            startingPenguin.stopWalking();
        }
        else if (code == KeyEvent.VK_RIGHT) {
            startingPenguin.stopWalking();
        }
    }

    //implement a method to update the yellow penguin
    public void updateYellowPenguin(YellowPenguin startingPenguin) {
        this.startingPenguin = startingPenguin;
    }
}
