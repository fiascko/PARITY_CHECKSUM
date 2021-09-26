package com.cegepst;

public class Output {

    public static void displayOptions() {
        System.out.print("You want me to 'encode' or to 'decode' a message?");
    }

    public static void displayOptionError() {
        System.out.println("Don't be a fool, you want to 'encode' or to 'decode' a message?");
    }

    public static void displayDecodeMessage() {
        System.out.println("Put some 0 and some 1 to 'decode' the message and discover what they hide.");
    }

    public static void displayEncodeMessage() {
        System.out.println("Write the message you want to 'encode'.");
    }

    public static void displayBinaryMessageError() {
        System.out.println("I need a binary message to 'decode'.");
    }

    public static void displayTextMessageError() {
        System.out.println("I need a text message to 'encode'.");
    }
}
