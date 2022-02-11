package com.company;
import java.util.*;

public class Skeleton extends EnemyClass{
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
    double speed=3;
    int turnTime=1;
    String name = "Skeleton";
    BasicActions[] actions = {BasicActions.ATTACK};

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
    public BasicActions[] getActions() {
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
    @Override
    public void performAction(BasicActions action)
    {
        System.out.println(this.getName() + " action: " + action.toString());
    }

    //if no arg is supplied, selects a random action
    @Override
    public void performAction()
    {
        System.out.println(this.getName() + " performAction()");
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



    //constructor
    public Skeleton() {
    }

    public Skeleton(String name) {
        this.name = name;
    }
}
