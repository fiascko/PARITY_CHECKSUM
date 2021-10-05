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
        decodeMessage = new ArrayList<>();
        translator = new Translator();
        parityManager = new ParityManager();
    }

    private void decode(String binaryMessage) {
        boolean valideEncode = Input.validateEncodelength(binaryMessage);
        if (valideEncode) {
            splitBitsStream(binaryMessage);
            //       checkIferrorDansles parity()
            //        siErrorRepareerreur()
            bytes = parityManager.eraseParityLines(bytes);
            bytes = parityManager.eraseParityBits(bytes);
            decodeMessage = translator.convertBytesToCharacters(bytes, decodeMessage);
            Output.displayDecodeResult(decodeMessage);
        } else {
            Output.displayCorruptionMessage();
        }
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 9;
        String[] splitBits = bitsStream.split("(?<=\\G.{9})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
        }
    }
}
