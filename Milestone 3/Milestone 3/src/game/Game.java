package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private final GameView view;

    private final YellowPenguinController yellowPenguinController;
    private final PenguinCoffeeController penguinCoffeeController;

    private final JFrame frame;

    /** Initialise a new Game. */
    public Game() {

        //initialise level to Level1
        level = new Level1(this);

        // make a view
        //view = new GameView(level, 550, 322);
        view = new GameView(this, 550, 350);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(level, view));

        yellowPenguinController = new YellowPenguinController(this);
        view.addKeyListener(yellowPenguinController);

        penguinCoffeeController = new PenguinCoffeeController(this);
        view.addKeyListener(penguinCoffeeController);

        view.addMouseListener(new GiveFocus(this));


        // add the view to a frame (Java top level window)
        frame = new JFrame("Club Penguin Bean Counters");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        //add the control panel to the game
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.NORTH);


        try {
            /* Creation of a field of type SoundClip for the background music*/
            SoundClip gameMusic = new SoundClip("data/bg music.wav");   //Open an audio stream file
            gameMusic.loop();   //Set it to continuous playback
        }
        catch (UnsupportedAudioFileException| IOException| LineUnavailableException e){
            System.out.println(e);
        }

        // start our game world simulation!
        level.start();
    }

    public GameLevel getLevel() {
        return level;
    }

    public GameView getView() {
        return view;
    }

    public void goToNextLevel(){

        if (level instanceof Level1){
            int Score;
            //stop the current level
            level.stop();
            //update the score
            Score = level.getYellowPenguin().getBeansCount();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //yellow penguin in the new world
            level.getYellowPenguin().setBeansCount(Score);
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level2){
            int Score1;
            //stop the current level
            level.stop();
            //update the score
            Score1 = level.getYellowPenguin().getBeansCount();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            level.getYellowPenguin().setBeansCount(Score1);
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level3){
            int Score2;
            //stop the current level
            level.stop();
            //update the score
            Score2 = level.getYellowPenguin().getBeansCount();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            //change the view to look into new level
            view.setWorld(level);
            level.getYellowPenguin().setBeansCount(Score2);
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level4){
            System.out.println("Well done! Game complete.");
            JDialog diaScore = new JDialog(frame ,true);
            HighScore highScore = new HighScore(this);
            diaScore.getContentPane().add(highScore.getPnlScores());
            diaScore.pack();
            diaScore.setVisible(true);
        }
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
        System.out.println("Welcome to the Club Penguin Bean Counters game!");
        System.out.println("Let me introduce you with some instructions:");
        System.out.println("Click the Left and Right arrows of your keyboard to move your penguin left/right");
        System.out.println("Click the Up arrow of your keyboard to make your penguin jump");
        System.out.println("Collect as many bean counters as you can");
        System.out.println("When you collect them all the bean counters on your screen, click Space key for a surprise");
        System.out.println("Enjoy ;P");
    }
}
