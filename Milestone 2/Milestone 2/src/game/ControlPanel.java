package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel{
    private JPanel mainPanel;
    private JButton quitButton;
    private JButton skipToNextLevelButton;
    private Game game;


    //implement a constructor for the control panel
    public ControlPanel (Game game) {
        this.game = game;

        //implement an action listener for when the quit button is pressed;
        //the game stops and the game window closes
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //implement an action listener for when the skip button is pressed;
        //the game skips to the next level
        skipToNextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToNextLevel();
            }
        });
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
