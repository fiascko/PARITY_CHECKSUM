package com.cegepst;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

public class Output {

    public static void displayOptions() {
        System.out.println("You want me to 'encode', to 'decode' or to 'exit'?");
    }

    public static void displayOptionError() {
        System.out.println("Don't be a fool, you want to 'encode', to 'decode' or to 'exit'?");
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
        String encodeCopy = "";
        System.out.println("I did this for you. (The message is copied to your keyboard)\n");
        for(int i = 0; i < bytes.size(); i++) {
            System.out.print(bytes.get(i).getBinaryValue());
            encodeCopy += bytes.get(i).getBinaryValue();
        }
        copyToKeyboard(encodeCopy);
        System.out.println("\n");
    }

    public static void copyToKeyboard(String encodeCopy) {
        StringSelection encodeString = new StringSelection(encodeCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(encodeString, null);
    }

    public static void displayDecodeResult(ArrayList<Character> bytes) {
        System.out.println("I did this for you.\n");
        for(int i = 0; i < bytes.size(); i++) {
            System.out.print(bytes.get(i));
        }
        System.out.println("\n");
    }
}
