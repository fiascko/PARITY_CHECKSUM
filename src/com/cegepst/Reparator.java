package com.cegepst;

import java.util.ArrayList;

public class Reparator {

    // check si ya plus que 1 changement dans un block si oui ces corrompu si non on continue
    public Boolean detectError(ArrayList<Byte> bytes, ParityManager parityManager) {
        //
        int cpt = 0;
        if (bytes.size() <= 9) {
            for (Byte currentByte : bytes) {
                String currentByteparityBit = parityManager.calculateParityBit(currentByte.getBinaryValue().substring(0, currentByte.getBinaryValue().length() - 1));
                if (!currentByteparityBit.equals(currentByte.getBinaryValue().substring(currentByte.getBinaryValue().length() - 1))) {
                    cpt++;
                    if (cpt == 2) {
                        return false;
                    }
                }
            }
        }
        //
//        le faire par block
//        le faire pour le reste
        return true;
    }
}

//    private void repareError() {
//
//    }



