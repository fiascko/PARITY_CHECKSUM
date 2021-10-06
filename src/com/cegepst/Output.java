package com.cegepst;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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
        System.out.println("I need a respectful encoding binary message to 'decode'.");
    }

    public static void displayTextMessageError() {
        System.out.println("I need a text message to 'encode'.");
    }

    public static void displayEncodeResult(String encodeMessage) {
        System.out.println("I encoded this for you. (The message is copied to your keyboard)\n");
        copyToKeyboard(encodeMessage);
        System.out.println(encodeMessage + "\n");
    }

    private static void copyToKeyboard(String encodeCopy) {
        StringSelection encodeString = new StringSelection(encodeCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(encodeString, null);
    }

    public static void displayDecodeResult(String decodeMessage) {
        System.out.println("I decoded this message for you. (The message is copied to your keyboard)\n");
        System.out.println(decodeMessage+ "\n");
    }
}
