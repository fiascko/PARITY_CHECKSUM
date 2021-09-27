package com.cegepst;

import java.util.ArrayList;

public class Encoder {

    private String bitsStream;
    private Translator translator;

    private ArrayList<Byte> bytes = new ArrayList<Byte>();

    public Encoder(String textMessage) {
        initEncoder();
        encode(textMessage);
    }

    private void initEncoder() {
        translator = new Translator();
    }

    private void encode(String textMessage) {
        bitsStream = translator.convertMessageToBinary(textMessage);
        splitBitsStream(bitsStream);
        //        make block(grid) add parity to block
        //        convert all block to string
        //        output the bitStreamstring
    }

    private void splitBitsStream(String bitsStream) {
        int byteCounter = bitsStream.length() / 8;
        String[] splitBits = bitsStream.split("(?<=\\G.{8})");
        for (int i = 0; i < byteCounter; i++) {
            bytes.add(new Byte(splitBits[i]));
        }
    }

}
