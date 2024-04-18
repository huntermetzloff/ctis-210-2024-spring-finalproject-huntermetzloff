package edu.guilford;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel{

    private JLabel scoreLabel;
    private Player mainCharacter;
    private JButton disposeButton;

    private Font scoreFont;

    private CardFrame cardDemo;

    public void setCardDemo(CardFrame cardDemo) {
        this.cardDemo = cardDemo;

    }

    


    // Delcare the list of players
    private ArrayList<Player> players;
    private ArrayList<Enemy> enemies;
    
    public ScorePanel(ArrayList<Player> players, ArrayList<Enemy> enemies) {

        this.players = players;
        this.enemies = enemies;
        initScorePanel();
    }

    public void setScoreMainCharacter(Player mainCharacter) {
        this.mainCharacter = mainCharacter;
        remove(scoreLabel);
        scoreLabel = new JLabel("Wow, you died. Your score is: " + mainCharacter.getPlayerGold());
        scoreLabel.setFont(scoreFont);
        add(scoreLabel, BorderLayout.NORTH);
    }

   public void initScorePanel(){

setLayout(new BorderLayout());

scoreFont = new Font("Comic Sans", 1, 45);

    setBackground(Color.PINK);
    

    mainCharacter = new Player();
// code for the label
    scoreLabel = new JLabel("Wow, you died. Your score is: " + mainCharacter.getPlayerGold());
    scoreLabel.setBackground(Color.CYAN);
    scoreLabel.setForeground(Color.PINK);
    add(scoreLabel, BorderLayout.NORTH);

    // code for dispose button

    disposeButton = new JButton("QUIT THIS GAME");
    disposeButton.addActionListener(new DisposeListener());
    disposeButton.setBounds(500, 600, 600, 200);
    

    add(disposeButton, BorderLayout.CENTER);



   }

    private class DisposeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            cardDemo.dispose();
        }
        
    }

}
