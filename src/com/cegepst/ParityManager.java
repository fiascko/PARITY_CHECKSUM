package com.cegepst;

import java.util.ArrayList;

public class ParityManager {

    private int position = 0;

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

    public ArrayList<Byte> eraseParityBits(ArrayList<Byte> bytes) {
        for (int i = 0; i < bytes.size(); i++) {
            bytes.get(i).deleteParityBinaryValue(eraseParityBit(bytes.get(i).getBinaryValue()));
        }
        return bytes;
    }

    public String eraseParityBit(String binaryValue) {
        return binaryValue.substring(0, binaryValue.length() - 1);
    }

    public ArrayList<Byte> addParityLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> encodeBytes = new ArrayList<Byte>();
        int splitNumberOfByteRest = bytes.size() % 8;
        if (bytes.size() <= 8) {
            return addParityLine(bytes);
        }
        encodeBytes = addCoreMessageLines(encodeBytes, bytes);
        if (splitNumberOfByteRest > 0) {
            encodeBytes = addMessageLastLine(encodeBytes, bytes, splitNumberOfByteRest);
        }
        return encodeBytes;
    }

    public ArrayList<Byte> eraseParityLines(ArrayList<Byte> bytes) {
        int numberOfByteRest = bytes.size() % 9;
        if (bytes.size() <= 9) {
            return eraseLastParityLine(bytes);
        }
        bytes = eraseCoreMessageLines(bytes);
        if (numberOfByteRest > 0) {
            bytes = eraseLastParityLine(bytes);
        }
        return bytes;
    }

    private ArrayList<Byte> addCoreMessageLines(ArrayList<Byte> encodeBytes, ArrayList<Byte> bytes) {
        position = 0;
        int splitNumberOfByte = bytes.size() / 8;
        for (int i = 0; i < splitNumberOfByte; i++) {
            ArrayList<Byte> tempoBytes = new ArrayList<Byte>();
            for (int j = 0; j < 8; j++) {
                tempoBytes.add(bytes.get(position));
                position++;
            }
            tempoBytes = addParityLine(tempoBytes);
            encodeBytes.addAll(tempoBytes);
        }
        return encodeBytes;
    }

    private ArrayList<Byte> addMessageLastLine(ArrayList<Byte> encodeBytes, ArrayList<Byte> bytes, int splitNumberOfByteRest) {
        ArrayList<Byte> tempoBytes = new ArrayList<Byte>();
        for (int i = 0; i < splitNumberOfByteRest; i++) {
            tempoBytes.add(bytes.get(position));
            position++;
        }
        tempoBytes = addParityLine(tempoBytes);
        encodeBytes.addAll(tempoBytes);
        return encodeBytes;
    }

    private ArrayList<Byte> addParityLine(ArrayList<Byte> bytesArray) {
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

    private ArrayList<Byte> eraseCoreMessageLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> bytesToRemove = new ArrayList<>();
        int totalNumberOfByte = bytes.size() / 9;

        for (int i = 1; i <= totalNumberOfByte; i++) {
            bytesToRemove.add(bytes.get(i * 9 - 1));
        }
        for (Byte currentByte : bytesToRemove) {
            bytes.remove(currentByte);
        }
        return bytes;
    }

    private ArrayList<Byte> eraseLastParityLine(ArrayList<Byte> bytes) {
        bytes.remove(bytes.size() - 1);
        return bytes;
    }
}



