package com.company;

import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;

public class Fight {
    PlayerCharacter mainCharacter;  //taken through constructor //Player Character that is fighting
    EnemyClass[] enemies;   //taken through constructor, expected to change as needed   //enemy or enemies that are fighting PC
    static String[] mainActions = {"Attack", "Skills", "Item", "Run"}; //First level options for fighting, may change as needed?

    public Fight(PlayerCharacter mainCharacter, EnemyClass[] enemies) {
        this.mainCharacter = mainCharacter;
        this.enemies = enemies;
        this.fighting();
    }

    //returns true if still alive
    public boolean fighting(){
        boolean fighting = true;
        while (fighting){

            String playerAction = "";

            //print characters and status
            System.out.println(mainCharacter.getName());
            System.out.println("HP: " + mainCharacter.getCurHP() + "/ " + mainCharacter.getMaxHP() + "\n");

            printEnemies(enemies);

            //choose action
            playerAction = selectAction(mainCharacter.getActions());
            System.out.println(playerAction);

            //old if-then to perform appropriate action selected
            /*if (playerAction.equalsIgnoreCase("Attack"))
            {
                //select target
                //get list of targets

                //Attack
                // (Player Attack)/(Enemy Defense)
            }
            if (playerAction.equalsIgnoreCase("Skills"))
            {
                //select skill
                //select target
                //Skills
            }
            if (playerAction.equalsIgnoreCase("Items"))
            {
                //select item
                //?select target
                //Items
            }
            if (playerAction.equalsIgnoreCase("Runs"))
            {
                //Run
            }*/

            //determine turn order
            Character[] turnOrder = getTurnOrder(enemies);

            //perform actions in order
            for (Character actor:turnOrder) {
                //TODO: Do I check if dead here or inside class?
                if (actor instanceof PlayerCharacter) {
                    mainCharacter.basicAction(playerAction);
                }
                else{
                    actor.performAction();
                }
            }


            fighting=false;
        }
        return true;
    }

    //Format and print enemies
    private void printEnemies(EnemyClass[] enemies)
    {
        String enemyNames = "";
        String enemyHPs = "";
        for (int i=0; i<enemies.length; i++)    //DONE: Clean up print format
        {
            if (enemies[i].getCurHP()>0)       //make sure enemy isn't dead    //BROKEN
            {
                if ((i+1)<enemies.length)   //before the last enemy, tab
                {
                    enemyNames += enemies[i].getName() +"\t\t";
                    enemyHPs += "HP: " + enemies[i].getCurHP() + "/ " + enemies[i].getMaxHP() + "\t";
                } else        //no tab
                {
                    enemyNames += enemies[i].getName();
                    enemyHPs += "HP: " + enemies[i].getCurHP() + "/ " + enemies[i].getMaxHP() + "\n";
                }
            }
        }
        System.out.println(enemyNames);
        System.out.println(enemyHPs);
    }

    //Prints available actions and waits for user input
    //When user makes appropriate choice, returns string of action chosen
    //TODO: Use enums and try-check
    private String selectAction(String[] actions){
        Scanner scan = new Scanner(System.in);
        boolean selected = false;
        String choice = "";

        //loop to take selection
        while (!selected){

            //display actions
            System.out.println(Arrays.toString(actions));

            //if you want to format, use this
            /*int count = 1;  //used to format options
            for (String action : actions)
            {
                System.out.print(action);
                if (count % 2 == 0)
                    System.out.print("\n");
                else
                    System.out.print("\t");
                count++;
            }*/

            System.out.print("What would you like to do? ");
            //Read choice
            choice = scan.nextLine();

            if (isInteger(choice)){  //if choice is an integer
                int intChoice = Integer.parseInt(choice);   //convert choice to int
                if (intChoice>0 && intChoice<=actions.length)   //choice is between 1 and # of choices eg 1-4
                {
                    choice = actions[intChoice-1];    //returns choice, eg 1=Attack, 2=Skills, etc
                    selected = true;
                }
            }
            else {  //check if choice is in actions
                for (String action : actions) {
                    if (choice.equalsIgnoreCase(action)) {
                        selected = true;
                    }
                }
            }
            if (!selected){ //error message
                System.out.println("Please select an appropriate action");
            }
        }
        return choice;
    }

    //Returns an array of Character[] containing PC and enemies in appropriate turn order
    //TODO: turn into a queue/linkedlist
    private Character[] getTurnOrder(Character[] enemies)
    {
        Character[] actors = new Character[enemies.length + 1];
        for (int i = 0; i < enemies.length; ++i) {
            actors[i] = enemies[i];
        }
        actors[actors.length-1] = mainCharacter;
        Arrays.sort(actors);
        /*Comparator.comparing(Character::getTurnTime).thenComparing(Character::getName);
        Arrays.sort(actors, Comparator.comparing(Character::getTurnTime));*/
        return actors;
    }


    //Method to select target of skills/attacks.
    //Returns in of array of targets
    //TODO: unfinished
    private int selectTarget(EnemyClass[] enemies)
    {
        Scanner scan = new Scanner(System.in);
        String choice = ""; //temp choice variable

        boolean selected = false;
        while (!selected)
        {
            //Print targets
            printEnemies(enemies);

            //Prompt user
            System.out.print("Please select a target:");

            //Take input
            choice = scan.nextLine();

            //Validate
            //EX:   Started fight with Skel1, Skel2, Bat1, Bat2.
            //      Killed Skel2.
            //      Enemies remaining: Skel1, Bat1, Bat2
            //      Player selects 2, should return Bat1.

        }
        return 1;   //error
    }

    //returns number of living/active enemies
    private static int getActiveEnemies(EnemyClass[] enemies)
    {
        int count = 0;   //counts the number of enemies alive
        for (int i=0; i<enemies.length; i++)
        {
            if (enemies[i].getCurHP()>0)
            {
                count++;
            }
        }
        return count;
    }

    //Method to verify if string is integer
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    //TODO: Actually TODO: Take selected action, take target, perform appropriate action to target,
    // have enemies act (determine order of attacks), finalize or continue combat
}