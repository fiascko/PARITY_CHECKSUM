package com.cegepst;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

public class Output {

    protected static void displayOptions() {
        System.out.println("You want me to 'encode', to 'decode' or to 'exit'?");
    }

    protected static void displayOptionError() {
        System.out.println("Don't be a fool, you want to 'encode', to 'decode' or to 'exit'?");
    }

    protected static void displayDecodeMessage() {
        System.out.println("Put some 0 and some 1 to 'decode' the message and discover what they hide.");
    }

    protected static void displayEncodeMessage() {
        System.out.println("Write the message you want to 'encode'.");
    }

    protected static void displayBinaryMessageError() {
        System.out.println("I need a binary message to 'decode'.");
    }

    protected static void displayTextMessageError() {
        System.out.println("I need a text message to 'encode'.");
    }

    protected static void displayEncodeResult(ArrayList<Byte> bytes) {
        String encodeCopy = "";
        System.out.println("I did this for you. (The message is copied to your keyboard)\n");
        for(int i = 0; i < bytes.size(); i++) {
            System.out.print(bytes.get(i).getBinaryValue());
            encodeCopy += bytes.get(i).getBinaryValue();
        }
        copyToKeyboard(encodeCopy);
        System.out.println("\n");
    }

    protected static void copyToKeyboard(String encodeCopy) {
        StringSelection encodeString = new StringSelection(encodeCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(encodeString, null);
    }

    protected static void displayDecodeResult(ArrayList<Character> bytes) {
        System.out.println("I did this for you.\n");
        for(int i = 0; i < bytes.size(); i++) {
            System.out.print(bytes.get(i));
        }
        System.out.println("\n");
    }
}
