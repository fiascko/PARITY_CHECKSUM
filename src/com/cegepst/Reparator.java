package com.cegepst;

import java.util.ArrayList;

public class Reparator {

    private int detectIndex = 0;

    public Boolean detectError(ArrayList<Byte> bytes, ParityManager parityManager) {
        if (bytes.size() <= 9) {
            if (detectShortMessage(bytes, parityManager)) {
                return true;
            }
        }
        if (detectCoreMessage(bytes, parityManager)) {
            return true;
        }
        if (bytes.size() % 9 > 0) {
            if (detectMessageEnd(bytes, parityManager)) {
                return true;
            }
        }
//        if(detectByte(bytes, parityManager)) { //savoir si 2 dans le meme byte on changer
//            return = true;
//        }
        return false;
    }

//    private boolean detectByte(ArrayList<Byte> bytes, ParityManager parityManager) {
//        for (int i = 0; i < bytes.size(); i++) {
//
//        }
//    }

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
        return false;
    }

    private boolean detectCoreMessage(ArrayList<Byte> bytes, ParityManager parityManager) {
        for (int i = 0; i < bytes.size() / 9; i++) {
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
        }
        return false;
    }

    private boolean detectMessageEnd(ArrayList<Byte> bytes, ParityManager parityManager) {
        int counter = 0;
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
        return false;
    }




//    public ArrayList<Byte> repair(ArrayList<Byte> bytes, ParityManager parityManager) {
//        if (bytes.size() <= 9) { //ok
//            for (int i = 0; i < bytes.size() - 1; i++) {//ok
//                int position = 0; //
//                String CalculateCurrentByteParityBit = getCalculateCurrentParityBit(bytes, parityManager, i);
//                if (!CalculateCurrentByteParityBit.equals(getCurrentParityBit(bytes, i))) {
//                    String currentByteCol = "";//ok
//                    for (int j = 0; j < bytes.size() - 1; j++) { //ok
//                        currentByteCol += bytes.get(j).getBinaryValue().charAt(i);//ok
//                    }
//                    if (!getCalculateColParityBit(currentByteCol, parityManager, bytes, position)) {
//                        bytes.get(position).toggleChar(i); // ICI ????
//                        return bytes;
//                    }
//                    position++;
//                }
//            }
//        }
//        return bytes;
//    }

    private String getDesiredByteParityBit(ArrayList<Byte> bytes, ParityManager parityManager, int i) {
        return parityManager.calculateParityBit(bytes.get(i).getBinaryValue().substring(0, bytes.get(i).getByteLength() - 1));
    }

    private String getCurrentParityBit(ArrayList<Byte> bytes, int i) {
        return bytes.get(i).getBinaryValue().substring(bytes.get(i).getByteLength() - 1);
    }

    private Boolean validColParityBit(String currentByteCol, ParityManager parityManager, ArrayList<Byte> bytes, int position) {
        return parityManager.calculateParityBit(currentByteCol).equals(bytes.get(position).getBinaryValue().substring(bytes.get(position).getByteLength() -1));
    }
}



