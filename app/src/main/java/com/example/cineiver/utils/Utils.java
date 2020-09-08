package com.example.cineiver.utils;

public class Utils {
    public static String reduceString(String str){
        return str.length()>Constants.NUMBER_WORDS? str.substring(0,str.length()/(Constants.NUMBER_WORDS/4)).concat("...") : str;
    }
}
