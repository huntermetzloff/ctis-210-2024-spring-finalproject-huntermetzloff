package edu.guilford;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class SewerPanel extends JPanel {

    private ImageIcon sewerIcon;
    private JLabel sewerLabel;

    // Create the layered pane
    private JLayeredPane layeredPane;

    // declare the image icon for the player
    private ImageIcon playerIcon;

    // declare the image for the tutorial wizard for the player
    private ImageIcon tutorialIcon;

    // Delcare the list of players
    private ArrayList<Player> players;

    // Declare some integers to help with creation of frame
    private int panelWidth = 1000;
    private int panelHeight = 800;

    // Declare the panel that the player image will go in
    private JLabel playerLabel;

    // Declare the panel that the tutorial wizard png will go in
    private JLabel tutorialWizardLabel;

    // Declare the panel that will contain the dialogue
    private JTextArea dialogueArea;

    // declare the font used for dialogue
    private Font dialogueFont;

    // declare the button used to go the next screen
    private JButton nextButton;

    // Below will instantiate a new next card listener to try and change cards
    private CardFrame cardDemo;

    public void setCardDemo(CardFrame cardDemo) {
        this.cardDemo = cardDemo;
    }

    // Let's create the method that allows us to add players to the panel
    public SewerPanel(ArrayList<Player> players) {

        this.players = players;
        initSewerPanel();
    }

    public void initSewerPanel() {

        // set the layout manager to null type so layered pane can be used freely
        setLayout(null);

        // Set the size of the panel
        setPreferredSize(new Dimension(panelWidth, panelHeight));

        // instantiate the dialogue font
        dialogueFont = new Font("Helvetica", 0, 12);

        // instantiate the icon
        sewerIcon = new ImageIcon("src/edu/guilford/resources/sewer_1.png");

        // instantiate the player icon
        playerIcon = new ImageIcon("src/edu/guilford/resources/" + players.get(0).getPlayerPic());
        // System.out.println("The sewer panel player is: " +
        // players.get(0).toString());

        // instantaite the tutorial wizard icon
        tutorialIcon = new ImageIcon("src/edu/guilford/resources/wizard_red.png");

        // instantiate the JLabel
        sewerLabel = new JLabel();

        // instantiate the player label
        playerLabel = new JLabel();

        // instantiate the tutorial wizard label
        tutorialWizardLabel = new JLabel();

        // instantiate the dialogue label
        dialogueArea = new JTextArea("Hello weary " + players.get(0).getPlayerClass() + " and welcome to the sewer. I am the tutorial wizard and will show you how to play this game. Follow me into the dungon by pressing the button that says 'next room'");
        //set wrap text to true so that the text wraps within the area
        dialogueArea.setLineWrap(true);

        // instantiate the layered pane
        layeredPane = new JLayeredPane();

        // instantiate the next button
        nextButton = new JButton("Next Room");
        nextButton.setFocusable(false);

        // set the bounds of the next button
        nextButton.setBounds(1400, 20, 100, 50);

        // set the bounds of the layered pane
        layeredPane.setBounds(0, 0, 1550, 795);

        // set the bounds of the background
        sewerLabel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());

        // set the bounds of the player label
        playerLabel.setBounds(200, 500, 100, 100);

        // set the bounds of the tutorial wizard label
        tutorialWizardLabel.setBounds(400, 500, 100, 100);

        // set the bounds of the dialogue label
        dialogueArea.setBounds(300, 600, 300, 100);

        // set the background for the label
        sewerLabel.setIcon(sewerIcon);

        // set the font of the dialogue area
        dialogueArea.setFont(dialogueFont);

        // set the background of the dialogue label
        dialogueArea.setBackground(Color.BLACK);
        dialogueArea.setOpaque(true);
        // set the foreground of the dialogue label
        dialogueArea.setForeground(Color.WHITE);

        // set the border of the dialogue label
        Border dialogueBorder = BorderFactory.createLineBorder(Color.WHITE);
        dialogueArea.setBorder(dialogueBorder);

        // set the player image for the player label
        playerLabel.setIcon(playerIcon);

        // set the tutorial wizard image for its label
        tutorialWizardLabel.setIcon(tutorialIcon);

        // add the action listener to the next button
        nextButton.addActionListener(new NextRoomListener());

        // add the diaglogue label to the layered pane
        layeredPane.add(dialogueArea);

        // add the player label to the layered pane
        layeredPane.add(playerLabel);

        // add the tutorial wizard label to the layered pane
        layeredPane.add(tutorialWizardLabel);

        // add the next button to the layered pane
        layeredPane.add(nextButton);

        // add sewer label to the layered pane
        layeredPane.add(sewerLabel);

        // add the layered pane to the panel
        add(layeredPane);

    }

    private class NextRoomListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cardDemo.nextCard();
        }
        
    }

}
