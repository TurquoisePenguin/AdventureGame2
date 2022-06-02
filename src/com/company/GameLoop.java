package com.company;
import java.util.*;

public class GameLoop {
    //This is where main gameplay mechanics are stored and loaded
    //Loads maps and movement

    //constructor
    //This is where stuff happens!
    public GameLoop(){
        startMenu();
    }

    private void startMenu(){
        String choice;
        String inputString = "What would you like to do? ";
        String errorString = "Invalid choice.";
        ArrayList<String> options = new ArrayList<>();
        options.add("New Game");
        options.add("Continue");
        options.add("Quit");

        System.out.println("////////////////////////////////////////\n" +
                "          PENGUIN ADVENTURE\n" +
                "\n" +
                "\n" +
                " - NEW GAME\n" +
                " - CONTINUE\n" +
                " - QUIT\n" +
                "////////////////////////////////////////");
        choice = select(inputString, errorString, options);

        switch(choice.toLowerCase()){
            //load new game
            case "new game":

            //load saved game files,
            //then load game
            case "continue":

            case "quit":
                System.out.println("Goodbye.");
                System.exit(0);
        }
    }

    // Asks users for choice until correct choice is input
    private String select(String inputString, String errorString, ArrayList<String> choices){
        String choice = "";
        Scanner scan = new Scanner(System.in);

        //convert list to lowercase
        for(int i=0,l=choices.size();i<l;++i)
        {
            choices.set(i, choices.get(i).toLowerCase());
        }

        while (!choices.contains(choice.toLowerCase())){
            System.out.print(inputString);
            choice = scan.nextLine();
            if (!choices.contains(choice.toLowerCase())){
                System.out.println(errorString);
            }
        }
        return choice;
    }

    private String select(String inputString, ArrayList<String> choices){
        String choice = "";
        Scanner scan = new Scanner(System.in);

        //convert list to lowercase
        for(int i=0,l=choices.size();i<l;++i)
        {
            choices.set(i, choices.get(i).toLowerCase());
        }

        while (!choices.contains(choice.toLowerCase())){
            System.out.print(inputString);
            choice = scan.nextLine();
        }
        return choice;
    }
}
