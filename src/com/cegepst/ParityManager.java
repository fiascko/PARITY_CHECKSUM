package com.cegepst;

import java.util.ArrayList;

public class ParityManager {

    public String calculateParityBit(String binaryValue) {
        int count = 0;
        for (int i = 0; i < binaryValue.length(); i++) {
            char bit = binaryValue.charAt(i);
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

        //une choses
        if (bytes.size() <= 8) {
            encodeBytes = addParityLine(bytes);
            return encodeBytes;
        }

        //deux choses
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

        //trois choses
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

    public ArrayList<Byte> addParityLine(ArrayList<Byte> bytesArray) {
        String parityLine = "";
        for (int i = 0; i < 9; i++) {
            String currentByteCol = "";
            for (int j = 0; j < bytesArray.size(); j++) {
                currentByteCol += bytesArray.get(j).getBinaryValue().charAt(i);
            }
            parityLine += calculateParityBit(currentByteCol);
        }
        bytesArray.add(new Byte(parityLine));
        return bytesArray;
    }

    public ArrayList<Byte> eraseParityLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> decodeBytes = bytes;
        ArrayList<Byte> decodeBytesToRemove = new ArrayList<>();

        //une chose
        if (decodeBytes.size() <= 9) {
            decodeBytes.remove(decodeBytes.size() - 1);
            return decodeBytes;
        }

        //deux choses
        int totalNumberOfByte = decodeBytes.size() / 9;
        int numberOfByteRest = decodeBytes.size() % 9;
        for (int i = 1; i <= totalNumberOfByte; i++) {
            decodeBytesToRemove.add(decodeBytes.get(i * 9 - 1));
        }
        for (Byte currentByte : decodeBytesToRemove) {
            decodeBytes.remove(currentByte);
        }

        //trois choses
        if (numberOfByteRest > 0) {
            decodeBytes.remove(decodeBytes.size() - 1);
        }
        return decodeBytes;
    }

    public ArrayList<Byte> eraseParityBits(ArrayList<Byte> bytes) {
        for (int i = 0; i < bytes.size(); i++) {
            bytes.get(i).deleteParityBinaryValue(eraseParityBit(bytes.get(i).getBinaryValue()));
        }
        return bytes;
    }

    public String eraseParityBit(String binaryValue) {
        return binaryValue.substring(0, binaryValue.length() - 1);
    }
}



