package edu.guilford;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class GameDriver {
    public static void main(String[] args) {
        // Below will create a list of player characters that are supposed to be
        // displayed after hitting the start game button
        ArrayList<Player> players = new ArrayList<Player>();
        int playerIndex = 0;

        while (playerIndex < 3) {
            playerIndex = playerIndex + 1;
            Player newPlayer = new Player();
            players.add(newPlayer);
        }
        
        // Below is the frame that will have the card layout
        CardFrame masterFrame;
        masterFrame = new CardFrame(players);
        masterFrame.setVisible(true);
        

        // Below will code in the Player Panel
        PlayerPanel playerPanel = new PlayerPanel(players);
        playerPanel.setVisible(true);
        playerPanel.setCardDemo(masterFrame);

        // Below will code in the Sewer Panel
        SewerPanel sewerPanel = new SewerPanel(players);
        

        // System.out.println("The list of pcs are: " + players);

    }
}
