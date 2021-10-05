package com.cegepst;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {

    protected static final String DECODE = "DECODE";
    protected static final String ENCODE = "ENCODE";
    protected static final String EXIT = "EXIT";

    protected static String readOption() {
        Scanner reader = new Scanner(System.in);
        String option = reader.nextLine();
        return validateOption(reader, option).toUpperCase();
    }

    protected static String readBinaryMessage() {
        Scanner reader = new Scanner(System.in);
        String decodeMessage = reader.nextLine();
        return validateBinaryMessage(reader, decodeMessage);
    }

    protected static String readTextMessage() {
        Scanner reader = new Scanner(System.in);
        String encodeMessage = reader.nextLine();
        return validateTextMessage(reader, encodeMessage);
    }

    protected static String validateOption(Scanner reader, String option) {
        if (!option.equalsIgnoreCase(ENCODE) && !option.equalsIgnoreCase(DECODE) && !option.equalsIgnoreCase(EXIT)) {
            do{
                Output.displayOptionError();
                option = reader.nextLine();
            } while(!option.equalsIgnoreCase(ENCODE) && !option.equalsIgnoreCase(DECODE) && !option.equalsIgnoreCase(EXIT));
        }
        return option;
    }

    protected static String validateBinaryMessage(Scanner reader, String decodeMessage) {
        if (!Pattern.matches("[0-1]+", decodeMessage) || decodeMessage.length() < 9) {
            do{
                Output.displayBinaryMessageError();
                decodeMessage = reader.nextLine();
            } while(!Pattern.matches("[0-1]+", decodeMessage) || decodeMessage.length() < 9);
        }
        return decodeMessage;
    }

    protected static String validateTextMessage(Scanner reader, String encodeMessage) {
        if (encodeMessage.isEmpty() || Pattern.matches("[0-1]+", encodeMessage)) {
            do{
                Output.displayTextMessageError();
                encodeMessage = reader.nextLine();
            } while(encodeMessage.isEmpty() || Pattern.matches("[0-1]+", encodeMessage));
        }
        return encodeMessage;
    }
}
