package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class BeanCounter extends DynamicBody {

    private static final Shape beanShape = new PolygonShape(
            -1.34f,-0.27f, 1.62f,-0.26f, 1.62f,0.8f, -1.34f,0.8f);

    //add sound for bean counter pickup
    private static SoundClip beanCounterSound;
    static {
        try{
            beanCounterSound = new SoundClip("data/beanCounter.wav");
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    // load the image of the bean counter body
    private static final BodyImage image =
            new BodyImage("data/coffee.png", 6f);


    //constructor of bean counters
    public BeanCounter(World w) {
        super(w, beanShape);
        addImage(image);
    }

    //destroy the bean counter from the world and play the sound
    public void destroy () {
        beanCounterSound.play();
        super.destroy();
    }
}


