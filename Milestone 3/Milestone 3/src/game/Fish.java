package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Fish extends DynamicBody{

    //create the shape for the fish
    private static final Shape fishShape = new PolygonShape(

            -1.34f,0.2f, -1.24f,-0.41f, 1.27f,-0.5f, 0.19f,0.67f);

    //add sound for fish collision
    private static SoundClip fishSound;
    static {
        try{
            fishSound = new SoundClip("data/fish.wav");
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    //implement the image for the fish body
    private static final BodyImage image =
            new BodyImage("data/fish.png", 3f);

    //create a constructor for the fish class
    public Fish(World w) {
        super(w, fishShape);
        addImage(image);
    }

    //create a method for destroying the fish
    public void destroy () {
        fishSound.play();
        super.destroy();
    }
}
