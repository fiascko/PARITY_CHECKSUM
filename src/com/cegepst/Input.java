package com.cegepst;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    private static final String DECODE = "DECODE";
    private static final String ENCODE = "ENCODE";
    private static final String EXIT = "EXIT";

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
        if (!option.equalsIgnoreCase(ENCODE) && !option.equalsIgnoreCase(DECODE) && !option.equalsIgnoreCase(EXIT)) {
            do{
                Output.displayOptionError();
                option = reader.nextLine();
            } while(!option.equalsIgnoreCase(ENCODE) && !option.equalsIgnoreCase(DECODE) && !option.equalsIgnoreCase(EXIT));
        }
        return option;
    }

    private static String validateBinaryMessage() {
        Scanner reader = new Scanner(System.in);
        String decodeMessage = reader.nextLine();
        if (!Pattern.matches("[0-1]+", decodeMessage) || decodeMessage.length() < 9) {
            do{
                Output.displayBinaryMessageError();
                decodeMessage = reader.nextLine();
            } while(!Pattern.matches("[0-1]+", decodeMessage) || decodeMessage.length() < 9);
        }
        return decodeMessage;
    }

    private static String validateTextMessage() {
        Scanner reader = new Scanner(System.in);
        String encodeMessage = reader.nextLine();
        if (encodeMessage.isEmpty() || Pattern.matches("[0-1]+", encodeMessage)) {
            do{
                Output.displayTextMessageError();
                encodeMessage = reader.nextLine();
            } while(encodeMessage.isEmpty() || Pattern.matches("[0-1]+", encodeMessage));
        }
        return encodeMessage;
    }
}
