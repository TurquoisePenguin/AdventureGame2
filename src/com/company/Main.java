package com.company;
import java.util.Locale;
import java.util.*;
//rand.nextInt(max - min) + min;
//TODO: "Documentation"
//DONE!: GitHub
//TODO: Idea, each room has set actions. See Dungeonman


public class Main {
    //TODO: Ideas: Player can change into different animals with different abilities. Animals include penguin, phoenix, wolf
    static int moveCounter = 0;
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        int x,y;    //coordinates of player
        String choice;      //The choice a player makes
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();


        LinkedHashMap<String, Boolean> introDesc = new LinkedHashMap<>();
        introDesc.put("You wake up on the ground feeling cold. You feel leaves and dirt underneath your wing.", true);
        ArrayList<String> introActions = new ArrayList<>();
        introActions.add("North");
        HashMap<String, Boolean> introFlags = new HashMap<>();
        introFlags.put("End", false);

        //Room intro = new Room("intro", introDesc, introActions, introFlags);
        Room intro = new Room("src/com/company/rooms/intro.txt");
        intro.getDescription();
        //Print intro
        //TODO: Condense this
        String mainName = scan.nextLine();
        PlayerCharacter mainCharacter = new PlayerCharacter(mainName);
        System.out.println("You decide to look around. Which way do you go?");
        //System.out.println("You are " + mainCharacter.getPlayerName());

        //Print choices
        System.out.println("North");
        System.out.println("South");
        System.out.println("East");
        System.out.println("West");

        //Read choice
        choice = scan.nextLine();
        switch(choice.toLowerCase()) {
            case "north":
            case "n":
                if(checkRandomEncounter()) {

                    ArrayList<Character> skeleton = new ArrayList<>();//1-3 skeletons
                    for (int i=0; i<rand.nextInt(1)+2; i++){
                        skeleton.add(new Skeleton("Skeleton" + (i+1)));
                    }
                    Fight random = new Fight(mainCharacter, skeleton);
                }
                System.out.println("North");
                break;
            case "east":
            case "e":
                System.out.println("East");
                break;
            case "south":
            case "s":
                System.out.println("South");
                break;
            case "west":
            case "w":
                System.out.println("West");
                break;
        }
    }
    //returns True if random encounter
public static boolean checkRandomEncounter(){
        moveCounter++;  //increment move counter
        Random rand = new Random();
        if (moveCounter>10) {
            moveCounter = 9;
        }
        int encounterRate = moveCounter*10; //10% per step
        //return ((rand.nextInt(100)) < encounterRate);
        return true;        //TODO
}


}
