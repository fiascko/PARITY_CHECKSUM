package com.cegepst;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    public static final String DECODE = "DECODE";
    public static final String ENCODE = "ENCODE";
    public static final String EXIT = "EXIT";

    public static String readOption() {
        Scanner reader = new Scanner(System.in);
        String option = reader.nextLine();
        return validateOption(reader, option).toUpperCase();
    }

    public static String readBinaryMessage() {
        Scanner reader = new Scanner(System.in);
        String decodeMessage = reader.nextLine();
        return validateBinaryMessage(reader, decodeMessage);
    }

    public static String readTextMessage() {
        Scanner reader = new Scanner(System.in);
        String encodeMessage = reader.nextLine();
        return validateTextMessage(reader, encodeMessage);
    }

    public static String validateOption(Scanner reader, String option) {
        if (!option.equalsIgnoreCase(ENCODE) && !option.equalsIgnoreCase(DECODE) && !option.equalsIgnoreCase(EXIT)) {
            do{
                Output.displayOptionError();
                option = reader.nextLine();
            } while(!option.equalsIgnoreCase(ENCODE) && !option.equalsIgnoreCase(DECODE) && !option.equalsIgnoreCase(EXIT));
        }
        return option;
    }

    public static String validateBinaryMessage(Scanner reader, String decodeMessage) {
        if (!Pattern.matches("[0-1]+", decodeMessage) || decodeMessage.length() % 9 != 0) {
            do{
                Output.displayBinaryMessageError();
                decodeMessage = reader.nextLine();
            } while(!Pattern.matches("[0-1]+", decodeMessage) || decodeMessage.length() % 9 != 0);
        }
        return decodeMessage;
    }

    public static String validateTextMessage(Scanner reader, String encodeMessage) {
        if (encodeMessage.isEmpty() || Pattern.matches("[0-1]+", encodeMessage)) {
            do{
                Output.displayTextMessageError();
                encodeMessage = reader.nextLine();
            } while(encodeMessage.isEmpty() || Pattern.matches("[0-1]+", encodeMessage));
        }
        return encodeMessage;
    }
}
