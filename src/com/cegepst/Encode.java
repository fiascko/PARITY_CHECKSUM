package com.cegepst;

import java.util.ArrayList;

public class Encode {

    private String binaryMessage;
//    private ArrayList<BinaryLine> binaryLines;

    public Encode(String textMessage) {
        binaryMessage = convertToBinary(textMessage);
//        System.out.println(binaryMessage);

//        createBlockList(binaryString);
//        addparity();
//        systemoutString;
    }

    private String convertToBinary(String textMessage) {
        StringBuilder bitsStream = new StringBuilder();
        char[] chars = textMessage.toCharArray();
        for (char aChar : chars) {
            bitsStream.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        return bitsStream.toString();
    }
//
//    private void createBlockList(String binaryString) {
//
//        binaryString.split()
//
//    }

}
