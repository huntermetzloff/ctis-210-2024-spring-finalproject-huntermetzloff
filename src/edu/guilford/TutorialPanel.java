package edu.guilford;

import java.util.ArrayList;

import javax.swing.JPanel;

public class TutorialPanel extends JPanel{

    // Delcare the list of players
    private ArrayList<Player> players;
    
    // Below will instantiate a new next card listener to try and change cards
    private CardFrame cardDemo;

    public void setCardDemo(CardFrame cardDemo) {
        this.cardDemo = cardDemo;
    }

    // Let's create the method that allows us to add players to the panel
    public TutorialPanel(ArrayList<Player> players) {

        this.players = players;
        initTutorialPanel();
    }

    public void initTutorialPanel(){

    }

}
