package com.company;
import java.util.*;

//Class representing a place the PC can visit.
//This should be the main, possibly only, way the user interacts with the world
public class Room {
    //coordinates of location of room, must be unique
    int x,y;

    //stores room descriptions + flag indicating whether to display
    //for example: <"You enter a dark room", 1> will display that description if bool is 1
    HashMap<String, Boolean> description;

    //Stores a list of actions user may input
    //for example, <"North", "South", "fight skeleton", "take amulet">
    ArrayList<String> actions;

    HashMap<String, Boolean> flags;

    /*
    //array of flags that can enable or disable anything
    //for example, flag that disables treasure chest once open
    //for example, flag that disables boss once defeated
    Flag[] flags;

    class Flag {
        String name;
        boolean flagSet;

        //Flag constructor
        Flag(String name, boolean flagSet) {
            this. name = name;
            this.flagSet = flagSet;
        }
    }*/

    //Room constructor
    public Room(HashMap<String, Boolean> description, ArrayList<String> actions, HashMap<String, Boolean> flags) {
        this.description = description;
        this.actions = actions;
        this.flags = flags;
    }

    public void getDescription() {
        for (String i : description.keySet()) {
            if (description.get(i))
                System.out.println(i);
        }
    }
}