package com.cegepst;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    public static String readOption() {
        return validateOption().toUpperCase();
    }

    public static String readBinaryMessage() {
        return validateBinaryMessage();
    }

    public static String readTextMessage() {
        return validateTextMessage();
    }

    private static String validateOption() {
        Scanner reader = new Scanner(System.in);
        String option = reader.nextLine();
        if (!option.equalsIgnoreCase("ENCODE") && !option.equalsIgnoreCase("DECODE")) {
            do{
                Output.displayOptionError();
                option = reader.nextLine();
            } while(!option.equalsIgnoreCase("ENCODE") && !option.equalsIgnoreCase("DECODE"));
        }
        return option;
    }

    private static String validateBinaryMessage() {
        Scanner reader = new Scanner(System.in);
        String decodeMessage = reader.nextLine();
        boolean condition = (Pattern.matches("[a-zA-Z]+", decodeMessage) || !decodeMessage.contains("0") && !decodeMessage.contains("1"));
        if (condition) {
            do{
                Output.displayBinaryMessageError();
                decodeMessage = reader.nextLine();
            } while(condition);
        }
        return decodeMessage;
    }

    private static String validateTextMessage() {
        Scanner reader = new Scanner(System.in);
        String encodeMessage = reader.nextLine();
        if (encodeMessage.isEmpty()) {
            do{
                Output.displayTextMessageError();
                encodeMessage = reader.nextLine();
            } while((encodeMessage.isEmpty()));
        }
        return encodeMessage;
    }

}
