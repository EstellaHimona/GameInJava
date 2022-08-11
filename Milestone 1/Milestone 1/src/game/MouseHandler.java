package game;

import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private final GameWorld world;
    private final MyView view;

    public MouseHandler(GameWorld w, MyView v){
        world = w;
        view = v;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //create Books and add them to world
        Hammer hammer = new Hammer(world);
        //get the mouse coordinates
        Point mousePoint = e.getPoint();
        //transform them to world coordinates
        Vec2 worldPoint = view.viewToWorld(mousePoint);
        //position the books
        hammer.setPosition(worldPoint);
    }

    //we have to implement the other methods to satisfy
    //the interface, but we can leave them empty.

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
