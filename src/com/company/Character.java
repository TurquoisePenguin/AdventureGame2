package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public interface Character extends Comparable<Character>{
    //stats to be implemented


    //characteristics to be implemented

    double getMaxHP();
    double getCurHP();
    double getStrength();
    double getDefense();
    double getSpeed();
    String getName();
    public ArrayList<BasicActions> getActions();

    //remove <amount> of HP, returns 1 if still alive, 0 if dead
    public void removeHP(double amount);
    public double getExp();

    //returns an int based on speed, higher number goes first
    public int getTurnTime();



    //will perform the selected action
    public void performAction(BasicActions action);

    //if no arg is supplied, selects a random action
    public void performAction();


    public String toString();

    public int compareTo(Character o);
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
