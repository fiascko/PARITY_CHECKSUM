package com.cegepst;

import java.util.ArrayList;

public class ParityManager {

    public String calculateParityBit(String charByte) {
        int count = 0;
        for(int i = 0; i < charByte.length(); i++) {
            char bit = charByte.charAt(i);
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

    public ArrayList<Byte> addParityLines(ArrayList<Byte> bytes) {
        String parityLine = "";
        for (int charIndex = 0; charIndex < 9; charIndex++) {
            String thisCol = "";
            for (int byteIndex = 0; byteIndex < bytes.size(); byteIndex++) {
                thisCol += bytes.get(byteIndex).getCharByte().charAt(charIndex);
            }
            parityLine += calculateParityBit(thisCol);
        }
        bytes.add(new Byte(parityLine));
        return bytes;
    }
}

