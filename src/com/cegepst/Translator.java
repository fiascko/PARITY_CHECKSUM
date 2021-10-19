package com.cegepst;

import java.util.ArrayList;

public class Translator {

    public String convertMessageToBinary(String textMessage) {
        StringBuilder bitsStream = new StringBuilder();
        char[] chars = textMessage.toCharArray();
        for (char aChar : chars) {
            bitsStream.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        return bitsStream.toString();
    }

    public ArrayList<Character> convertBytesToCharacters(ArrayList<Byte> bytes, ArrayList<Character> decodeMessage) {
        for (int i = 0; i < bytes.size(); i++) {
            decodeMessage.add(bytes.get(i).getChar());
        }
        return decodeMessage;
    }
}
