package com.cegepst;

public class Byte {

    private String charByte;

    public Byte(String bits) {
        charByte = bits;
    }

    public void eraseParityBit() {
        charByte = charByte.substring(0, charByte.length() - 8);
    }

    public String getCharByte() {
        return charByte;
    }

    public void setParityCharByte(String parityBit) {
        charByte += parityBit;
    }
}
