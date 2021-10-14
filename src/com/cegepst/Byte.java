package com.cegepst;

public class Byte {

    private String binaryValue;

    public Byte(String bits) {
        binaryValue = bits;
    }

    public String getBinaryValue() {
        return binaryValue;
    }

    public int getByteLength() {
        return binaryValue.length();
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

    public void toggleChar(int i) {
        StringBuilder newBinaryValue = new StringBuilder(binaryValue);
        if (newBinaryValue.charAt(i) == '1') {
            newBinaryValue.setCharAt(i, '0');
        } else {
            newBinaryValue.setCharAt(i, '1');
        }
        this.binaryValue = newBinaryValue.toString();
    }
}
