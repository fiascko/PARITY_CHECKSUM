package com.cegepst;

public class Byte {

    private String charByte;
    private ParityManager parityManager;

    public Byte(String bits) {
        parityManager = new ParityManager();
        charByte = bits;
        charByte = parityManager.addParityBit(charByte);
    }

    public String getCharByte() {
        return charByte;
    }
}
