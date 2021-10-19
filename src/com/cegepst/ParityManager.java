package com.cegepst;

import java.util.ArrayList;

public class ParityManager {

    private int position;

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
        }
        return "1";
    }

    public ArrayList<Byte> eraseParityBits(ArrayList<Byte> bytes) {
        for (int i = 0; i < bytes.size(); i++) {
            bytes.get(i).deleteParity(eraseParityBit(bytes.get(i).getBinaryValue()));
        }
        return bytes;
    }

    public String eraseParityBit(String binaryValue) {
        return binaryValue.substring(0, binaryValue.length() - 1);
    }

    public ArrayList<Byte> addParityLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> encodeBytes = new ArrayList<Byte>();
        if (bytes.size() <= 8) {
            return addParityLine(bytes);
        }
        encodeBytes = addCoreMessageParityLines(encodeBytes, bytes);
        if (bytes.size() % 8 > 0) {
            encodeBytes = addMessageLastParityLine(encodeBytes, bytes);
        }
        return encodeBytes;
    }

    private ArrayList<Byte> addCoreMessageParityLines(ArrayList<Byte> encodeBytes, ArrayList<Byte> bytes) {
        position = 0;
        for (int i = 0; i < bytes.size() / 8; i++) {
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

    private ArrayList<Byte> addMessageLastParityLine(ArrayList<Byte> encodeBytes, ArrayList<Byte> bytes) {
        ArrayList<Byte> tempoBytes = new ArrayList<Byte>();
        for (int i = 0; i < bytes.size() % 8; i++) {
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

    public ArrayList<Byte> eraseParityLines(ArrayList<Byte> bytes) {
        if (bytes.size() <= 9) {
            return eraseLastParityLine(bytes);
        }
        if (bytes.size() % 9 != 0) {
            bytes = eraseLastParityLine(bytes);
        }
        bytes = eraseCoreMessageParityLines(bytes);
        return bytes;
    }

    private ArrayList<Byte> eraseCoreMessageParityLines(ArrayList<Byte> bytes) {
        ArrayList<Byte> bytesToRemove = new ArrayList<>();
        for (int i = 1; i <= bytes.size() / 9; i++) {
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

    public String getDesiredByteParityBit(ArrayList<Byte> bytes, ParityManager parityManager, int index) {
        return parityManager.calculateParityBit(bytes.get(index).getBinaryValue().substring(0, bytes.get(index).getLength() - 1));
    }

    public String getCurrentByteParityBit(ArrayList<Byte> bytes, int index) {
        return bytes.get(index).getBinaryValue().substring(bytes.get(index).getLength() - 1);
    }

    public Boolean validateColParityBit(String currentByteCol, ParityManager parityManager) {
        String currentParityBitCalculated = parityManager.calculateParityBit(currentByteCol.substring(0, currentByteCol.length()-1));
        String neededParityBit = currentByteCol.substring(currentByteCol.length() - 1);
        return currentParityBitCalculated.equals(neededParityBit);
    }
}



