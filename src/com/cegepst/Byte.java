package com.cegepst;

public class Byte {

    private String binaryValue;

    public Byte(String bits) {
        binaryValue = bits;
    }

    protected String getBinaryValue() {
        return binaryValue;
    }

    protected void deleteParityBinaryValue(String newBinaryValue) {
        binaryValue = newBinaryValue;
    }

    protected void setParityBinaryValue(String parityBit) {
        binaryValue += parityBit;
    }

    protected char getCharFromByte() {
        int parseInt = Integer.parseInt(binaryValue, 2);
        return (char)parseInt;
    }

}
