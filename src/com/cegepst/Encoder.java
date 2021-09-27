package com.cegepst;

import java.util.ArrayList;

public class Encoder {

    private String bitsStream;

    private Translator translator;

    //Pour tout les mots
    private ArrayList<Byte> bytes;

    public Encoder(String textMessage) {
        initEncoder();
        encode(textMessage);
    }

    private void encode(String textMessage) {
        bitsStream = translator.convertMessageToBinary(textMessage);
        //        split the string into byte in bytes
        //        add parity to line
        //        make block
        //        add parity to block
        //        convert all block to string
        //        output the bitStreamstring
    }

    private void initEncoder() {
        translator = new Translator();
    }



}
