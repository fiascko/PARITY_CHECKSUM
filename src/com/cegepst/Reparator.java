package com.cegepst;

import java.util.ArrayList;

public class Reparator {

    private int detectIndex = 0;

    public ArrayList<Byte> repair(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            return repairEndMessage(bytes, parityManager);
        }
        for (int i = 0; i < bytes.size() / 9; i++) {
            bytes = repairCoreMessage(bytes, parityManager);
        }
        if (bytes.size() % 9 > 0) {
            return repairEndMessage(bytes, parityManager);
        }
        return bytes;
    }

    private ArrayList<Byte> repairCoreMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int errorIndex = 0;
        boolean errorDetect = false;
            for (int j = 0; j < 9; j++) {
                String desiredByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
                if (!desiredByteParityBit.equals(parityManager.getCurrentByteParityBit(bytes, detectIndex))) {
                    errorDetect = true;
                    errorIndex = detectIndex;
                }
                detectIndex++;
            }
            if (errorDetect) {
                bytes = repairErrorCore(bytes, parityManager, detectIndex, errorIndex);
            }
        return bytes;
    }

    private ArrayList<Byte> repairErrorCore(ArrayList<Byte> bytes, ParityManager parityManager, int errorIndex, int error) {
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = errorIndex - 9; j < errorIndex; j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                bytes.get(error).toggleChar(i);
            }
        }
        return bytes;
    }

    private ArrayList<Byte> repairEndMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        for (int i = detectIndex; i < bytes.size() - 1; i++) {
            String desiredByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
            if (!desiredByteParityBit.equals(parityManager.getCurrentByteParityBit(bytes, detectIndex))) {
                return repairErrorEnd(bytes, parityManager, detectIndex);
            }
            detectIndex++;
        }
        return bytes;
    }

    private ArrayList<Byte> repairErrorEnd(ArrayList<Byte> bytes, ParityManager parityManager, int errorIndex) {
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = 0; j < bytes.size(); j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                bytes.get(errorIndex).toggleChar(i);
            }
        }
        return bytes;
    }
}
