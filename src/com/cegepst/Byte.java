package com.cegepst;

public class Byte {

    private String charByte;

    public Byte(String bits) {
        charByte = bits;
    }

    public String getCharByte() {
        return charByte;
    }

    public void setCharByte(String newCharByte) {
        charByte = newCharByte;
    }

    public void setParityCharByte(String parityBit) {
        charByte += parityBit;
    }
}
