package com.cegepst;

public class Translator {

    public String convertMessageToBinary(String textMessage) {
        StringBuilder bitsStream = new StringBuilder();
        char[] chars = textMessage.toCharArray();
        for (char aChar : chars) {
            bitsStream.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        return bitsStream.toString();
    }

//    public String convertBinaryToMessage(String encodeMessage) {

//    }


}
