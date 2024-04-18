package edu.guilford;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import edu.guilford.CardFrame.NextCardListener;

public class PlayerPanel extends JPanel {

    // Declare the main character
    private Player mainCharacter;

    public void setMainCharacter(Player mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public Player getMainCharacter() {
        return mainCharacter;
    }

    public static final String TEXT_YELLOW = "\u001B[93m";

    // Delcare the list of players
    private ArrayList<Player> players;
    private ArrayList<Enemy> enemies;

    // Declare the choice panel
    private JLabel choiceLabel;

    // Declare a new Font object and characteristics
    private Font choiceFont;
    private String fontFamily = "Helvetica";
    private int fontSize = 45;

    // Radio Buttons for Character Choice
    private JRadioButton playerOneRadio;
    private JRadioButton playerTwoRadio;
    private JRadioButton playerThreeRadio;

    // Player once player has made decision
    public Player playerDecision;

    // Keeps track of the selected button
    private JRadioButton selectedButton;

    // Groups the character choice radio buttons
    private ButtonGroup characterGroup;

    // create the label for player one picture
    private JLabel playerOneLabel;

    // delcare the label for the player two picture
    private JLabel playerTwoLabel;

    // declare the label for the player three picture
    private JLabel playerThreeLabel;

    // create the icon for the player one label;
    private ImageIcon playerOneIcon;

    // declare the icon for the player two label
    private ImageIcon playerTwoIcon;

    // declare the icon for the player three label
    private ImageIcon playerThreeIcon;

    // declare the color for the text on the player choice screen, sickly yellow
    private Color sicklyYellow;

    // declare the button that will move the player into the game sewer
    private JButton sewerStartButton;

    // declare the labels that will display the character stats
    private JLabel player1Class;
    private JLabel player2Class;
    private JLabel player3Class;

    // Below will instantiate a new next card listener to try and change cards
    private CardFrame cardDemo;

    public void setCardDemo(CardFrame cardDemo) {
        this.cardDemo = cardDemo;
    }

    // below will instantiate a sewer panel to get this panel to control the sewer
    // panel
    public SewerPanel controlSewer;

    public void setControlSewer(SewerPanel controlSewer) {
        this.controlSewer = controlSewer;
    }

    public ScorePanel controlScore;

    public void setControlScore(ScorePanel controlScore) {
        this.controlScore = controlScore;
    }

    public TutorialPanel controlTutorial;

    public void setControlTutorial(TutorialPanel controlTutorial) {
        this.controlTutorial = controlTutorial;
    }

    public RepeatPanel controlRepeat;

    public void setControlRepeat(RepeatPanel controlRepeat) {
        this.controlRepeat = controlRepeat;
    }

    // Let's create the method that allows us to add players to the panel
    public PlayerPanel(ArrayList<Player> players, ArrayList<Enemy> enemies) {
        // Set the size of the panel
        setPreferredSize(new Dimension(1000, 800));
        // Set the color of the panel
        setBackground(new Color(150, 50, 150));

        this.players = players;
        this.enemies = enemies;
        initPanel();
    }

    // Method to initialize panel

    public void initPanel() {

        // below will attempt to set up a gridlayout
        // below is code copied from stack overflow at:
        // https://stackoverflow.com/questions/2510159/can-i-add-a-component-to-a-specific-grid-cell-when-a-gridlayout-is-used
        // and then modified so that it fit the parameters I'm looking for
        int i = 5;
        int j = 3;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                // below will be one of my modifications that is able to change the background
                // color, now it is set to a sewer green
                panelHolder[m][n].setBackground(new Color(81, 90, 11));
                add(panelHolder[m][n]);
            }
        }
        // Initialize the main character
        mainCharacter = players.get(0);

        // Initialize the font
        choiceFont = new Font(fontFamily, 0, fontSize);

        // instantiate the color for the font
        sicklyYellow = new Color(91, 191, 79);

        // Initialize the label for the top of the screen
        choiceLabel = new JLabel();

        // set the text for the title label
        choiceLabel.setText("Choose Your Character");
        choiceLabel.setForeground(sicklyYellow);

        // set the font for the title label
        choiceLabel.setFont(choiceFont);

        // instantiate the radio buttons so they can choose a character

        playerOneRadio = new JRadioButton("Player One");

        playerTwoRadio = new JRadioButton("Player Two");

        playerThreeRadio = new JRadioButton("Player Three");

        // Below will instantiate the button group
        characterGroup = new ButtonGroup();

        // instantiate the player one label
        playerOneLabel = new JLabel(players.get(0).getName());

        // instanatiate the player two label
        playerTwoLabel = new JLabel(players.get(1).getName());

        // instantiate the player three label
        playerThreeLabel = new JLabel(players.get(2).getName());

        // intantiate the player one icon
        playerOneIcon = new ImageIcon(players.get(0).getPlayerPic());

        // instantiate the player two icon
        playerTwoIcon = new ImageIcon(players.get(1).getPlayerPic());

        // instantiate the player three icon
        playerThreeIcon = new ImageIcon(players.get(2).getPlayerPic());

        // instantiate the sewer button
        sewerStartButton = new JButton("Enter the Sewer");
        sewerStartButton.setForeground(sicklyYellow);

        // instantiate the JLabels that will display stats
        player1Class = new JLabel("Class: " + players.get(0).getPlayerClass());
        player2Class = new JLabel("Class: " + players.get(1).getPlayerClass());
        player3Class = new JLabel("Class: " + players.get(2).getPlayerClass());

        // set the player one label to have the player one icon
        playerOneLabel.setIcon(playerOneIcon);

        // set the player two label to have the player two icon
        playerTwoLabel.setIcon(playerTwoIcon);

        // set the player three label to have the player three icon
        playerThreeLabel.setIcon(playerThreeIcon);

        // below will set the font color of the player labels to sickly yellow
        playerOneLabel.setForeground(sicklyYellow);
        playerTwoLabel.setForeground(sicklyYellow);
        playerThreeLabel.setForeground(sicklyYellow);

        player1Class.setForeground(sicklyYellow);
        player2Class.setForeground(sicklyYellow);
        player3Class.setForeground(sicklyYellow);

        // below will attempt to set the bounds of the radio buttons
        playerOneRadio.setBounds(150, 200, 100, 75);

        // below will attempt to set the locations of the text for the character names
        playerOneLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerOneLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        playerTwoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerTwoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        playerThreeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        playerThreeLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

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

        // add the next card listener to the sewer start button
        sewerStartButton.addActionListener(new SewerStartListener());

        // add the choice label to the panel
        add(choiceLabel);

        // add the player one label to the panel
        add(playerOneLabel);

        // add the player two label to the panel
        add(playerTwoLabel);

        // add the player three label to the panel
        add(playerThreeLabel);

        // add the radiobuttons to the panel
        add(playerOneRadio);
        add(playerTwoRadio);
        add(playerThreeRadio);

        // add the sewer button to the panel
        add(sewerStartButton);

        // add components to the grid layout
        panelHolder[0][1].add(choiceLabel);

        // radio buttons grid add
        panelHolder[2][0].add(playerOneRadio);
        panelHolder[2][1].add(playerTwoRadio);
        panelHolder[2][2].add(playerThreeRadio);

        // player lables gridd add
        panelHolder[1][0].add(playerOneLabel);
        panelHolder[1][1].add(playerTwoLabel);
        panelHolder[1][2].add(playerThreeLabel);

        // sewere button label gridd add
        panelHolder[4][2].add(sewerStartButton);

        // add the JLabels for the stats
        panelHolder[3][0].add(player1Class);
        panelHolder[3][1].add(player2Class);
        panelHolder[3][2].add(player3Class);
    }

    // getter for main character

    // Below will be the methods

    public Player choosePlayerCharacter() {
        if (selectedButton == playerOneRadio) {
            mainCharacter = players.get(0);
        } else if (selectedButton == playerTwoRadio) {
            mainCharacter = players.get(1);
        } else if (selectedButton == playerThreeRadio) {
            mainCharacter = players.get(2);
        }

        return mainCharacter;
    }

    public void updateMainCharacter() {
        controlSewer.setSewerMainCharacter(mainCharacter);
        controlTutorial.setTutorialMainCharacter(mainCharacter);
        controlRepeat.setRepeatMainCharacter(mainCharacter);
        controlScore.setScoreMainCharacter(mainCharacter);
    }

    // Below will be the listeners

    private class ChoiceRadioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectedButton = (JRadioButton) e.getSource();
            choosePlayerCharacter();

        }

    }

    private class SewerStartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // clear the list

            updateMainCharacter();

            cardDemo.nextCard();
        }

    }

}
