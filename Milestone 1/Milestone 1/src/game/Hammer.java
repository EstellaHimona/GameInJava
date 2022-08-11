package game;

import city.cs.engine.*;

public class Hammer extends DynamicBody {


        private static final Shape headShape = new PolygonShape(

                0.16f,-0.419f, 0.283f,-0.584f, 0.448f,-0.595f, 0.544f,-0.413f);

        SolidFixture headFixture = new SolidFixture(this, headShape, 20);

        private static final BodyImage image =
                new BodyImage("data/black.png", 18.5f);

        public Hammer (World w) {
            super(w, headShape);
            addImage(image);
        }
    }


