package com.cegepst;

import java.util.ArrayList;

public class Reparator {

    int position = 0;
    boolean detect = true;

    public Boolean detectError(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            detect = detectShortMessage(bytes, parityManager);
        }
        detect = detectCoreMessage(bytes, parityManager);
        int numberOfByteRest = bytes.size() % 9;
        if (numberOfByteRest > 0) {
            detect = detectLastMessage(bytes, parityManager);
        }
        return detect;
    }

    private boolean detectShortMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int cpt = 0;
        for (Byte currentByte : bytes) {
            String currentByteparityBit = parityManager.calculateParityBit(currentByte.getBinaryValue().substring(0, currentByte.getBinaryValue().length() - 1));
            if (!currentByteparityBit.equals(currentByte.getBinaryValue().substring(currentByte.getBinaryValue().length() - 1))) {
                cpt++;
                if (cpt == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean detectCoreMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int splitNumberOfByte = bytes.size() / 9;
        int cpt = 0;
        for (int i = 0; i < splitNumberOfByte; i++) {
            cpt = 0;
            for (int j = 0; j < 8; j++) {
                String currentByteparityBit = parityManager.calculateParityBit(bytes.get(position).getBinaryValue().substring(0, bytes.get(position).getBinaryValue().length() - 1));
                if (!currentByteparityBit.equals(bytes.get(position).getBinaryValue().substring(bytes.get(position).getBinaryValue().length() - 1))) {
                    cpt++;
                    if (cpt == 2) {
                        return false;
                    }
                }
                position++;
            }
        }
        return true;
    }

    private boolean detectLastMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        int cpt = 0;
        for (int j = position; j < bytes.size() - 1; j++) {
            String currentByteparityBit = parityManager.calculateParityBit(bytes.get(position).getBinaryValue().substring(0, bytes.get(position).getBinaryValue().length() - 1));
            if (!currentByteparityBit.equals(bytes.get(position).getBinaryValue().substring(bytes.get(position).getBinaryValue().length() - 1))) {
                cpt++;
                if (cpt == 2) {
                    return false;
                }
            }
            position++;
        }
        return true;
    }
}
//    private void repareError() {
//
//    }



