package com.company;

import java.util.Comparator;
import java.util.Random;

public class Character implements Comparable<Character> {
    //stats
    double maxHP=10;
    double curHP=10;
    double maxMP=10;
    double curMP=10;
    double strength=10;
    double intelligence=10;
    double defense=10;
    double resistance=10;
    double speed=10;
    int turnTime=1;

    //characteristics
    String name="";
    String[] actions;

    double getMaxHP(){return this.maxHP;};
    double getCurHP(){return this.curHP;};
    double getStrength(){return this.strength;};
    double getDefense(){return this.defense;};
    double getSpeed(){return this.speed;}
    String getName(){return this.name;};
    public String[] getActions(){return this.actions;};

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
    public void performAction(String action)
    {

    }

    //if no arg is supplied, selects a random action
    public void performAction()
    {
        int rand = new Random().nextInt(this.actions.length);
        performAction(this.actions[rand]);
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
