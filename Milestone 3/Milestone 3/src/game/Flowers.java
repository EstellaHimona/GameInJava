package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Flowers extends DynamicBody{

    //create the shape for the flower pot
    private static final Shape potShape = new PolygonShape(

            -0.278f,0.848f,
            -0.694f,0.204f,
            -0.158f, -0.936f,
            0.374f,-0.936f,
            0.538f,0.5f);

    //add sound for flowers pot collision
    private static SoundClip flowersPotSound;
    static {
        try{
            flowersPotSound = new SoundClip("data/flowersPot.wav");
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

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
        flowersPotSound.play();
        super.destroy();
    }
}

