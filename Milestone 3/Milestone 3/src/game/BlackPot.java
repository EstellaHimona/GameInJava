package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BlackPot extends DynamicBody{

    //create the shape for the pot
    private static final Shape potShape = new PolygonShape(

            1.2f,-3.18f, 2.0f,-4.46f, 3.48f,-4.46f, 4.08f,-3.02f);

    //add sound for black pot collision
    private static SoundClip blackPotSound;
    static {
        try{
            blackPotSound = new SoundClip("data/blackPot.wav");
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    //implement the image for the black pot
    private static final BodyImage image =
            new BodyImage("data/black.png", 15f);

    //create the constructor for the black pot
    public BlackPot(World w) {
        super(w, potShape);
        addImage(image);
    }

    //create the destroy method for destroying the black pot from the world
    public void destroy () {
        blackPotSound.play();
        super.destroy();
    }
}
