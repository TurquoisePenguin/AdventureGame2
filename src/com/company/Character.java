package com.company;

import java.util.Comparator;
import java.util.Random;

public class Character implements Comparable<Character> {
    //stats
    double maxHP;
    double curHP;
    double maxMP;
    double curMP;
    double strength;
    double intelligence;
    double defense;
    double resistance;
    double speed;
    int turnTime;

    //characteristics
    String name="";
    BasicActions[] actions;

    double getMaxHP(){return this.maxHP;}
    double getCurHP(){return this.curHP;}
    double getStrength(){return this.strength;}
    double getDefense(){return this.defense;}
    double getSpeed(){return this.speed;}
    String getName(){return this.name;}
    public BasicActions[] getActions(){return this.actions;}

    //remove <amount> of HP, returns 1 if still alive, 0 if dead
    public int removeHP(double amount) {   //1 = alive, 0 = dead
        curHP = curHP - amount;
        if (curHP <= 0)
            return 0;       //dead
        else
            return 1;       //alive
    }

    //returns an int based on speed, higher number goes first
    public int getTurnTime() {
        //sets turn time from speed - speed*2
        //TODO:CHECK AND FINISH!!!
        int range = (int)(2*this.getSpeed() - this.getSpeed())+1;
        this.turnTime = (int) (Math.random() * range + this.getSpeed());
        //System.out.println(this.getName() + " Turn time: " + this.turnTime);  //debugging
        return turnTime;
    }

    //will perform the selected action
    public void performAction(BasicActions action)
    {
        System.out.println("This must be implemented in appropriate class.");
    }

    //if no arg is supplied, selects a random action
    public void performAction()
    {
        System.out.println("This must be implemented in appropriate class.");
    }


    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public int compareTo(Character o){
        return o.getTurnTime() - this.getTurnTime();
    }
/*
    int getLevel();
    void setLevel(final int level);
    int increaseLevel();
    boolean isDead();
    int getHP();
    int getMaxHP();
    int setHP(final int newHP);
    void damage(final int valueToSubstract);
    boolean attack(final BattleUnit target);
    int getMinMeleeDamage();
    int getMaxMeleeDamage();;
*/
}
