package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiveFocus implements MouseListener {

    private final Game game;

    //create a constructor for the give focus class
    public GiveFocus(Game game){
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        game.getView().requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
