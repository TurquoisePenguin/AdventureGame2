package com.company;

public class Skill {
    String name ="";
    double BP=0;    //Battle Power, basically damage multiplier
    double effectChance=0;

    public Skill(String name, double BP, double effectChance) {
        this.name=name;
        this.BP = BP;
        this.effectChance = effectChance;
    }

    public String getName() {
        return name;
    }

    public double getBP() {
        return BP;
    }

    public double getEffectChance() {
        return effectChance;
    }
}
