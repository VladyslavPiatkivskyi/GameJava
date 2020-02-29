package com.courses;


import com.courses.controller.GameController;
import com.courses.data.GameModel;
import com.courses.view.GameView;

public class Main {

    public static void main(String[] args) {

        GameModel gameModel = new GameModel();
        GameView gameView = new GameView();

        GameController gameController = new GameController(gameModel, gameView);
        gameController.start();


    }

}
