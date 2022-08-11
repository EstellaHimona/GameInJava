package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PenguinCoffee extends Walker {

    //create the shape of the penguin coffee walker
    private static final Shape finalPenguinShape = new PolygonShape(
            -1.98f, 2.12f, -3.55f, -0.75f, -2.85f, -2.32f, -1.05f, -2.32f, -0.3f, -0.63f);

    //implement the image for the penguin coffee
    private static BodyImage finalImage =
            new BodyImage("data/coffeepile.png", 10f);

    //create a constructor for the penguin coffee class
    public PenguinCoffee(World world) {
        super(world, finalPenguinShape);
        addImage(finalImage);
        this.setPosition(new Vec2(8, 10));
    }
}
