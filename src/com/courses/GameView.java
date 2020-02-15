package com.courses;

import java.util.ArrayList;
import java.util.List;

public class GameView {

    public String languageMessage = " Please, select language / Оберіть мову, будь ласка / Пожалуйста, выберите язык :\n 1 - English\n 2 - Українська\n 3 - Русский";
    public String incorrectInput = " Incorrect input! Input numbers 1, 2 or 3...";
    public String separator = "-----------------------------------------------------------------------------------------";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessage(String message, int number){
        System.out.println(message + number);
    }

    public void printMessage(String message, int min, int max){
        System.out.println(message + min + " - " + max + " : ");
    }

    public void outOfAttempts(List<String> attempts, String message){
        System.out.println(message);
        for(String attemp : attempts)
            System.out.print(" " + attemp + ", ");

    }





}
