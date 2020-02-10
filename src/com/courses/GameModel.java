package com.courses;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private int number;
    private int min;
    private int max;
    private int playerNumber;
    private List<String> attempts = new ArrayList<>();

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
    }

    public void addAttempts(){
        attempts.add(String.valueOf(playerNumber));
    }

    public void addAttempts(String attemp){
        attempts.add(attemp);
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

    public List<String> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<String> attempts) {
        this.attempts = attempts;
    }
}
