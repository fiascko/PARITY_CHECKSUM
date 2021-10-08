package com.cegepst;

import java.util.ArrayList;

public class Decoder {
    private ArrayList<Byte> bytes;
    private Reparator reparator;
    private final Translator translator;
    private final ParityManager parityManager;
    private ArrayList<Character> decodeMessage;

    public Decoder() {
        reparator = new Reparator();
        bytes = new ArrayList<>();
        decodeMessage = new ArrayList<>();
        translator = new Translator();
        parityManager = new ParityManager();
    }

    public String decode(String binaryMessage) {
        splitBitsStream(binaryMessage);
        if (reparator.detectError(bytes, parityManager)) {
//            parityManager.repair
            bytes = parityManager.eraseParityLines(bytes);
            bytes = parityManager.eraseParityBits(bytes);
            decodeMessage = translator.convertBytesToCharacters(bytes, decodeMessage);
            return convertDecodeMessage();
        } else {
            return "";
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
            decodeMessage += bytes.get(i).getCharFromByte();
        }
        return decodeMessage;
    }
}
