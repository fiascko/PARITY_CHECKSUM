package com.cegepst;

import java.util.ArrayList;

public class Detector {

    private int detectIndex = 0;

    public Boolean detectError(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            if (detectShortMessage(bytes, parityManager)) {
                return true;
            }
        } else {
            if (detectCoreMessage(bytes, parityManager)) {
                return true;
            }
            if (bytes.size() % 9 > 0) {
                if (detectMessageEnd(bytes, parityManager)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectShortMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int counter = 0;
        for (int i = 0; i < bytes.size(); i++) {
            String desiredByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, i);
            if (!desiredByteParityBit.equals(parityManager.getCurrentParityBit(bytes, i))) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            }
        }
        return detectShortMessageByte(bytes, parityManager);
    }

    private boolean detectShortMessageByte(ArrayList<Byte> bytes, ParityManager parityManager) {
        int counter = 0;
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = 0; j < bytes.size(); j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                counter++;
                if (counter > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectCoreMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        for (int i = 0; i < bytes.size() / 9; i++) {
            if (detectIndex != 0) { // ???
                detectIndex++; //
            }//
            int counter = 0;
            for (int j = 0; j < 8; j++) {
                String currentByteParityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
                if (!currentByteParityBit.equals(parityManager.getCurrentParityBit(bytes, detectIndex))) {
                    counter++;
                    if (counter == 2) {
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
        int counter = 0;
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = detectIndex - 8; j <= detectIndex; j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                counter++;
                if (counter > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectMessageEnd(ArrayList<Byte> bytes, ParityManager parityManager) {
        int counter = 0;
        int start = detectIndex;
        for (int j = detectIndex; j < bytes.size() - 1; j++) {
            String currentByteparityBit = parityManager.getDesiredByteParityBit(bytes, parityManager, detectIndex);
            if (!currentByteparityBit.equals(parityManager.getCurrentParityBit(bytes, detectIndex))) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            }
            detectIndex++;
        }
        return detectEndMessageByte(bytes, parityManager, start);
    }

    private boolean detectEndMessageByte(ArrayList<Byte> bytes, ParityManager parityManager, int start) {
        int counter = 0;
        for (int i = 0; i < 9; i++ ) {
            String currentByteCol = "";
            for (int j = start + 1; j < bytes.size(); j++) {
                currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
            }
            if (!parityManager.validateColParityBit(currentByteCol, parityManager)) {
                counter++;
                if (counter > 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
