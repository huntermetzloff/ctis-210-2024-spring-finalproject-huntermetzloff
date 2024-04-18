
package edu.guilford;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class RepeatPanel extends JPanel {

    // Delcare the list of players
    private ArrayList<Player> players;
    private ArrayList<Enemy> enemies;

    // declare an enemy
    private Enemy tutorialEnemy;
    private Enemy tutorialEnemy2;

    // declare enemy damage
    private double enemyDamage;

    // declare the initial label
    private JLabel tutorialLabel;

    // declare the player label
    private JLabel playerLabel;

    // declare the score label
    private JLabel scoreLabel;

    // declare the enemy label
    private JLabel enemyLabel;

    // declare 2nd enemy label
    private JLabel enemyLabel2;

    private JTextArea victoryJTextArea;

    // declare the layered pane
    private JLayeredPane layeredPane;

    // declare the icons

    private ImageIcon background;

    private ImageIcon player;

    private ImageIcon enemy;

    private ImageIcon enemyImageIcon2;

    private Player mainCharacter;

    private JButton nextRoomButton;

    

    // delcare the health bars (rectangles)

    private Graphics2D g2;

    // declare the physical damage button
    private JButton attackButton;
    private JButton spellButton;

    // declare the next button
    private JButton nextButton;

    // declare physical damage
    private double physicalDamage = 0;
    // declare magical damage
    private double magicalDamage = 0;

    // declare the label that will contain all da buttons
    private JLabel actionLabel;

    private Font victoryFont;

    // declare the font used for dialogue
    private Font dialogueFont;

    // declare the focused enemy;
    private Enemy focusedEnemy;

    // declare the focused JLabel
    private JLabel focusedJLabel;

    // Below will instantiate a new next card listener to try and change cards
    private CardFrame cardDemo;

    public TutorialPanel controlTutorial;

    public ScorePanel controlRepeatScore;




    
    public void setControlRepeatScore(ScorePanel controlRepeatScore) {
        this.controlRepeatScore = controlRepeatScore;
    }

    public void setControlTutorial(TutorialPanel controlTutorial) {
        this.controlTutorial = controlTutorial;
    }

    public void setCardDemo(CardFrame cardDemo) {
        this.cardDemo = cardDemo;

    }

    public void setRepeatMainCharacter(Player mainCharacter) {
        this.mainCharacter = mainCharacter;
        player = new ImageIcon(mainCharacter.getPlayerPic());
        playerLabel.setIcon(player);
    }

    // Let's create the method that allows us to add players to the panel
    public RepeatPanel(ArrayList<Player> players, ArrayList<Enemy> enemies) {

        this.players = players;
        this.enemies = enemies;
        initRepeatPanel();
    }

    public void initRepeatPanel() {
        setLayout(null);

        // instantiate the font
        victoryFont = new Font("Comic Sans", 0, 50);

        // use placeholders for enemy and player for now

        mainCharacter = new Player();

        tutorialEnemy = new Enemy();

        tutorialEnemy2 = new Enemy();

        // instantiate the labels
        tutorialLabel = new JLabel();

        playerLabel = new JLabel();

        enemyLabel = new JLabel();

        enemyLabel2 = new JLabel();

        actionLabel = new JLabel("CONTROLS");

        scoreLabel = new JLabel("Wow you died, and your score was: " + mainCharacter.getPlayerGold());

        scoreLabel.setVisible(false);

        victoryJTextArea = new JTextArea("VICTORY!!!");

        // instantiate the dialogue font
        dialogueFont = new Font("Helvetica", 0, 12);

        // instantiate the new jlayeredpane
        layeredPane = new JLayeredPane();

        // instantiate the icons
        background = new ImageIcon("src/edu/guilford/resources/tutorialSewer.png");
        player = new ImageIcon(players.get(0).getPlayerPic());
        enemy = new ImageIcon(tutorialEnemy.getEnemyPic());
        enemyImageIcon2 = new ImageIcon(tutorialEnemy2.getEnemyPic());

        // instantiate the buttons
        attackButton = new JButton("Attack");
        spellButton = new JButton("Use Spell");
        nextRoomButton = new JButton("next room");

        // define where the layered pane is
        layeredPane.setBounds(0, 0, 1550, 795);

        // define where labels go
        tutorialLabel.setBounds(0, 0, layeredPane.getWidth(), layeredPane.getHeight());
        playerLabel.setBounds(200, 500, 100, 100);
        enemyLabel.setBounds(1000, 500, 100, 100);
        enemyLabel2.setBounds(1200, 500, 100, 100);
        victoryJTextArea.setBounds(600, 400, 300, 75);
        scoreLabel.setBounds(600, 400, 300, 200);
        actionLabel.setBounds(20, 600, 400, 300);

        // define where the buttons go
        attackButton.setBounds(20, 600, 100, 25);
        spellButton.setBounds(20, 625, 100, 25);
        nextRoomButton.setBounds(1400, 20, 100, 50);

        // set victory label to false
        victoryJTextArea.setVisible(false);

        // set font for the victory label
        victoryJTextArea.setFont(victoryFont);
        scoreLabel.setFont(victoryFont);

        // SET ACTION LABEL TO VISIBLE
        actionLabel.setVisible(true);

        // set the background of victory label
        victoryJTextArea.setBackground(new Color(100, 100, 100));
        victoryJTextArea.setForeground(Color.WHITE);
        scoreLabel.setBackground(new Color(100, 100, 100));
        scoreLabel.setForeground(Color.RED);


        // set the background of the action label
        actionLabel.setBackground(Color.WHITE);

        // add the action listeners to the buttons
        attackButton.addActionListener(new AttackListener());
        spellButton.addActionListener(new SpellListener());
        // add the action listener to the next button
        nextRoomButton.addActionListener(new NextRoomListener());

        // add the action listeners to the enemies
        enemyLabel.addMouseListener(new FocusListener());
        enemyLabel2.addMouseListener(new FocusListener());

        // add the icons to the labels
        tutorialLabel.setIcon(background);
        playerLabel.setIcon(player);
        enemyLabel.setIcon(enemy);
        enemyLabel2.setIcon(enemyImageIcon2);

        // set the components to be nonfocusable
        victoryJTextArea.setFocusable(false);
        attackButton.setFocusable(false);
        spellButton.setFocusable(false);
        playerLabel.setFocusable(false);
        tutorialLabel.setFocusable(false);
        layeredPane.setFocusable(false);

        // set the enemies to be focusable
        enemyLabel.setFocusable(true);
        enemyLabel2.setFocusable(true);

        // set the first enemy to be focused
        focusedEnemy = tutorialEnemy;

        // make next room button inivisble
        nextRoomButton.setVisible(false);

        // add components to layered pane
        layeredPane.add(victoryJTextArea);
        layeredPane.add(attackButton);
        layeredPane.add(spellButton);
        layeredPane.add(playerLabel);
        layeredPane.add(enemyLabel);
        layeredPane.add(enemyLabel2);
        layeredPane.add(nextRoomButton);
        layeredPane.add(tutorialLabel);

        add(layeredPane);

        checkEnemyHealth();

    }

    public void drawEnemyHealth(Graphics g) {
        g2 = (Graphics2D) g;

        // these rectangles are for the first enemy
        g2.setColor(Color.GREEN);
        g2.fillRect(enemyLabel.getX(), enemyLabel.getY() + 125, enemyLabel.getWidth(), 20);
        g2.setColor(Color.RED);
        g2.fillRect(
                (enemyLabel.getX() + enemyLabel.getWidth())
                        - (int) (tutorialEnemy.getMaxHealth() - tutorialEnemy.getHealth()),
                enemyLabel.getY() + 125, (int) (tutorialEnemy.getMaxHealth() - tutorialEnemy.getHealth()), 20);
        // these rectangles are for the second enemy
        g2.setColor(Color.GREEN);
        g2.fillRect(enemyLabel2.getX(), enemyLabel2.getY() + 125, enemyLabel2.getWidth(), 20);
        g2.setColor(Color.RED);
        g2.fillRect(
                (enemyLabel2.getX() + enemyLabel2.getWidth())
                        - (int) (tutorialEnemy2.getMaxHealth() - tutorialEnemy2.getHealth()),
                enemyLabel2.getY() + 125, (int) (tutorialEnemy2.getMaxHealth() - tutorialEnemy2.getHealth()), 20);
        // these rectangles are for the player
        g2.setColor(Color.GREEN);
        g2.fillRect(playerLabel.getX(), playerLabel.getY() + 125, playerLabel.getWidth(), 20);
        g2.setColor(Color.RED);
        g2.fillRect(
                (playerLabel.getX() + playerLabel.getWidth())
                        - (int) (mainCharacter.getMaxHealth() - mainCharacter.getHealth()),
                playerLabel.getY() + 125, (int) (mainCharacter.getMaxHealth() - mainCharacter.getHealth()), 20);


    }

    public void paint(Graphics g) {
        super.paint(g);
        drawEnemyHealth(g);
    }

    public void UpdateFocusedEnemy() {
        if (focusedJLabel == enemyLabel) {
            focusedEnemy = tutorialEnemy;
        } else if (focusedJLabel == enemyLabel2) {
            focusedEnemy = tutorialEnemy2;
        }
    }
    public void checkPlayerHealth(){
        System.out.println("the health is: " + mainCharacter.getHealth());
        if (mainCharacter.getHealth() <= 0){
            mainCharacter.setHealth(0);
attackButton.setVisible(false);
spellButton.setVisible(false); 
controlRepeatScore.setScoreMainCharacter(mainCharacter);
cardDemo.nextCard();   
    }
        else{
            repaint();
        }
    }
    public void checkEnemyHealth() {
        if (tutorialEnemy.getHealth() <= 0 && tutorialEnemy2.getHealth() <= 0) {

            tutorialEnemy.setHealth(0);
            tutorialEnemy2.setHealth(0);
            victoryJTextArea.setVisible(true);
            nextRoomButton.setVisible(true);

            mainCharacter.setPlayerGold(
                    mainCharacter.getPlayerGold() + (tutorialEnemy.getGoldValue() + tutorialEnemy2.getGoldValue()));

            repaint();

        } else if (tutorialEnemy.getHealth() <= 0) {
            tutorialEnemy.setHealth(0);
            repaint();
        } else if (tutorialEnemy2.getHealth() <= 0) {
            tutorialEnemy2.setHealth(0);
            repaint();
        } else {
            repaint();
        }
    }

    public void calcPhysicalDamage() {

        physicalDamage = mainCharacter.getStrength() + mainCharacter.getAgility() + physicalDamage;
        if (focusedEnemy.getResistance() == "physical") {
            physicalDamage = physicalDamage / 2;
        }
    }

    public void calcMagicalDamage() {

        magicalDamage = mainCharacter.getIntelligence() + mainCharacter.getWisdom();
        if (focusedEnemy.getResistance() == "magical") {
            magicalDamage = magicalDamage / 2;
        }
    }

    public void calcEnemyDamage(){
        if (focusedEnemy.getName() == "Slime" || focusedEnemy.getName() == "Large Slime"){
        enemyDamage = (int) (focusedEnemy.getStrength() + focusedEnemy.getAgility());}
        else {
            enemyDamage = (int) (focusedEnemy.getIntelligence() + focusedEnemy.getWisdom());
        }

        enemyDamage =  enemyDamage * (mainCharacter.getDamageMultiplier());
        
    }

    

    private class AttackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calcPhysicalDamage();
            calcEnemyDamage();
            focusedEnemy.setHealth(focusedEnemy.getHealth() - physicalDamage);
            checkEnemyHealth();

            if (focusedEnemy.getHealth() >= 0){
                mainCharacter.setHealth(mainCharacter.getHealth() - enemyDamage);
                checkPlayerHealth();
            }

            System.out.println("The focused enemy is: " + focusedEnemy.getName());
        }

    }

    private class SpellListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calcMagicalDamage();
            calcEnemyDamage();
            focusedEnemy.setHealth(focusedEnemy.getHealth() - magicalDamage);
            checkEnemyHealth();

            if (focusedEnemy.getHealth() >= 0){
                mainCharacter.setHealth(mainCharacter.getHealth() - enemyDamage);
                checkPlayerHealth();
            }
        }

    }

    private class FocusListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            focusedJLabel = (JLabel) e.getSource();
            UpdateFocusedEnemy();

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class NextRoomListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("The amount of money the main character has is: " + mainCharacter.getPlayerGold());
     
           
            removeAll();
            initRepeatPanel();
            
            mainCharacter = controlTutorial.getMainCharacter();
            setRepeatMainCharacter(mainCharacter);
        }

    }

}
