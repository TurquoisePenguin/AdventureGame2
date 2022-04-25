package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class PlayerCharacter implements Character{
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
    private double experience=0;
    private ArrayList<BasicActions> actions = new ArrayList<>(List.of(BasicActions.ATTACK, BasicActions.SPECIAL, BasicActions.ITEM, BasicActions.RUN));
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
    public boolean isDead(){
        return (curHP==0);
    }

    public void removeHP(double amount) {   //1 = alive, 0 = dead
        this.curHP -= amount;
        if (this.curHP <= 0)
            this.curHP = 0;
    }

    public void removeMP(double amount) {
        this.curMP -= amount;
        if (this.curMP <= 0)
            this.curMP = 0;
    }
    public double getExp() { return this.experience; }

    public void addExp(double amount){
        this.experience += amount;
        System.out.println("You gain " + (int) amount + " exp.");
        //TODO: Check levelup
    }

    public int getTurnTime() {
        //sets turn time from speed - speed*2
        //TODO:CHECK AND FINISH!!!
        int range = (int)(2*this.getSpeed() - this.getSpeed())+1;
        this.turnTime = (int) (Math.random() * range + this.getSpeed());
        //System.out.println(this.getName() + " Turn time: " + this.turnTime);  //debugging
        return turnTime;
    }

    public ArrayList<BasicActions> getActions() {return actions;}
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

    //will perform the selected action on selected target
    public FightStatus performAction(BasicActions action, ArrayList<Character> target)
    {
        Random rand = new Random();
        switch(action) {
            case ATTACK:
                //get target
                target.get(0).removeHP(action.BP);
                System.out.println("You deal " + action.BP + " damage to " + target.get(0).getName() + ".");
                break;
            case FIREBALL:
            case LIGHTNING:
                //iterate through targets
                this.removeMP(action.MPcost);
                for (Character enemy : target){
                    if (!enemy.isDead()){
                        System.out.println("You deal " + action.BP + " damage to " + enemy + ".");
                        enemy.removeHP(action.BP);  //TODO: Create damage formula
                    }
                }
                break;
            case RUN:
                if (rand.nextBoolean()){    //TODO: Implement odds
                    System.out.println(this.getName() + " ran away.");
                    return FightStatus.RUN;
                }
                else
                    System.out.println(this.getName() + " failed to run away.");
        }
        System.out.println(this.getName() + " action: " + action);
        return FightStatus.ACTIVE;
    }

    //for actions with no specified target. Maybe Run
    public FightStatus performAction(BasicActions action){
        //TODO
        return FightStatus.ACTIVE;
    }

    //if no arg is supplied, selects a random action
    public FightStatus performAction( )
    {
        System.out.println(this.getName() + " performAction()");
        return FightStatus.ACTIVE;
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

    public String toString(){
        return this.getName();
    }

    public int compareTo(Character o){
        return o.getTurnTime() - this.getTurnTime();
    }
}
