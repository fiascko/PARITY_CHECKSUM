package com.cegepst;

public class Byte {

    private String charByte;

    public Byte(String bits) {
        charByte = bits;
    }

    public String getCharByte() {
        return charByte;
    }

    public void deleteParityCharByte(String newCharByte) {
        charByte = newCharByte;
    }

    public void setParityCharByte(String parityBit) {
        charByte += parityBit;
    }

    public char getCharFromByte() {
        int parseInt = Integer.parseInt(charByte, 2);
        return (char)parseInt;
    }

    //        translate() les charByte en char dans la string

}
