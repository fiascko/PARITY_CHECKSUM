package com.cegepst;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Byte> bytes;
    private Translator translator;
    private ParityManager parityManager;

    public Decoder(String binaryMessage) {
        initDecoder();
        decode(binaryMessage);
    }

    private void initDecoder() {
        bytes = new ArrayList<>();
        translator = new Translator();
        parityManager = new ParityManager();
    }

    private void decode(String binaryMessage) {
        splitBitsStream(binaryMessage); // split les 0101011 en Byte de "010101011" (STRING)
//        check si respect()
//        checkIferrorDansles parity()
//        siErrorRepareerreur()
        eraseParityBits(); //effacer chaque parity bit
//        effacer la ligne de parity

//        translate() les charByte en char dans la string
//        Sortir() system out

    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 9;
        String[] splitBits = bitsStream.split("(?<=\\G.{9})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
        }
    }

    private void eraseParityBits() {
        for (int i = 0; i < bytes.size(); i++ ) {
            bytes.get(i).setCharByte(parityManager.eraseParityBit(bytes.get(i).getCharByte()));
        }
    }
}
