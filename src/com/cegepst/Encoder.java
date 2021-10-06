package com.cegepst;

import java.util.ArrayList;

public class Encoder {

    private String bitsStream;
    private Translator translator;
    private ParityManager parityManager;

    private ArrayList<Byte> bytes;
    private ArrayList<Byte> encodeBytesStream;

    public Encoder() {
        bytes = new ArrayList<>();
        translator = new Translator();
        parityManager = new ParityManager();
    }

    public String encode(String textMessage) {
        bitsStream = translator.convertMessageToBinary(textMessage);
        splitBitsStream(bitsStream);
        encodeBytesStream = parityManager.addParityLines(bytes);
        return convertEncodeBytesStream(encodeBytesStream);
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 8;
        String[] splitBits = bitsStream.split("(?<=\\G.{8})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
            bytes.get(i).setParityBinaryValue(parityManager.calculateParityBit(bytes.get(i).getBinaryValue()));
        }
    }

    private String convertEncodeBytesStream(ArrayList<Byte> encodeBitsStream) {
        String encodeMessage = "";
        for(int i = 0; i < encodeBitsStream.size(); i++) {
            encodeMessage += encodeBitsStream.get(i).getBinaryValue();
        }
        return encodeMessage;
    }
}

