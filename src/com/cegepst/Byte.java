package com.cegepst;

public class Byte {

    private String binaryValue;

    public Byte(String bits) {
        binaryValue = bits;
    }

    public String getBinaryValue() {
        return binaryValue;
    }

    public void deleteParityBinaryValue(String newBinaryValue) {
        binaryValue = newBinaryValue;
    }

    public void setParityBinaryValue(String parityBit) {
        binaryValue += parityBit;
    }

    public char getCharFromByte() {
        int parseInt = Integer.parseInt(binaryValue, 2);
        return (char) parseInt;
    }
}
