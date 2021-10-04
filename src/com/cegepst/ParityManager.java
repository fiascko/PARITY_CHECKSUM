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
        if (numberOfByteRest > 0) {
            ArrayList<Byte> tempoBytes2 = new ArrayList<Byte>();
            for (int i = 0; i < numberOfByteRest; i++) {
                tempoBytes2.add(bytes.get(position));
                position++;
            }
            tempoBytes2 = addParityLine(tempoBytes2);
            encodeBytes.addAll(tempoBytes2);
        }
        return encodeBytes;
    }

    public ArrayList<Byte> eraseParityLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> decodeBytes = bytes;

        if (decodeBytes.size() <= 9) {
            decodeBytes.remove(decodeBytes.size() - 1);
            return decodeBytes;
        }

        int position = 0;
        int totalNumberOfByte = decodeBytes.size() / 9;
        int numberOfByteRest = decodeBytes.size() % 9;

        for (int i = 0; i < decodeBytes.size(); i++) {
            if (position % 9 == 0) {
                decodeBytes.remove(decodeBytes.get(position));
                position--;
            }
            position++;
        }
        if (numberOfByteRest > 0) {
            decodeBytes.remove(decodeBytes.size() - 1);
        }
        return decodeBytes;
    }

    public ArrayList<Byte> addParityLine(ArrayList<Byte> bytesArray) {
        String parityLine = "";
        for (int i = 0; i < 9; i++) {
            String thisCol = "";
            for (int j = 0; j < bytesArray.size(); j++) {
                thisCol += bytesArray.get(j).getCharByte().charAt(i);
            }
            parityLine += calculateParityBit(thisCol);
        }
        bytesArray.add(new Byte(parityLine));
        return bytesArray;
    }

    public ArrayList<Byte> eraseParityBits(ArrayList<Byte> bytes) {
        for (int i = 0; i < bytes.size(); i++ ) {
            bytes.get(i).deleteParityCharByte(eraseParityBit(bytes.get(i).getCharByte()));
        }
        return bytes;
    }

    public String eraseParityBit(String charByte) {
        return charByte.substring(0, charByte.length() - 1);
    }
}



