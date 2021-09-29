package com.cegepst;

import java.util.ArrayList;

public class Encoder {

    private String bitsStream;
    private Translator translator;
    private ParityManager parityManager;

    private ArrayList<Byte> bytes;

    private ArrayList<Byte> encodingBitsStream;

    public Encoder(String textMessage) {
        initEncoder();
        encode(textMessage);
    }

    private void initEncoder() {
        bytes = new ArrayList<>();
        translator = new Translator();
        parityManager = new ParityManager();
    }

    private void encode(String textMessage) {
        bitsStream = translator.convertMessageToBinary(textMessage);
        splitBitsStream(bitsStream);
        encodingBitsStream = parityManager.addParityLines(bytes);
        Output.displayEncodeResult(encodingBitsStream);
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 8;
        String[] splitBits = bitsStream.split("(?<=\\G.{8})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
            bytes.get(i).setParityCharByte(parityManager.calculateParityBit(bytes.get(i).getCharByte()));
        }
    }


}

