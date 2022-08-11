package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PenguinCoffee extends Walker {

    private static final Shape finalPenguinShape = new PolygonShape(
            -1.98f,2.12f, -3.55f,-0.75f, -2.85f,-2.32f, -1.05f,-2.32f, -0.3f,-0.63f);

    private static BodyImage finalImage =
            new BodyImage ("data/coffeepile.png",10f);


    SolidFixture f = new SolidFixture(this, finalPenguinShape);

    private static int BeansCount;

    public PenguinCoffee(World world) {
        super(world, finalPenguinShape);
        addImage(finalImage);
        this.setPosition(new Vec2(8, 10));

        BeansCount = 0;
    }


    public static void addBeansCount() {
        BeansCount++;
        System.out.println("Your score is:" +
                BeansCount);
    }
}
