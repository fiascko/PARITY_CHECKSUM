package com.cegepst;

import java.util.ArrayList;

public class Encoder {

    private final Translator translator;
    private final ParityManager parityManager;
    private final ArrayList<Byte> bytes;

    public Encoder() {
        translator = new Translator();
        parityManager = new ParityManager();
        bytes = new ArrayList<>();
    }

    public String encode(String textMessage) {
        splitBitsStream(translator.convertMessageToBinary(textMessage));
        return encodeProcess();
    }

    private String encodeProcess() {
        ArrayList<Byte> encodeBytesStream = parityManager.addParityLines(bytes);
        return convertEncodeBytesStream(encodeBytesStream);
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 8;
        String[] splitBits = bitsStream.split("(?<=\\G.{8})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
            bytes.get(i).addParity(parityManager.calculateParityBit(bytes.get(i).getBinaryValue()));
        }
    }

    private String convertEncodeBytesStream(ArrayList<Byte> encodeBitsStream) {
        String encodeMessage = "";
        for (int i = 0; i < encodeBitsStream.size(); i++) {
            encodeMessage += encodeBitsStream.get(i).getBinaryValue();
        }
        return encodeMessage;
    }
}

