package com.cegepst;

public class Byte {

    private String binaryValue;

    public Byte(String bits) {
        binaryValue = bits;
    }

    public void deleteParity(String newBinaryValue) {
        binaryValue = newBinaryValue;
    }

    public void addParity(String parityBit) {
        binaryValue += parityBit;
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

    public char getChar() {
        int parseInt = Integer.parseInt(binaryValue, 2);
        return (char) parseInt;
    }

    public String getBinaryValue() {
        return binaryValue;
    }

    public int getLength() {
        return binaryValue.length();
    }
}
