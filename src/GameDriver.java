import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class GameDriver {
    public static void main(String[] args) {

        // The below code will display the home screen
        JFrame homeFrame = new JFrame("Final Project");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homeFrame.setLocation(0, 0);

        homeFrame.setPreferredSize(new Dimension(1000, 800));

        JPanel homePanel = new JPanel();

        homePanel.setBackground(new Color(212, 100, 100));
        // Sets the color for the panel that will act as the background for the home
        // screen

        // Below will determine what the title is
        JLabel titleLabel = new JLabel("Sewer Suffering");
        // Below will create a font object used for the title
        Font titleFont = new Font("Impact", Font.BOLD, 70);

        titleLabel.setFont(titleFont);

        // Below will create a list of player characters that are supposed to be
        // displayed after hitting the start game button
        ArrayList<Player> players = new ArrayList<Player>();
        int playerIndex = 0;

        while (playerIndex < 3) {
            playerIndex = playerIndex + 1;
            Player newPlayer = new Player();
            players.add(newPlayer);
        }

        // Below will code in the Player Panel
        PlayerPanel playerPanel = new PlayerPanel(players);

        System.out.println("The list of pcs are: " + players);

        // Below is creating a new JFrame that will be displayed after hitting the
        // "start game" button
        JFrame characterFrame = new JFrame("Character Choices");

        characterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        characterFrame.setVisible(false);

        // Below code will set the window's state to maximized
        characterFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Below will attempt to code a new object for the player panel
        PlayerPanel choicePanel = new PlayerPanel(players);

        // Below Will be the buttons for the title screen
        JButton quitGame = new JButton("Quit Game");

        quitGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                homeFrame.dispose();
            }

        });

        JButton startGame = new JButton("Start Game");

        startGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Below code will close the initial home window
                homeFrame.dispose();
                // Below code will set the characterFrame to be visible
                characterFrame.setVisible(true);

            }

        });

        // add the start and quit buttons to the home panel
        homePanel.add(quitGame);
        homePanel.add(startGame);

        // Add the home panel to the title label
        homePanel.add(titleLabel);

        // Add the choice panel to the character frame
        characterFrame.getContentPane().add(choicePanel);

        // add the player panel to the character frame
        characterFrame.add(playerPanel);

        // add the home panel to the home frame
        homeFrame.getContentPane().add(homePanel);

        // Home frame visible stuff
        homeFrame.pack();
        homeFrame.setVisible(true);

    }
}
