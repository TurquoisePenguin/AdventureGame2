package com.company;

import java.util.*;

public class Fight {
    PlayerCharacter mainCharacter;  //taken through constructor //Player Character that is fighting
    ArrayList<Character> enemies;   //taken through constructor, expected to change as needed   //enemy or enemies that are fighting PC
    //static String[] mainActions = {"Attack", "Skills", "Item", "Run"}; //First level options for fighting, may change as needed?  //TODO:Deprecated

    public Fight(PlayerCharacter mainCharacter, ArrayList<Character> enemies) {
        this.mainCharacter = mainCharacter;
        this.enemies = enemies;
        //TODO: You encounter <number> <enemy/enemies>.
        this.fighting();
    }

    //returns true if still alive
    public boolean fighting(){
        boolean fighting = true;
        BasicActions playerAction;
        while (fighting){


            ArrayList<Character> target;

            //print characters and status
            System.out.println(mainCharacter.getName());
            System.out.println("HP: " + mainCharacter.getCurHP() + "/ " + mainCharacter.getMaxHP() + "\n");

            printEnemies(enemies);

            //choose action
            playerAction = selectAction(mainCharacter.getActions());
            System.out.println(playerAction);   //TODO: for debugging

            //if selected action has a secondary menu, open it
            if (playerAction.targets.equalsIgnoreCase("menu")){
                playerAction = selectAction(mainCharacter.getMenu(playerAction));
            }

            //get target
            //create list of possible targets. Attack: Enemy1, Enemy2, etc. Item: Self, Party, any 1 enemy? Run: skip
            target = getTarget(playerAction, enemies);
            System.out.println(target.get(0).getName());  //TODO: for debugging, assumes enemy target



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
            ArrayList<Character> turnOrder = getTurnOrder(enemies);

            //perform actions in order
            for (Character actor:turnOrder) {
                //TODO: Do I check if dead here or inside class?
                if (actor instanceof PlayerCharacter) {
                    if (mainCharacter.getCurHP() > 0)   //dead check
                        mainCharacter.performAction(playerAction, target);

                }
                else{
                    if (actor.getCurHP() > 0)   //dead check
                        actor.performAction();
                }
            }

            int deadCount=0;  //counts the number of dead enemies, if all dead, finish fight
            for (Character enemy : enemies) {
                if (enemy.isDead())
                    deadCount++;
            }
            if(deadCount == enemies.size()){  //TODO: Check HP values and finish fight
                //TODO: Distribute exp
                for (Character enemy : enemies) {
                    mainCharacter.addExp(enemy.getExp());
                }
                fighting=false;
            }
        }
        return true;
    }

    //Format and print enemies
    private static void printEnemies(ArrayList<Character> enemies)
    {
        String enemyNames = "";
        String enemyHPs = "";
        for (int i=0; i<enemies.size(); i++){    //DONE: Clean up print format
            if (enemies.get(i).getCurHP()>0)       //make sure enemy isn't dead    //BROKEN
            {
                if ((i+1)<enemies.size()){   //before the last enemy, tab
                    enemyNames += enemies.get(i).getName() +"\t\t";
                    enemyHPs += "HP: " + enemies.get(i).getCurHP() + " / " + enemies.get(i).getMaxHP() + "\t";
                } else{        //no tab
                    enemyNames += enemies.get(i).getName();
                    enemyHPs += "HP: " + enemies.get(i).getCurHP() + " / " + enemies.get(i).getMaxHP() + "\n";
                }
            }
            else {
                if ((i+1)<enemies.size()){   //before the last enemy, tab
                    enemyNames += enemies.get(i).getName() + "\t\t";
                    enemyHPs += "HP: DEAD\t\t";
                } else{        //no tab
                    enemyNames += enemies.get(i).getName();
                    enemyHPs += "HP: DEAD\n";
                }
            }
        }
        System.out.println(enemyNames);
        System.out.println(enemyHPs);
    }

    //Prints available actions and waits for user input
    //When user makes appropriate choice, returns string of action chosen
    //TODO: Use enums and try-check
    private BasicActions selectAction(ArrayList<BasicActions> actions){
        Scanner scan = new Scanner(System.in);
        boolean selected = false;
        String choice = "";

        //loop to take selection
        while (!selected){

            //display actions
            System.out.println(actions.toString());

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
                if (intChoice>0 && intChoice<=actions.size())   //choice is between 1 and # of choices eg 1-4
                {
                    choice = actions.get(intChoice-1).toString();    //returns choice, eg 1=Attack, 2=Skills, etc
                    selected = true;
                }
            }
            else {  //check if choice is in actions
                for (BasicActions action : actions) {
                    if (choice.equalsIgnoreCase(action.toString())) {
                        selected = true;
                    }
                }
            }
            if (!selected){ //error message
                System.out.println("Please select an appropriate action");
            }
        }
        return BasicActions.valueOf(choice.toUpperCase());
    }

    //given a character's <action>, presents selectable targets (if applicable) abd returns target (if applicable)
    public ArrayList<Character> getTarget(BasicActions action, ArrayList<Character> enemies){
        Scanner scan = new Scanner(System.in);
        String choice = "";
        int target = -2;    //returns array index if applicable, -1 for self, -2 is error

        switch(action.targets) {
            //select enemy
            case "single enemy":
                boolean selected = false;

                //loop to take selection
                //TODO: Important. Check for HP and exclude dead choices
                while (!selected){
                    System.out.println("Who would you like to " + action + "?");
                    choice = scan.nextLine();
                    boolean deadSelect=false;
                    if (isInteger(choice)){  //if choice is an integer
                        int intChoice = Integer.parseInt(choice);   //convert choice to int
                        if (intChoice>0 && intChoice<=enemies.size())   //choice is between 1 and # of choices eg 1-4
                        {
                            if (enemies.get(intChoice-1).isDead())
                                deadSelect = true;
                            else {
                                target = intChoice-1;
                                selected = true;
                            }
                        }
                    }
                    else{
                        target = -1;    //target will equal index of enemy chosen by end of loop
                        for (Character enemy : enemies){
                            target++;
                            if (choice.equalsIgnoreCase(enemy.getName())){
                                if (enemies.get(target).isDead())
                                    deadSelect = true;
                                else {
                                    selected = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (!selected){
                        Fight.printEnemies(enemies);
                        if (deadSelect)
                            System.out.println("Your target is dead. Please select another target.");
                        else
                            System.out.println("Please make an appropriate choice.");
                    }
                }
                break;
            //return all enemies
            case "all enemies":
                return enemies;
            case "menu":
                //code
                break;
            case "self":
                //code
                break;
            case "single PC":
                //code
                break;
            case "full party":
                //code
                break;
            case "skip":
            case "null":
            default:
                target = -2;
                break;
        }
        ArrayList<Character> returnTarget = new ArrayList<>();
        returnTarget.add(enemies.get(target));
        return returnTarget;
    }

    //Returns an array of ArrayList<Character> containing PC and enemies in appropriate turn order
    private ArrayList<Character> getTurnOrder(ArrayList<Character> enemies)
    {
        ArrayList<Character> actors = new ArrayList<>();
        for (int i = 0; i < enemies.size(); ++i) {
            actors.add(enemies.get(i));
        }
        actors.add(mainCharacter);
        Collections.sort(actors);
        /*Comparator.comparing(Character::getTurnTime).thenComparing(Character::getName);
        Arrays.sort(actors, Comparator.comparing(Character::getTurnTime));*/
        return actors;
    }


    //TODO: Deprecated
    //Method to select target of skills/attacks.
    //Returns in of array of targets
    //TODO: unfinished
    /*private int selectTarget(ArrayList<Character> enemies)
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
    }*/

    //returns number of living/active enemies
    private static int getActiveEnemies(ArrayList<EnemyClass> enemies)
    {
        int count = 0;   //counts the number of enemies alive
        for (int i=0; i<enemies.size(); i++)
        {
            if (enemies.get(i).getCurHP()>0)
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