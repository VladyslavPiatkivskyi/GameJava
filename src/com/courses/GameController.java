package com.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameController {

    private GameModel gameModel;
    private GameView gameView;
    public static final int RAND_MAX = 100;
     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     private String buf;

    GameController( GameModel model, GameView view){

        gameModel = model;
        gameView = view;

    }

    public void start(){

        gameView.outStartMessage();
        firstDimension();
        readInputNumber();

    }

    public void firstDimension() {

        gameModel.setMin(0);
        gameModel.setMax(100);
        gameModel.insertNumber();
        outDimensions();

    }

    public void readInputNumber(){

            try {
                buf = bufferedReader.readLine();
                numberSet(buf);
                checking();
            } catch (NumberFormatException | IOException e) {
                gameView.incorrectInput();
                gameModel.addAttempts(buf);
                readInputNumber();
            }

    }

    public void outDimensions(){

        gameView.printDimensions(gameModel.getMin(), gameModel.getMax());

    }

    public void checking(){

        if(!gameModel.checkCorrection()) {
            gameModel.addAttempts();
            gameView.outOfBound();
            readInputNumber();
        }
        else {
            if (!gameModel.checkEquality()) {
                gameModel.addAttempts();
                gameView.printContinue();
                gameModel.newDimensions();
                outDimensions();
                readInputNumber();
            }
            else {
                gameModel.addAttempts();
                gameView.printEnd(gameModel.getPlayerNumber());
                gameView.outOfAttempts(gameModel.getAttempts());
            }
        }

    }

    public void numberSet(String reader){

        gameModel.setPlayerNumber(Integer.parseInt(String.valueOf(reader)));

    }



}
