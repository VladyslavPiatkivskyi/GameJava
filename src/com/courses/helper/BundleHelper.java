package com.courses.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleHelper {

    private static ResourceBundle bundle = ResourceBundle.getBundle("messages");

    public static ResourceBundle getBundle() {
            return bundle;
        }

    public static ResourceBundle setBundleEnglish() {
        return ResourceBundle.getBundle("messages", new Locale("en", "US"));
    }

    public static ResourceBundle setBundleUkrainian() {
        return ResourceBundle.getBundle("messages", new Locale("ua", "UA"));
    }

    public static ResourceBundle setBundleRussian() {
        return ResourceBundle.getBundle("messages", new Locale("ru", "RU"));
    }
}
