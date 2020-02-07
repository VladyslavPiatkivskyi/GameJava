package com.courses;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();

        GameController gameController = new GameController(gameModel, gameView);
        gameController.firstDimension();
        //System.out.println(gameModel.getNumber());
        gameController.readInputNumber();


    }

}
