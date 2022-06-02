package com.company;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

//Class representing a place the PC can visit.
//This should be the main, possibly only, way the user interacts with the world
//TODO: Important: Read from file, use loop to add line by line to desc
//TODO: Implement flags, actions, etc. Need to get input from team.
public class Room {
    //coordinates of location of room, must be unique
    int x,y;
    String name;

    //stores room descriptions + flag indicating whether to display
    //for example: <"You enter a dark room", 1> will display that description if bool is 1
    LinkedHashMap<String, Boolean> description;

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
    public Room(String name, LinkedHashMap<String, Boolean> description, ArrayList<String> actions, HashMap<String, Boolean> flags) {
        this.name = name;
        this.description = description;
        this.actions = actions;
        this.flags = flags;
    }

    //TODO: Read from file path and load class variables
    public Room(String filePath) {
        this.description = new LinkedHashMap<>();
        try {
            File roomData = new File(filePath);
            Scanner scan = new Scanner(roomData);
            //loop over all file
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //add name
                if (line.toLowerCase().contains("{roomname}"))
                    this.name = scan.nextLine();
                else if (line.toLowerCase().contains("{x}"))
                    this.x = scan.nextInt();
                else if (line.toLowerCase().contains("{y}"))
                    this.y = scan.nextInt();
                else if (line.toLowerCase().contains("{description}")) {
                    while (scan.hasNextLine()) {
                        line = scan.nextLine();
                        if (line.toLowerCase().contains("{true}")) {
                            description.put(line.replaceAll("\\{true\\}|\\{True\\}|\\{TRUE\\}", ""), true);
                        } else if (line.toLowerCase().contains("{false}")) {
                            description.put(line.replaceAll("\\{false\\}|\\{False\\}|\\{FALSE\\}", ""), false);
                        }
                    }

                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + filePath + " not found.");
            e.printStackTrace();
        }
    }

    public void getDescription() {
        for (String i : description.keySet()) {
            if (description.get(i))
                System.out.println(i);
        }
    }
}