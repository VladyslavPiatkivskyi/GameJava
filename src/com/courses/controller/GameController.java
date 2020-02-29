package com.courses.controller;

import com.courses.helper.BundleHelper;
import com.courses.view.GameView;
import com.courses.data.GameModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class GameController {

    private GameModel gameModel;
    private GameView gameView;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ResourceBundle bundle = BundleHelper.getBundle();
    private String buf;

    public GameController(GameModel model, GameView view){

        gameModel = model;
        gameView = view;

    }

    public void start(){

        selectLocale();
        gameView.printMessage(gameView.separator);
        gameView.printMessage(bundle.getString("startMessage"));
        firstDimension();
        readInputNumber();

    }

    public void selectLocale()  {

        gameView.printMessage(bundle.getString("languageMessage"));
        int lan = 0;

        try {
            lan = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            gameView.printMessage(bundle.getString("incorrectInput"));
            selectLocale();
        }
        bundle = gameView.chooseLanguage(bundle, lan);
        gameView.printMessage(bundle.getString("selectedLanguage"));

    }

    public void firstDimension() {
        setNumbers();
        outDimensions();
    }

    public void readInputNumber(){

            try {
                buf = bufferedReader.readLine();
                numberSet(buf);
                checking();
            } catch (NumberFormatException | IOException e) {
                gameView.printMessage(bundle.getString("incorrectInput"));
                gameModel.addAttempts(buf);
                outDimensions();
                readInputNumber();
            }

    }

    public void outDimensions(){
        gameView.printMessage(bundle.getString("dimensions"), gameModel.getMin(), gameModel.getMax());
    }

    public void checking(){

        if(!checkCorrection()) {
            gameModel.addAttempts();
            gameView.printMessage(bundle.getString("outOfBound"));
            outDimensions();
            readInputNumber();
        }
        else {
            if (!checkEquality()) {
                gameModel.addAttempts();
                gameView.printMessage(bundle.getString("notGuess"));
                newDimensions();
                outDimensions();
                readInputNumber();
            }
            else {
                gameModel.addAttempts();
                gameView.printMessage(bundle.getString("guess"), gameModel.getPlayerNumber());
                gameView.outOfAttempts(gameModel.getAttempts(), bundle.getString("attempts"));
            }
        }

    }

    public void setNumbers() {
        gameModel.setMin(0);
        gameModel.setMax(100);
        gameModel.setNumber(rand(gameModel.getMin(),gameModel.getMax()));
    }

    public int rand(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }


    public boolean checkCorrection(){
        if(gameModel.getPlayerNumber() > gameModel.getMax() || gameModel.getPlayerNumber() < gameModel.getMin()) {
            return false;
        }
        else
            return true;
    }

    public boolean checkEquality(){
        if(gameModel.getPlayerNumber() == gameModel.getNumber()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void newDimensions(){
        if(gameModel.getPlayerNumber() > gameModel.getNumber())
            gameModel.setMax(gameModel.getPlayerNumber());
        else
            gameModel.setMin(gameModel.getPlayerNumber());
    }

    public void numberSet(String reader){
        gameModel.setPlayerNumber(Integer.parseInt(String.valueOf(reader)));
    }
}
