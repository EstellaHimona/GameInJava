package game;

import city.cs.engine.World;

public abstract class GameLevel extends World {
    private YellowPenguin yellowPenguin;
    private PenguinCoffee penguinCoffee;
    private BadPenguin badPenguin;
    private Flowers flowers;
    private BlackPot blackPot;
    private Game game;

    public GameLevel (Game game) {
        this.game = game;
        //all the levels have a penguin and some bean counters
        //the yellow penguin needs to pickup all the bean counters
        //to complete the game
        //but if it collides with a hammer it loses

        yellowPenguin = new YellowPenguin(this);
        penguinCoffee = new PenguinCoffee(this);
        //badPenguin = new BadPenguin(this);
    }

    //create a getter for the yellow penguin
    public YellowPenguin getYellowPenguin () {
        return yellowPenguin;
    }

    //create a getter for the penguin coffee
    public PenguinCoffee getPenguinCoffee() {
        return penguinCoffee;
    }

    //create a getter for the bad penguin
    public BadPenguin getBadPenguin(){
        return badPenguin;
    }

    public Flowers getFlowers () {
        return flowers;
    }

    public BlackPot getBlackPot () {
        return blackPot;
    }

    //create a method to check whether the level is completed
    public abstract boolean isComplete();
}
