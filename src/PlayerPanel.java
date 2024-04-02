import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PlayerPanel extends JPanel {

    // Delcare the list of players
    private ArrayList<Player> players;

    // Declare the choice panel
    private JLabel choiceLabel;

    // Declare a new Font object and characteristics
    private Font choiceFont;
    private String fontFamily = "Helvetica";
    private int fontSize = 40;

    // Radio Buttons for Character Choice
    private JRadioButton playerOneRadio;
    private JRadioButton playerTwoRadio;
    private JRadioButton playerThreeRadio;

    // Player onced player has made decision
    private Player playerDecision;

    // Keeps track of the selected button
    private JRadioButton selectedButton;

    // Groups the character choice radio buttons
    private ButtonGroup characterGroup;

    // create the label for player one picture
    private JLabel playerOneLabel;

    //create the icon for the player one label;
    private ImageIcon playerOneIcon;

    // Let's create the method that allows us to add players to the panel
    public PlayerPanel(ArrayList<Player> players) {
        // Set the size of the panel
        setPreferredSize(new Dimension(1000, 800));
        // Set the color of the panel
        setBackground(new Color(150, 50, 150));


        this.players = players;
        initPanel();
    }

    // Method to initialize panel

    public void initPanel() {

        // Initialize the font
        choiceFont = new Font(fontFamily, 0, fontSize);

        // Initialize the label for the top of the screen
        choiceLabel = new JLabel();

        // set the text for the title label
        choiceLabel.setText("Choose Your Character");

        // set the font for the title label
        choiceLabel.setFont(choiceFont);

        // instantiate the radio buttons so they can choose a character

        playerOneRadio = new JRadioButton("Player One");

        playerTwoRadio = new JRadioButton("Player Two");

        playerThreeRadio = new JRadioButton("Player Three");

        // Below will instantiate the button group
        characterGroup = new ButtonGroup();

        // instantiate the player one label
        playerOneLabel = new JLabel();

        // intantiate the player one icon
        playerOneIcon = new ImageIcon(getClass().getResource(players.get(0).getPlayerPic()));

        // set the player one label to have the player one icon
        playerOneLabel.setIcon(playerOneIcon);


        // Add the player radio buttons to the button group
        characterGroup.add(playerOneRadio);
        characterGroup.add(playerTwoRadio);
        characterGroup.add(playerThreeRadio);

        // Below will automatically make playerOneRadio selected
        playerOneRadio.setSelected(true);

        // Below will instantiate the Radio button listener
        ChoiceRadioListener playerChoiceListener = new ChoiceRadioListener();

        // add the player choice listener to the radio buttons
        playerOneRadio.addActionListener(playerChoiceListener);
        playerTwoRadio.addActionListener(playerChoiceListener);
        playerThreeRadio.addActionListener(playerChoiceListener);

        // add the choice label to the panel
        add(choiceLabel);

        // add the player one label to the panel
        add(playerOneLabel);

        // add the radiobuttons to the panel
        add(playerOneRadio);
        add(playerTwoRadio);
        add(playerThreeRadio);
    }
    // Below will be the methods

    private void choosePlayerCharacter() {
        if (selectedButton == playerOneRadio) {
            playerDecision = players.get(0);
        } else if (selectedButton == playerTwoRadio) {
            playerDecision = players.get(1);
        } else if (selectedButton == playerThreeRadio) {
            playerDecision = players.get(2);
        }
    }

    // Below will be the listeners

    private class ChoiceRadioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectedButton = (JRadioButton) e.getSource();
            choosePlayerCharacter();
        }

    }

}
