package com.cegepst;

import java.util.ArrayList;
import java.util.List;

public class ParityManager {

    public String addParityBit(String charByte) {
        if ((Integer.parseInt(charByte) % 2) == 0) {
            charByte += "0";
        } else {
            charByte += "1";
        }
        return charByte;
    }

//    public String checkParityBlock(List<Byte> bytesTempo) {
//
//
//        return "";
//    }

//    public void addParityLines(ArrayList<Byte> bytes) {
////        for (int i = 0;)
//    }
//
//    public String addParityLine() {
//
//        return "";
//    }
//
}




//    public String checkParityBlock(List<Byte> bytesTempo) {
//        String line = "";
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 8; j++) {
////                line += addParityBit();
//            }
//        }
//
//        return "parityLine";
//    }
//
//    public void addParityLines(ArrayList<Byte> bytes) {
//        int counter = 0;
//        int counterLine = 0;
//        for (int i = 0; i < bytes.size(); i++) {
//            counter++;
//            bytesTempo.add(bytes.get(i));
//            if (counter == 8) {
//                counterLine++;
////                finalBytes.add(i,new Byte());
//                checkParityBlock(bytesTempo);
//                addParityLine();
//                counter = 0;
//            }
////            if (i == bytes.size()) {
////                addParityLine();
////            }
//        }
//    }
//
//    public String addParityLine() {
//        return "";
//    }

