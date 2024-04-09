package edu.guilford;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SewerPanel extends JPanel {

    // Delcare the list of players
    private ArrayList<Player> players;

    // Declare some integers to help with creation of frame
    private int frameWidth = 1000;
    private int frameHeight = 800;

    // Declare the image icon for the background
    ImageIcon initialSewer;

    // Let's create the method that allows us to add players to the panel
    public SewerPanel(ArrayList<Player> players) {
        
        this.players = players;
        initSewerPanel();
    }

    public void initSewerPanel() {
        // Set the size of the panel
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        // Set the color of the panel
        setBackground(new Color(100, 100, 100));

    }

}
