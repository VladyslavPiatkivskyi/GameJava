package com.courses.view;

import com.courses.helper.BundleHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameView {

    public static String separator = "\n-----------------------------------------------------------------------------------------";

    public void printMessage(String message){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }

    public void printMessage(String message, int number){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message + number);
    }

    public void printMessage(String message, int min, int max){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message + min + " - " + max + " : ");
    }

    public void outOfAttempts(List<String> attempts, String message){
        System.out.println(message);
        for(String attemp : attempts)
            System.out.print(" " + attemp + ", ");

    }

    public ResourceBundle chooseLanguage(ResourceBundle bundle, int language){

        switch (language){
            case (1):
                return BundleHelper.setBundleEnglish();
            case (2):
                return BundleHelper.setBundleUkrainian();
            case (3):
                return BundleHelper.setBundleRussian();
            default:
                return bundle;
        }

    }





}
