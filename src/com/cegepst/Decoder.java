package com.cegepst;

import java.util.ArrayList;

public class Decoder {

    private ArrayList<Byte> bytes;

    public Decoder(String binaryMessage) {
        initDecoder();
        decode(binaryMessage);
    }

    private void initDecoder() {
        bytes = new ArrayList<>();
    }

    private void decode(String binaryMessage) {
        splitBitsStream(binaryMessage);
//        check si respect()
//        checkIferrorDansles parity()
//        siErrorRepareerreur()

//        effacer chaque parity on byte
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


}
