package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BeansPickup implements CollisionListener {

    private final YellowPenguin penguin;
    public BeansPickup(YellowPenguin s){
        this.penguin = s;
    }


    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof BeanCounter) {
            PenguinCoffee.addBeansCount();
            e.getOtherBody().destroy();
        }
    }
}