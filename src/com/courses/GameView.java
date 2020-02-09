package com.courses;

import java.util.ArrayList;

public class GameView {

    public void outStartMessage(){
        System.out.println("Game started!");
    }

    public void printDimensions(int min, int max){
        System.out.println("Guess a number on the scope " + min + " - " + max + " : ");
    }

    public void incorrectInput(){
        System.out.println("Incorrect input, input numbers! ");
    }

    public void outOfBound(){
        System.out.println("Last number out of needed bounds!");
        System.out.println("Please, input correctly");
    }

    public void printContinue(){
        System.out.println("You are not guess!");
        System.out.println();
    }

    public void printEnd(int number){
        System.out.println("You are guess!");
        System.out.println();
        System.out.println("Correct number is: " + number);
    }

    public void outOfAttempts(ArrayList<String> attempts){
        System.out.println("All attempts is: ");
        for(String attemp : attempts)
            System.out.print(" " + attemp + " ");

    }





}
