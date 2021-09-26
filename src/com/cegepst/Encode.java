package com.cegepst;

import java.util.ArrayList;

public class Encode {

    private String binaryString;

    public Encode(String textMessage) {
        binaryString = transform(textMessage);
        System.out.println(binaryString);
    }

    private String transform(String textMessage) {
        StringBuilder result = new StringBuilder();
        char[] chars = textMessage.toCharArray();
        for (char aChar : chars) {
            result.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();
    }

}
