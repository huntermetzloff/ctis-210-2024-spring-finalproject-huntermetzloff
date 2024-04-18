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

        ArrayList<Enemy> enemies = new ArrayList<Enemy>();

        playerIndex = 0;
            while (playerIndex < 3){
                playerIndex = playerIndex + 1;
                Enemy newEnemy = new Enemy();
                enemies.add(newEnemy);
            }


        // Below is the frame that will have the card layout
        CardFrame masterFrame;
        masterFrame = new CardFrame(players, enemies);
        masterFrame.setVisible(true);

        // Below will code in the Player Panel
        PlayerPanel characterPanel = masterFrame.getCharacterPanel();
        characterPanel.setVisible(true);
        characterPanel.setCardDemo(masterFrame);

        // Below will code in the Sewer Panel
        SewerPanel sewerPanel = masterFrame.getSewerPanel();
        sewerPanel.setVisible(true);
        sewerPanel.setCardDemo(masterFrame);
        
        // Below will code sewer panel for control through player panel
        characterPanel.setControlSewer(sewerPanel);
        masterFrame.setSewerPanel(sewerPanel);

        // below will code in the tutorial panel
        TutorialPanel tutorialPanel = masterFrame.getTutorialPanel();
        tutorialPanel.setVisible(true);
        tutorialPanel.setCardDemo(masterFrame);

        // below will set control of tutorial to player panel
        characterPanel.setControlTutorial(tutorialPanel);

        RepeatPanel repeatPanel = masterFrame.getRepeatPanel();
        repeatPanel.setVisible(true);
        repeatPanel.setCardDemo(masterFrame);

        ScorePanel scorePanel = masterFrame.getScorePanel();
        
        characterPanel.setControlRepeat(repeatPanel);
        characterPanel.setControlScore(scorePanel);
        repeatPanel.setControlTutorial(tutorialPanel);
        repeatPanel.setControlRepeatScore(scorePanel);

        scorePanel.setCardDemo(masterFrame);
        

        // System.out.println("The list of pcs are: " + players);

    }
}
