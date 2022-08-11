package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private Image background ;
    private Game game;

    //create a constructor for the game view class
    public GameView(Game game, int width, int height) {
        super(game.getLevel(),width, height);
        background = new ImageIcon("data/cp background.png").getImage();
        this.game = game;
    }

    //draw the background image
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    //implement the score and lives on the foreground of the game window
    @Override
    protected void paintForeground(Graphics2D g) {

        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("Score: " + game.getLevel().getYellowPenguin().getBeansCount(), 200, 20);
        g.drawString("Lives:"+ game.getLevel().getYellowPenguin().getLives(),100, 20 );
    }
}
