package com.cegepst;

import java.util.ArrayList;

public class Detector {

    private int detectIndex = 0;

    public Boolean detectError(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            return detectShortMessage(bytes, parityManager);
        } else {
            if (detectCoreMessage(bytes, parityManager)) {
                return true;
            }
            if (bytes.size() % 9 > 0) {
                return detectEndMessage(bytes, parityManager);
            }
        }
        return false;
    }

    private boolean detectShortMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int count = 0;
        for (int i = 0; i < bytes.size(); i++) {
            String desiredByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, i);
            if (!desiredByteParityBit.equals(parityManager.getCurrentByteParityBit(bytes, i))) {
                count++;
                if (count == 2) {
                    return true;
                }
            }
        }
        return detectShortMessageByte(bytes, parityManager);
    }

    private boolean detectShortMessageByte(ArrayList<Byte> bytes, ParityManager parityManager) {
        int count = 0;
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = 0; j < bytes.size(); j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCoreMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        for (int i = 0; i < bytes.size() / 9; i++) {
            if (detectIndex != 0) {
                detectIndex++;
            }
            int count = 0;
            for (int j = 0; j < 8; j++) {
                String currentByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
                if (!currentByteParityBit.equals(parityManager.getCurrentByteParityBit(bytes, detectIndex))) {
                    count++;
                    if (count > 1) {
                        return true;
                    }
                }
                detectIndex++;
            }
            if (detectCoreMessageByte(bytes, parityManager)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCoreMessageByte(ArrayList<Byte> bytes, ParityManager parityManager) {
        int count = 0;
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = detectIndex - 8; j <= detectIndex; j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectEndMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int count = 0;
        int start = detectIndex;
        for (int j = detectIndex; j < bytes.size() - 1; j++) {
            String currentByteparityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
            if (!currentByteparityBit.equals(parityManager.getCurrentByteParityBit(bytes, detectIndex))) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
            detectIndex++;
        }
        return detectEndMessageByte(bytes, parityManager, start);
    }

    private boolean detectEndMessageByte(ArrayList<Byte> bytes, ParityManager parityManager, int start) {
        int count = 0;
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = start + 1; j < bytes.size(); j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
