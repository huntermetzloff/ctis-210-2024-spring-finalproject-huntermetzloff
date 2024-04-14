package edu.guilford;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardFrame extends JFrame {

    // Declare the list of players
    private ArrayList<Player> players;

    private CardLayout cardLayout;
    private Container container;
    // JPanels
    private JPanel homePanel;
    private PlayerPanel characterPanel;
    private SewerPanel sewerPanel;
    private tutorialPanel tutorialPanel;

    // Labels
    private JLabel titleLabel;

    // Quit game button
    private JButton quitGame;

    // Start game Button
    private JButton startGame;

    // Let's generate a getter for the character panel

    public PlayerPanel getCharacterPanel() {
        return characterPanel;
    }

    // let's generate a getter for the sewer panel

    public SewerPanel getSewerPanel() {
        return sewerPanel;
    }

    // Let's create the method that allows us to add players to the panel
    public CardFrame(ArrayList<Player> players) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set it to automatically maximize
        setExtendedState(MAXIMIZED_BOTH);
        this.players = players;
        CreateCardLayout();
    }

    // create a method to
    public void CreateCardLayout() {
        container = getContentPane();
        cardLayout = new CardLayout();
        container.setLayout(cardLayout);

        // Instantiate the components
        homePanel = new JPanel();
        characterPanel = new PlayerPanel(players);
        sewerPanel = new SewerPanel(players);

        // Instantiate the Start and Quit game buttons
        startGame = new JButton("Start Game");
        quitGame = new JButton("Quit Game");

        // Instantiate the Quit Game Action Listener
        ActionListener quitGameListener = new QuitGameListener();

        // Instantiate the Next Card Listener
        ActionListener nextCardListener = new NextCardListener();

        // Instantiate the Start Game Action Listener

        // Add the Quit game action listener to the button
        quitGame.addActionListener(quitGameListener);

        // Add the next card listener to the start button
        startGame.addActionListener(nextCardListener);

        // set the home panel to have a different background
        homePanel.setBackground(new Color(212, 100, 0));

        // set the home panel to have a JLabel Title
        titleLabel = new JLabel("Sewer Suffering");
        Font titleFont = new Font("Impact", Font.BOLD, 70);
        titleLabel.setFont(titleFont);

        // add the label to the panel
        homePanel.add(titleLabel);

        // add the start game button to the panel
        homePanel.add(startGame);

        // add the Quit game button to the panel
        homePanel.add(quitGame);

        // add the components to the container
        container.add("a", homePanel);
        container.add("b", characterPanel);
        container.add("c", sewerPanel);
        container.add("d", tutorialPanel);

        
    }

    public class NextCardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            nextCard();
        }

    }

    public void nextCard() {
        cardLayout.next(container);
        
        }
    

    private class QuitGameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }

}
