package com.cegepst;

import java.util.ArrayList;

public class Decoder {

    private static final String CORRUPTED = "CORRUPTED";
    private final Translator translator;
    private final ParityManager parityManager;
    private final Detector detector;
    private final Reparator reparator;
    private ArrayList<Byte> bytes;
    private ArrayList<Character> decodeMessage;

    public Decoder() {
        translator = new Translator();
        parityManager = new ParityManager();
        detector = new Detector();
        reparator = new Reparator();
        bytes = new ArrayList<>();
        decodeMessage = new ArrayList<>();
    }

    public String decode(String binaryMessage) {
        splitBitsStream(binaryMessage);
        return decodeProcess();
    }

    private String decodeProcess() {
        if (!detector.detectError(bytes, parityManager)) {
            bytes = reparator.repair(bytes, parityManager);
            bytes = parityManager.eraseParityLines(bytes);
            bytes = parityManager.eraseParityBits(bytes);
            decodeMessage = translator.convertBytesToCharacters(bytes, decodeMessage);
            return convertDecodeMessage();
        } else {
            return CORRUPTED;
        }
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 9;
        String[] splitBits = bitsStream.split("(?<=\\G.{9})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
        }
    }

    private String convertDecodeMessage() {
        String decodeMessage = "";
        for (int i = 0; i < bytes.size(); i++) {
            decodeMessage += bytes.get(i).getChar();
        }
        return decodeMessage;
    }
}
