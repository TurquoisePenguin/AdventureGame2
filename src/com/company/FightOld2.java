

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FightOld2 {
    Character mainCharacter;
    Character[] enemy;

    public FightOld2(Character mainCharacter, Character[] enemy) {
        this.mainCharacter = mainCharacter;
        this.enemy = enemy;

        boolean fighting = true;
        while (fighting) {
            System.out.println(mainCharacter.getName());
            System.out.println("HP: " + mainCharacter.getCurHP() + "/ " + mainCharacter.getMaxHP());

            for (int i = 0; i < enemy.length; i++) {
                //System.out.println("GOT HERE");
                System.out.println(enemy[i].getName());
                System.out.println("HP: " + enemy[i].getCurHP() + "/ " + enemy[i].getMaxHP());
            }

            String action = fightChoice();
            System.out.println(action);

            //determine attacking order
            Character[] actors = new Character[enemy.length + 1];
            for (int i = 0; i < enemy.length; ++i) {
                actors[i] = enemy[i];
            }
            actors[actors.length-1] = mainCharacter;


            fighting = false;
        }
    }

    //method for choosing action within fight
    public String fightChoice(){
        Scanner scan = new Scanner(System.in);
        String choice;

        //display main choices
        int count = 1;  //used to format options
        for (BasicActions actions : mainCharacter.getActions())
        {
            System.out.print(actions);
            if (count % 2 == 0)
                System.out.print("\n");
            else
                System.out.print("\t");
            count++;
        }

        System.out.println("What would you like to do?");
        choice = scan.nextLine();
        return choice;
    }

    //damage calculation
    public double damageCalc(Character attacker, Skill attackSkill, Character defender)
    //first determine attacking order
    //then determine skills selected
    //then perform actions
    //resolve effects
    //finally check if combat continues
    {
        return (attacker.getStrength() * attackSkill.getBP()) / defender.getDefense();
    }
}
