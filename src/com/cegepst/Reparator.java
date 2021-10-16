package com.cegepst;

import java.util.ArrayList;

public class Reparator {

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
            String desiredByteParityBit = getDesiredByteParityBit(bytes, parityManager, i);
            if (!desiredByteParityBit.equals(getCurrentParityBit(bytes, i))) {
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
            if (!validColParityBit(currentByteCol, parityManager)) {
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
                String currentByteParityBit = getDesiredByteParityBit(bytes, parityManager, detectIndex);
                if (!currentByteParityBit.equals(getCurrentParityBit(bytes, detectIndex))) {
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
            if (!validColParityBit(currentByteCol, parityManager)) {
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
            String currentByteparityBit = getDesiredByteParityBit(bytes, parityManager, detectIndex);
            if (!currentByteparityBit.equals(getCurrentParityBit(bytes, detectIndex))) {
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
            if (!validColParityBit(currentByteCol, parityManager)) {
                counter++;
                if (counter > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Byte> repair(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            bytes = repairShortMessage(bytes, parityManager);
        }
//        repairCore
//        repairEnd
        return bytes;
    }

    private ArrayList<Byte> repairShortMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int errorByte  = 0;
        boolean detect = false;
        for (int i = 0; i < bytes.size() - 1; i++) {
            String desiredByteParityBit = getDesiredByteParityBit(bytes, parityManager, i);
            if (!desiredByteParityBit.equals(getCurrentParityBit(bytes, i))) {
                errorByte = i;
                detect = true;
            }
        }
        if (detect) {
            for (int i = 0; i < 8; i++ ) {
                String currentByteCol = "";
                for (int j = 0; j < bytes.size(); j++) {
                    currentByteCol += bytes.get(j).getBinaryValue().charAt(i);
                }
                int errorChar = i;
                if (!validColParityBit(currentByteCol, parityManager)) {
                    bytes.get(errorByte).toggleChar(errorChar);
                    break;
                }
            }
        }
        return bytes;
    }

    private String getDesiredByteParityBit(ArrayList<Byte> bytes, ParityManager parityManager, int i) {
        return parityManager.calculateParityBit(bytes.get(i).getBinaryValue().substring(0, bytes.get(i).getByteLength() - 1));
    } // return le parity bit de les 8 premier

    private String getCurrentParityBit(ArrayList<Byte> bytes, int i) {
        return bytes.get(i).getBinaryValue().substring(bytes.get(i).getByteLength() - 1);
    } // return ce qui est presentement

    private Boolean validColParityBit(String currentByteCol, ParityManager parityManager) {
        String currentParityBitCalculated = parityManager.calculateParityBit(currentByteCol.substring(0, currentByteCol.length()-1)); //calcule le parity bit de la colone
        String neededParityBit = currentByteCol.substring(currentByteCol.length() - 1);
        return currentParityBitCalculated.equals(neededParityBit);
    } //valid si est bon
}
