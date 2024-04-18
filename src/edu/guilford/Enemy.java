package edu.guilford;

import java.util.Random;

public class Enemy {

    private double health;
    private double strength; // determines strength score from 0-10
    private double agility; // 0-10
    private double intelligence; // 0-10
    private double wisdom; // 0-10
    private double charisma; // 0-10
    private double luck; // 0-10
    private double faith; // 0-10
    private String name; // the enemy's name
    private String enemyPic; // string for the picture
    private String resistance; // which type of damage the enemy is resistant to
    private int maxHealth; // their max health
    private int goldValue; // how much gold this monster drops when slain

    Random rand = new Random();

    public Enemy() {
        int enemyChoice = rand.nextInt(4);
        if (enemyChoice == 0) {
            maxHealth = 100;
            health = 100;
            strength = 4;
            agility = 8;
            intelligence = 1;
            wisdom = 3;
            charisma = 2;
            luck = 5;
            faith = 0;
            name = "Slime";
            enemyPic = "src/edu/guilford/resources/slime.png";
            resistance = "none";
            goldValue = 10;
        } else if (enemyChoice == 1) {
            maxHealth = 100;
            health = 100;
            strength = 8;
            agility = 2;
            intelligence = 6;
            wisdom = 3;
            charisma = 0;
            luck = 5;
            faith = 0;
            name = "Skeleton";
            enemyPic = "src/edu/guilford/resources/skeleton.png";
            resistance = "none";
            goldValue = 10;
        } else if (enemyChoice == 2) {
            maxHealth = 100;
            health = 100;
            strength = 2;
            agility = 2;
            intelligence = 8;
            wisdom = 5;
            charisma = 0;
            luck = 5;
            faith = 0;
            name = "Wizard Skeleton";
            enemyPic = "src/edu/guilford/resources/skeleton_wizard.png";
            resistance = "magic";
            goldValue = 20;
        } else if (enemyChoice == 3) {
            maxHealth = 100;
            health = 100;
            strength = 5;
            agility = 5;
            intelligence = 3;
            wisdom = 3;
            charisma = 0;
            luck = 5;
            faith = 0;
            name = "Large Slime";
            enemyPic = "src/edu/guilford/resources/large_slime.png";
            resistance = "physical";
            goldValue = 20;
        }
    }

    // Below are the getters and setters

    public double getHealth() {
        return health;
    }

    public int getGoldValue() {
        return goldValue;
    }

    public void setGoldValue(int goldValue) {
        this.goldValue = goldValue;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getWisdom() {
        return wisdom;
    }

    public void setWisdom(double wisdom) {
        this.wisdom = wisdom;
    }

    public double getCharisma() {
        return charisma;
    }

    public void setCharisma(double charisma) {
        this.charisma = charisma;
    }

    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

    public double getFaith() {
        return faith;
    }

    public void setFaith(double faith) {
        this.faith = faith;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnemyPic() {
        return enemyPic;
    }

    public void setEnemyPic(String enemyPic) {
        this.enemyPic = enemyPic;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

}
