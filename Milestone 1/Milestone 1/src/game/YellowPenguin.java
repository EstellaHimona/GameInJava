package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class YellowPenguin extends Walker {

    private static final Shape startingPenguinShape = new PolygonShape(
            -2.16f,2.35f, -0.59f,-2.11f, 1.78f,-1.27f, 1.61f,2.37f);

    private static BodyImage startingImage =
            new BodyImage("data/club penguin left.png", 5f);


    SolidFixture f = new SolidFixture(this, startingPenguinShape);


    public YellowPenguin(World world) {
        super(world, startingPenguinShape);
        addImage(startingImage);
        this.setPosition(new Vec2(-8, 5));
    }

    public void setYellowPenguinDirection (BodyImage direction) {
        removeAllImages();
        YellowPenguin.startingImage = direction;
        addImage(startingImage);
    }
}

