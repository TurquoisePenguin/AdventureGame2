package com.company;

public class PlayerCharacter extends Character{
    //stats?
    private double maxHP=10;
    private double curHP=10;
    private double maxMP=10;
    private double curMP=10;
    private double strength=10;
    private double intelligence=10;
    private double defense=10;
    private double resistance=10;
    private double speed=100;
    private int turnTime=1;
    private int level=1;
    private String[] actions = {"Attack", "Special", "Item", "Run"};
    private Skill[] skills = {new Skill("Fireball", 10, 0)};

    //characteristics?
    private String name="";

    //constructors
    public PlayerCharacter(int level, double maxHP, double curHP, double maxMP, double curMP, double strength, double intelligence, double defense, double resistance, double speed, String name) {
        this.setMaxHP(maxHP);
        this.setCurHP(curHP);
        this.setMaxMP(maxMP);
        this.setCurMP(curMP);
        this.setStrength(strength);
        this.setIntelligence(intelligence);
        this.setDefense(defense);
        this.setResistance(resistance);
        this.setSpeed(speed);
        this.setName(name);
    }
    //constructor with just name
    public PlayerCharacter(String name) {
        this.setName(name);
    }

    //Performs one of the Player's basic actions: Attack, Special, Item, Run
    public void basicAction(String action){
        switch(action.toLowerCase())
        {
            case "attack":
                //get target

                break;
            case "special":

                break;

        }
    }

    public double getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }
    public double getCurHP() {
        return curHP;
    }
    public void setCurHP(double curHP) {
        this.curHP = curHP;
    }
    public double getMaxMP() {
        return maxMP;
    }
    public void setMaxMP(double maxMP) {
        this.maxMP = maxMP;
    }
    public double getCurMP() {
        return curMP;
    }
    public void setCurMP(double curMP) {
        this.curMP = curMP;
    }
    public double getStrength() {
        return strength;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }
    public double getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }
    public double getDefense() {
        return defense;
    }
    public void setDefense(double defense) {
        this.defense = defense;
    }
    public double getResistance() {
        return resistance;
    }
    public void setResistance(double resistance) {
        this.resistance = resistance;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public String[] getActions() {return actions;}
    //TODO: Do I need this or Skill[]?
    public String[] getSkills(){
        String temp="";
        for (Skill skills : this.skills) {
            temp += skills.getName();
        }
        String[] skills = temp.split(" ");
        return skills;
    }


    public void setTurnTime(int turnTime) {
        this.turnTime = turnTime;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setActions(String[] actions) {
        this.actions = actions;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }
}
