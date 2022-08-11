package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BadPenguin extends Walker implements StepListener{

    BodyImage leftImage = new BodyImage ("data/bad penguin left.png", 8f);
    BodyImage rightImage = new BodyImage ("data/bad penguin right.png", 8f);

    //create the shape for the bad penguin
    private static final Shape badPenguinShape = new PolygonShape(
            -2.87f,3.97f, -2.87f,0.34f, -1.3f,-3.86f, 0.83f,-3.54f, 3.07f,-0.64f, 2.55f,2.61f);

    //implement the image for the bad penguin
    BodyImage badPenguinImage = rightImage;

    private enum State {
        GO_LEFT, GO_RIGHT, STAND_STILL
    }

    public static final float RANGE = 5;
    private State state;
    private GameLevel world;

    //implement a constructor for the bad penguin class
    public BadPenguin(GameLevel world) {
        super(world, badPenguinShape);
        this.world = world;
        addImage(rightImage);
        this.setPosition(new Vec2(10, 5));
        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }


    public boolean inRangeLeft() {
        Body a = world.getYellowPenguin();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }

    public boolean inRangeRight() {
        Body a = world.getYellowPenguin();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
    }

    //update state
    @Override
    public void preStep(StepEvent stepEvent) {
        if (inRangeRight()) {
            if (state != State.GO_RIGHT) {
                state = State.GO_RIGHT;
            }
        } else if (inRangeLeft()) {
            if (state != State.GO_LEFT) {
                state = State.GO_LEFT;
            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                setLinearVelocity(new Vec2(0, 0));
            }
        }
        refreshRoll();
    }

    // use this to prevent the balls from slowing
    // down and stopping due to friction when they
    // should be rolling
    private void refreshRoll() {
        switch (state) {
            case GO_LEFT:
                setLinearVelocity(new Vec2(-2, 1));
                removeAllImages();
                badPenguinImage = leftImage;
                addImage(leftImage);
                break;
            case GO_RIGHT:
                setLinearVelocity(new Vec2(2, 1));
                removeAllImages();
                badPenguinImage = rightImage;
                addImage(rightImage);
                break;
            default: // nothing to do
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }

//    //setter for the bad penguin direction
//    //changes when several keys are pressed
//    public void setBadPenguinDirection (BodyImage direction) {
//        removeAllImages();
//        BadPenguin.badPenguinImage = direction;
//        addImage(badPenguinImage);
//    }

}


