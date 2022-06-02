package com.company;
import java.util.*;

public class Skeleton implements EnemyClass{
    Random rand = new Random();
    //random.nextInt(max - min) + min;
    int level=1;
    double maxHP= rand.nextInt(3 - 2) + 2;
    double curHP= this.maxHP;
    double maxMP=2;
    double curMP= this.maxMP;
    double strength=1;
    double intelligence=1;
    double defense=1;
    double resistance=1;
    double speed=100;
    double experience = 10;
    int turnTime=1;
    String name = "Skeleton";
    private ArrayList<BasicActions> actions = new ArrayList<>(List.of(BasicActions.ATTACK, BasicActions.SPECIAL, BasicActions.ITEM, BasicActions.RUN));

    //constructor
    public Skeleton() {}

    public Skeleton(String name) {
        this.name = name;
    }

    public void removeHP(double amount) {   //1 = alive, 0 = dead
        this.curHP = this.curHP - amount;
        if (this.curHP <= 0)
            this.curHP = 0;
    }
    public double getExp() { return this.experience; }

    public int getLevel(){
        return level;
    }
    public void setLevel(final int level){
        this.level=level;
    }
    public void increaseLevel(){
        this.level++;
    }

    public boolean isDead(){
        return (curHP==0);
    }

    public double getCurHP(){
        return this.curHP;
    }
    public double getMaxHP(){
        return this.maxHP;
    }
    public void setHP(final double newHP){
        this.curHP=newHP;
    }
    public double getStrength() {
        return this.strength;
    }
    public double getDefense() { return this.defense; }
    public double getSpeed() { return speed; }
    public ArrayList<BasicActions> getActions() {
        return actions;
    }

    public void takeDamage(final double valueToSubtract){
        this.curHP = this.curHP - valueToSubtract;
    }

    //deal damage to player
    public boolean attack(final Character target){
        //TODO
        return true;
    }

    //will perform the selected action
    public FightStatus performAction(BasicActions action, ArrayList<Character> target)
    {
        System.out.println(this.getName() + " action: " + action.toString());
        return FightStatus.ACTIVE;
    }

    //if no arg is supplied, selects a random action
    public FightStatus performAction()
    {
        System.out.println(this.getName() + " performAction()");
        return FightStatus.ACTIVE;
    }


    public double getMinMeleeDamage(){
        return 0;
    }
    public double getMaxMeleeDamage(){
        return 3;
    }

    public String getName() {
        return name;
    }
    public int getTurnTime() {
        //sets turn time from speed - speed*2
        //TODO:CHECK AND FINISH!!!
        int range = (int)(2*this.getSpeed() - this.getSpeed())+1;
        this.turnTime = (int) (Math.random() * range + this.getSpeed());
        //System.out.println(this.getName() + " Turn time: " + this.turnTime);  //debugging
        return turnTime;
    }

    //comparable
    public String toString(){
        return this.getName();
    }

    public int compareTo(Character o){
        return o.getTurnTime() - this.getTurnTime();
    }
}
