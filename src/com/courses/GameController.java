package com.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {

    private GameModel gameModelodel;
    private GameView gameViewiew;
    public static final int RAND_MAX = 100;
     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    GameController( GameModel model, GameView view){
        gameModelodel = model;
        gameViewiew = view;
    }

    public void firstDimension() {

        gameViewiew.outStartMessage();
        gameModelodel.setMin(0);
        gameModelodel.setMax(100);
        gameModelodel.insertNumber();
        outDimensions();
    }

    public void readInputNumber(){

            try {
                gameModelodel.setPlayerNumber(Integer.parseInt(String.valueOf(bufferedReader.readLine())));
                checking();
            } catch (Exception e) {
                gameViewiew.incorrectInput();
                readInputNumber();
            }

    }

    public void outDimensions(){

        gameViewiew.printDimensions(gameModelodel.getMin(), gameModelodel.getMax());

    }

    public void checking(){

        if(!gameModelodel.checkCorrection()) {
            gameModelodel.addAttempts();
            gameViewiew.outOfBound();
            readInputNumber();
        }
        else {
            if (!gameModelodel.checkEquality()) {
                gameModelodel.addAttempts();
                gameViewiew.printContinue();
                gameModelodel.newDimensions();
                outDimensions();
                readInputNumber();
            }
            else {
                gameModelodel.addAttempts();
                gameViewiew.printEnd(gameModelodel.getPlayerNumber());
                gameViewiew.outOfAttempts(gameModelodel.getAttempts());
            }
        }

    }



}
