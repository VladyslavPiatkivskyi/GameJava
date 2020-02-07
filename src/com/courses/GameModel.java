package com.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameModel {

    private int number;
    private int min;
    private int max;
    private int playerNumber;
    private ArrayList <Integer> attempts = new ArrayList<>();

    public void insertNumber() {
        this.number = rand(min,max);
    }

    public int rand(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }


    public boolean checkCorrection(){
        if(playerNumber > max || playerNumber < min) {
            return false;
        }
        else
            return true;
    }

    public boolean checkEquality(){
        if(playerNumber == number) {
            return true;
        }
        else {
            return false;
        }
    }

    public void newDimensions(){
        if(playerNumber > number)
            max = playerNumber;
        else
            min = playerNumber;
        System.out.println("new dimension is: " + min + " - " + max);
    }

    public void addAttempts(){
        attempts.add(playerNumber);
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getNumber() {
        return number;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ArrayList<Integer> getAttempts() {
        return attempts;
    }

    public void setAttempts(ArrayList<Integer> attempts) {
        this.attempts = attempts;
    }
}
