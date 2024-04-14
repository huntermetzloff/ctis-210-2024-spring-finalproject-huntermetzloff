package edu.guilford;
import java.util.Random;

public class Player {

    private double strength; // determines strength score from 0-10
    private double agility; // 0-10
    private double intelligence; // 0-10
    private double wisdom; // 0-10
    private double charisma; // 0-10
    private double luck; // 0-10
    private double faith; // 0-10
    private String name; // the player's name
    private String playerClass; // the player's class
    private int playerGold; // How much gold the player has
    private String playerPic; // set the string for the picture used

    Random rand = new Random();
    Random randStats = new Random();

    // Constructor
    public Player() {
        int randomClass = rand.nextInt(11);
        if (randomClass == 0) {
            playerClass = "Warrior"; // high str and dex
            strength = 10;
            agility = 9;
            intelligence = 3;
            wisdom = 4;
            charisma = 4;
            luck = 5;
            faith = 5;
            playerGold = 5;
            playerPic = "warrior_redHead.png";
        } else if (randomClass == 1) {
            playerClass = "Rogue"; // High dex and luck
            strength = 6;
            agility = 10;
            intelligence = 5;
            wisdom = 3;
            charisma = 5;
            luck = 9;
            faith = 2;
            playerGold = 10;
            playerPic = "rogue.png";
        } else if (randomClass == 2) {
            playerClass = "Wizard"; // High intelligence and wisdom
            strength = 2;
            agility = 1;
            intelligence = 10;
            wisdom = 10;
            charisma = 5;
            luck = 6;
            faith = 6;
            playerGold = 2;
            playerPic = "wizard_blue.png";
        } else if (randomClass == 3) {
            playerClass = "Bard"; // High Charisma and wisdom
            strength = 2;
            agility = 5;
            intelligence = 5;
            wisdom = 5;
            charisma = 10;
            luck = 9;
            faith = 4;
            playerGold = 7;
            playerPic = "bard.png";
        } else if (randomClass == 4) {
            playerClass = "Gambler"; // High luck and faith
            strength = 4;
            agility = 5;
            intelligence = 4;
            wisdom = 2;
            charisma = 6;
            luck = 10;
            faith = 9;
            playerGold = 15;
            playerPic = "gambler.png";
        } else if (randomClass == 5) {
            playerClass = "Paladin"; // High faith and strength
            strength = 10;
            agility = 4;
            intelligence = 4;
            wisdom = 4;
            charisma = 4;
            luck = 4;
            faith = 10;
            playerGold = 0;
            playerPic = "red_paladin.png";

        } else if (randomClass == 6) {
            playerClass = "Artificer"; // High intelligence
            strength = 3;
            agility = 6;
            intelligence = 10;
            wisdom = 7;
            charisma = 6;
            luck = 4;
            faith = 4;
            playerGold = 5;
            playerPic = "artificer.png";
        } else if (randomClass == 7) {
            playerClass = "Confessor"; // Hybrid melee and faith
            strength = 10;
            agility = 10;
            intelligence = 2;
            wisdom = 3;
            charisma = 3;
            luck = 2;
            faith = 10;
            playerGold = 0;
            playerPic = "confessor.png";
        } else if (randomClass == 8) {
            playerClass = "Samurai"; // wisdom, strength, dex
            strength = 8;
            agility = 8;
            intelligence = 4;
            wisdom = 8;
            charisma = 4;
            luck = 4;
            faith = 4;
            playerGold = 5;
            playerPic = "samurai.png";
        } else if (randomClass == 9) {
            playerClass = "Wretch"; // even stat line
            strength = 5;
            agility = 5;
            intelligence = 5;
            wisdom = 5;
            charisma = 5;
            luck = 5;
            faith = 5;
            playerGold = 5;
            playerPic = "wretch.png";
        } else if (randomClass == 10) {
            playerClass = "Prisoner"; // intelligence + dex, medium strength
            strength = 7;
            agility = 10;
            intelligence = 9;
            wisdom = 5;
            charisma = 5;
            luck = 3;
            faith = 3;
            playerGold = 2;
            playerPic = "prisoner.png";

        }

        int nameValue = rand.nextInt(0, 12);
        if (nameValue == 0) {
            name = "Smith Smithson";
        } else if (nameValue == 1) {
            name = "John Johnson";
        } else if (nameValue == 2) {
            name = "Jimmy Jimmyson";
        } else if (nameValue == 3) {
            name = "Phil Philson";
        } else if (nameValue == 4) {
            name = "Hunter Metzloff";
        } else if (nameValue == 5) {
            name = "Jonah Morris";
        } else if (nameValue == 6) {
            name = "Greg Lewinksy";
        } else if (nameValue == 7) {
            name = "Tildrith Goodwoman";
        } else if (nameValue == 8) {
            name = "Job Nebuchadnezzar";
        } else if (nameValue == 9) {
            name = "Meli Jenser";
        } else if (nameValue == 10) {
            name = "Johannes Johanson";

        } else if (nameValue == 11) {
            name = "Obu Obu Obu";
        } else if (nameValue == 12) {
            name = "Temere Persona";
        }
    }

    // Getters and Setters

    public double getStrength() {
        return strength;
    }

    public String getPlayerPic() {
        return playerPic;
    }

    public void setPlayerPic(String playerPic) {
        this.playerPic = playerPic;
    }

    public int getPlayerGold() {
        return playerGold;
    }

    public void setPlayerGold(int playerGold) {
        this.playerGold = playerGold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFaith() {
        return faith;
    }

    public void setFaith(double faith) {
        this.faith = faith;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
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

    @Override
    public String toString() {
        return "Player [strength=" + strength + "\n agility=" + agility + "\n intelligence=" + intelligence + "\n wisdom="
                + wisdom + "\n charisma=" + charisma + "\n luck=" + luck + "\n name=" + name + "\n class=" + playerClass
                + " ]";
    }

}
