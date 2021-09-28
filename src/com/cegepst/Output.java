package com.cegepst;

import java.util.ArrayList;

public class Output {

    public static void displayOptions() {
        System.out.println("You want me to 'encode' or to 'decode' a message?");
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

    public static void displayEncodeResult(ArrayList<Byte> bytes) {
        System.out.println("I did this for you.");
        for(int i = 0; i < bytes.size(); i++) {
            System.out.print(bytes.get(i).getCharByte());
        }
    }
}
