package com.courses.data;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private int number;
    private int min;
    private int max;
    private int playerNumber;
    private List<String> attempts = new ArrayList<>();



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

    public void setNumber(int number) {
        this.number = number;
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
