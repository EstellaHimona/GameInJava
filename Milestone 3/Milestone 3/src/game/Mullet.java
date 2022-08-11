package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Mullet implements ActionListener {

    private DynamicBody mullet;
    private DynamicBody wave;
    private Game game;

    private static SoundClip waveSound;

    static{
        try {
            waveSound = new SoundClip("data/wave.wav");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private int timerCount;

    public Mullet (GameLevel world, Vec2 pos, int time, Game game) {

        mullet = new DynamicBody(world, new PolygonShape(
                -0.85f,1.46f, -4.54f,-1.13f, 4.64f,-0.83f, 4.42f,0.85f));
        mullet.addImage(new BodyImage("data/red fish.png", 2f));
        mullet.setPosition(pos);

        Timer timer = new Timer(time, this);
        timer.start();
        timer.setRepeats(false);

        timerCount = 0;
        this.game = game;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timerCount++;

        if (timerCount == 1) {
            mullet.destroy();
            waveSound.play();

            wave = new DynamicBody(mullet.getWorld(), new PolygonShape(
                    -3.48f, 1.92f, -3.48f, -1.92f, 3.48f, -1.92f, 3.48f, 1.92f));
            wave.addImage(new BodyImage("data/wave.gif", 40f));
            wave.setPosition(mullet.getPosition());

            Timer t = new Timer(700, this);
            t.setRepeats(false);
            t.start();

            wave.addCollisionListener(new CollisionListener() {
                @Override
                public void collide(CollisionEvent collisionEvent) {
                    if (collisionEvent.getOtherBody() instanceof DynamicBody) {
                        collisionEvent.getOtherBody().destroy();
                        //game.getLevel().getFlowers().destroy();
                        //game.getLevel().getBlackPot().destroy();
                    }
                }
            });
        }

        if (timerCount == 2) {
            wave.destroy();
            waveSound.stop();
        }
    }
}
