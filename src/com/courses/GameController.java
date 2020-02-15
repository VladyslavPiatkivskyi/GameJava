package com.courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class GameController {

    private GameModel gameModel;
    private GameView gameView;
    public static final int RAND_MAX = 100;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ResourceBundle bundle;
    private String buf;

    GameController( GameModel model, GameView view){

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

        gameView.printMessage(gameView.languageMessage);
        int lan = 0;

        try {
            lan = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            gameView.printMessage(gameView.incorrectInput);
            selectLocale();
        }
        switch (lan){
            case 1:
                bundle = ResourceBundle.getBundle("messages");
                gameView.printMessage(bundle.getString("selectedLanguage"));
                break;
            case 2:
                bundle = ResourceBundle.getBundle("messages", new Locale("ua"));
                gameView.printMessage(bundle.getString("selectedLanguage"));
                break;

            case 3:
                bundle = ResourceBundle.getBundle("messages", new Locale("ru"));
                gameView.printMessage(bundle.getString("selectedLanguage"));
                break;

            default:
                bundle = ResourceBundle.getBundle("messages");
                gameView.printMessage(bundle.getString("defaultLanguage"));
                break;
        }

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
                gameView.printMessage(bundle.getString("incorrectInput"));
                gameModel.addAttempts(buf);
                readInputNumber();
            }

    }

    public void outDimensions(){
        gameView.printMessage(bundle.getString("dimensions"), gameModel.getMin(), gameModel.getMax());;
    }

    public void checking(){

        if(!gameModel.checkCorrection()) {
            gameModel.addAttempts();
            gameView.printMessage(bundle.getString("outOfBound"));
            readInputNumber();
        }
        else {
            if (!gameModel.checkEquality()) {
                gameModel.addAttempts();
                gameView.printMessage(bundle.getString("notGuess"));
                gameModel.newDimensions();
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

    public void numberSet(String reader){
        gameModel.setPlayerNumber(Integer.parseInt(String.valueOf(reader)));
    }



}
