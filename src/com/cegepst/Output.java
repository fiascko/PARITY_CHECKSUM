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
        System.out.println("I did this for you. (The message is copied in your clipboard)");
        for(int i = 0; i < bytes.size(); i++) {
            System.out.print(bytes.get(i).getCharByte());
            encodeCopy += bytes.get(i).getCharByte();
        }
        copyToKeyboard(encodeCopy);
        System.out.println("\n");
    }

    public static void copyToKeyboard(String encodeCopy) {
        StringSelection stringSelection = new StringSelection(encodeCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
