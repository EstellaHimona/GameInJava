package game;

import city.cs.engine.*;


public class BeanCounter extends DynamicBody {

    private static final Shape beanShape = new PolygonShape(
            -1.34f,-0.27f, 1.62f,-0.26f, 1.62f,0.8f, -1.34f,0.8f);

    SolidFixture headFixture = new SolidFixture(this, beanShape, 20);

    private static final BodyImage image =
            new BodyImage("data/coffee.png", 6f);


    public BeanCounter(World w) {
        super(w, beanShape);
        addImage(image);
    }
}


