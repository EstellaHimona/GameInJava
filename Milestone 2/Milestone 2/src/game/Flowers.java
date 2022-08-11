package game;

import city.cs.engine.*;

public class Flowers extends DynamicBody{

    //create the shape for the flower pot
    private static final Shape potShape = new PolygonShape(

            -0.278f,0.848f,
            -0.694f,0.204f,
            -0.158f, -0.936f,
            0.374f,-0.936f,
            0.538f,0.5f);

    //implement the image for the flower pot
    private static final BodyImage image =
            new BodyImage("data/flowers.png", 2f);

    //create a constructor for the flowers pot
    public Flowers(World w) {
        super(w, potShape);
        addImage(image);
    }

    //create a destroy method for the flowers pot
    public void destroy () {
        super.destroy();
    }
}

