package game;

import javax.swing.JFrame;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameWorld world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    /** Initialise a new Game. */
    public Game() {

        // make the world
        GameWorld world = new GameWorld();

        // make a view
        view = new MyView(world, 550, 322);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(world, view));

        YellowPenguinController controller = new YellowPenguinController(world.getYellowPenguin());
        view.addKeyListener(controller);

        PenguinCoffeeController pccontroller = new PenguinCoffeeController(world.getPenguinCoffee());
        view.addKeyListener(pccontroller);


        view.addMouseListener(new GiveFocus(view));


        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Basic world");
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

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
        System.out.println("Welcome to the Game!");
        System.out.println("Let me introduce you with some instructions:");
        System.out.println("Click the Left and Right arrows of your keyboard to move left/right your penguin");
        System.out.println("Click the Up arrow of your keyboard to make your penguin jump");
        System.out.println("Collect as many bean counters as you can");
        System.out.println("When you collect them all the bean counters on your screen, click Space key for a surprise");
        System.out.println("Enjoy ;P");
    }
}
