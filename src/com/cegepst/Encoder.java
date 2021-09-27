package com.cegepst;

import java.util.ArrayList;

public class Encoder {

    //Pour tout les mots
    private ArrayList<Octet> octets;

    public Encoder(String textMessage) {
        String bitsStream = Translator.convertMessageToBinary(textMessage);
    }

}
