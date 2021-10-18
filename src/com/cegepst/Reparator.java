package com.cegepst;

import java.util.ArrayList;

public class Reparator {

    private int detectIndex = 0;

    public ArrayList<Byte> repair(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            bytes = repairShortMessage(bytes, parityManager);
        } else {
            bytes = repairCoreMessage(bytes, parityManager);
            if (bytes.size() % 9 > 0) {
                bytes = repairEndMessage(bytes, parityManager);
            }
        }
        return bytes;
    }

    private ArrayList<Byte> repairShortMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int errorByte  = 0;
        boolean errorFind = false;
        for (int i = 0; i < bytes.size() - 1; i++) {
            String desiredByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
            if (!desiredByteParityBit.equals(parityManager.getCurrentParityBit(bytes, detectIndex))) {
                errorByte = detectIndex;
                errorFind = true;
            }
        }
        if (errorFind) {
            for (int i = 0; i < 8; i++ ) {
                String currentByteCol = "";
                for (int j = 0; j < bytes.size(); j++) {
                    currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
                }
                int errorChar = i;
                if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                    bytes.get(errorByte).toggleChar(errorChar);
                    break;
                }
            }
        }
        return bytes;
    }

    private ArrayList<Byte> repairCoreMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        for (int z = 0; z < bytes.size() / 9; z++) {
            if (detectIndex != 0) {
                detectIndex++;
            }
            for (int o = 0; o < 8; o++) {
                String desiredByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
                if (!desiredByteParityBit.equals(parityManager.getCurrentParityBit(bytes, detectIndex))) {
                    int errorByte = detectIndex;
                    for (int i = 0; i < 8; i++ ) {
                        String currentByteCol = "";
                        for (int j = 0; j < 9; j++) {
                            currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
                        }
                        int errorChar = i;
                        if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                            bytes.get(errorByte).toggleChar(errorChar);
                        }
                    }
                }
                detectIndex++;
            }
        }
        return bytes;
    }

    private ArrayList<Byte> repairEndMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        return bytes;
    }
}
