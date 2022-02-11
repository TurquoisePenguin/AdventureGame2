package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
    private BasicActions[] actions = {BasicActions.ATTACK, BasicActions.SPECIAL, BasicActions.ITEM, BasicActions.RUN};
    private ArrayList<BasicActions> actionsEnum = new ArrayList<>(List.of(BasicActions.ATTACK, BasicActions.SPECIAL, BasicActions.ITEM, BasicActions.RUN));
    private ArrayList<BasicActions> skills = new ArrayList<>(List.of(BasicActions.FIREBALL, BasicActions.LIGHTNING));
    private ArrayList<BasicActions> items = new ArrayList<>(); //TODO: fill as needed, create modifiers

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
    public BasicActions[] getActions() {return actions;}

    public ArrayList<BasicActions> getActionsEnum() {return actionsEnum;}
    public ArrayList<BasicActions> getItems() {return items;}

    //TODO: Do I need this or Skill[]?
    public ArrayList<BasicActions> getSkills(){return skills;}

    //takes an action with a menu, like Item, and returns the menu as an array
    public ArrayList<BasicActions> getMenu(BasicActions action){
        ArrayList<BasicActions> menu;
        switch (action){
            case SPECIAL:
                menu = getSkills();
                break;
            /*case ITEM:
                //menu = getItems(); //TODO: Problem: this wants to be a list? Maybe array of actions with #owned. Ex: [Potions(2), Ethers(1), Elixirs(0)]
                break;*/
            default:    //error
                menu = null;
        }
        return menu;
    }

    //will perform the selected action
    public void performAction(BasicActions action)
    {
        switch(action) {
            case ATTACK:
                //get target

                break;
            case SPECIAL:

                break;
        }
        System.out.println(this.getName() + " action: " + action);
    }

    //if no arg is supplied, selects a random action
    public void performAction()
    {
        System.out.println(this.getName() + " performAction()");
    }

    public void setTurnTime(int turnTime) {
        this.turnTime = turnTime;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //TODO: Convert to enum
    /*public void setActions(String[] actions) {
        this.actions = actions;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }*/
}
