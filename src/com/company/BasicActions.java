package com.company;

public enum BasicActions {
    ATTACK("single enemy", 1, 0, 0),
    SPECIAL("menu"),
    ITEM("menu"),
    RUN("skip"),

    FIREBALL("single enemy", 10, 1, 0),
    LIGHTNING("all enemies", 15, 3, 0);

    //TODO: Unsure about keeping this.
    //Options: "single enemy", "all enemies", "menu", "self", "single PC", "full party", "skip"
    String targets;

    BasicActions (String targets){
        this.targets = targets;
    }

    //for skills
    double BP;
    double effectChance;
    double MPcost;
    BasicActions (String targets, double BP, double MPcost, double effectChance){
        this.targets = targets;
        this.BP = BP;
        this.MPcost = MPcost;
        this.effectChance = effectChance;
    }

    //for items
    //TODO: Note: Could create an inventory using an "owned" variable, but bad practice. Use inventory list on character
    //TODO: Not sure what fields items need
    //int index //store index of item?
    /*BasicActions (String targets){
        this.targets = targets;
    }*/
}
