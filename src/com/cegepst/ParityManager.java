package com.cegepst;

import java.util.ArrayList;

public class ParityManager {

    public String calculateParityBit(String charByte) {
        int count = 0;
        for(int i = 0; i < charByte.length(); i++) {
            char bit = charByte.charAt(i);
            if (Character.getNumericValue(bit) == 1) {
                count++;
            }
        }
        if ((count % 2) == 0) {
            return "0";
        } else {
            return "1";
        }
    }

    public ArrayList<Byte> addParityLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> encodeBytes = new ArrayList<Byte>();
        if (bytes.size() <= 8) {
            encodeBytes = addParityLine(bytes);
            return encodeBytes;
        }
        int totalNumberOfByte = bytes.size() / 8;
        int numberOfByteRest = bytes.size() % 8;

        int position = 0;
        for (int i = 0; i < totalNumberOfByte; i++) {
            ArrayList<Byte> tempoBytes = new ArrayList<Byte>();
            for (int j = 0; j < 8; j++) {
                tempoBytes.add(bytes.get(position));
                position++;
            }
            tempoBytes = addParityLine(tempoBytes);
            encodeBytes.addAll(tempoBytes);
        }
        if (numberOfByteRest != 0) {
            ArrayList<Byte> tempoBytes = new ArrayList<Byte>();
            for (int i = 0; i <= numberOfByteRest; i++) {
                position++;
                tempoBytes.add(bytes.get(position));
            }
            tempoBytes = addParityLine(tempoBytes);
            encodeBytes.addAll(tempoBytes);
        }
        return encodeBytes;
    }

    public ArrayList<Byte> addParityLine(ArrayList<Byte> bytesArray) {
        String parityLine = "";
        for (int charIndex = 0; charIndex < 9; charIndex++) {
            String thisCol = "";
            for (int byteIndex = 0; byteIndex < bytesArray.size(); byteIndex++) {
                thisCol += bytesArray.get(byteIndex).getCharByte().charAt(charIndex);
            }
            parityLine += calculateParityBit(thisCol);
        }
        bytesArray.add(new Byte(parityLine));
        return bytesArray;
    }
}