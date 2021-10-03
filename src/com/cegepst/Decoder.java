package com.cegepst;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Byte> bytes;
    private Translator translator;
    private ParityManager parityManager;

    private ArrayList<Character> decodeMessage;

    public Decoder(String binaryMessage) {
        initDecoder();
        decode(binaryMessage);
    }

    private void initDecoder() {
        bytes = new ArrayList<>();
        translator = new Translator();
        parityManager = new ParityManager();
        decodeMessage = new ArrayList<>();
    }

    private void decode(String binaryMessage) {
        splitBitsStream(binaryMessage); // split les 0101011 en Byte de "010101011" (STRING)
//        check si respect() sinon dire corrompu SOUT
//        checkIferrorDansles parity()
//        siErrorRepareerreur()
        bytes = parityManager.eraseParityLines(bytes); // ajout des deux autre conditions
        bytes = parityManager.eraseParityBits(bytes);
        decodeBytes(bytes);
        Output.displayDecodeResult(decodeMessage);
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 9;
        String[] splitBits = bitsStream.split("(?<=\\G.{9})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
        }
    }

    private void decodeBytes(ArrayList<Byte> bytes) {
        for (int i = 0; i < bytes.size(); i++) {
            decodeMessage.add(bytes.get(i).getCharFromByte());
        }
    }
}
