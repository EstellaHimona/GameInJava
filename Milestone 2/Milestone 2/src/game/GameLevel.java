package game;

import city.cs.engine.World;

public abstract class GameLevel extends World {
    private YellowPenguin yellowPenguin;
    private PenguinCoffee penguinCoffee;
    private Game game;

    public GameLevel (Game game) {
        this.game = game;
        //all the levels have a penguin and some bean counters
        //the yellow penguin needs to pickup all the bean counters
        //to complete the game
        //but if it collides with a hammer it loses

        yellowPenguin = new YellowPenguin(this);
        penguinCoffee = new PenguinCoffee(this);
    }

    //create a getter for the yellow penguin
    public YellowPenguin getYellowPenguin () {
        return yellowPenguin;
    }

    //create a getter for the penguin coffee
    public PenguinCoffee getPenguinCoffee() {
        return penguinCoffee;
    }

    //create a method to check whether the level is completed
    public abstract boolean isComplete();
}
