Milestone 1 extra classes

package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BeansController implements KeyListener {

    private static boolean space_typed;
    private final BeanCounter beancounter;

    public BeansController(BeanCounter beancounter) {
        this.beancounter = beancounter;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE) {
           // beancounter.destroy();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        int code = e.getKeyCode();
//        if (code == KeyEvent.VK_SPACE) {
//            space_typed = true;
//        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static boolean getSpaceTyped() {
        return space_typed;
    }

}







package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class BeansDrop implements CollisionListener {

    private final YellowPenguin penguin;
    private final BeanCounter beancounter;
    private boolean controller;

    public BeansDrop(YellowPenguin s, BeanCounter beancounter) {
        this.penguin = s;
        this.beancounter = beancounter;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof BeanCounter) {
            controller = BeansController.getSpaceTyped();

            if (controller) {
                System.out.println("m");
                e.getOtherBody().destroy();
                beancounter.setPosition(new Vec2(50, 10));
            }
        }

    }
}



package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private MyView view;
    private YellowPenguin penguin;
    public Tracker(MyView view, YellowPenguin penguin) {
        this.view = view;
        this.penguin = penguin;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(penguin.getPosition()));
    }
}