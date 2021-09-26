package com.cegepst;

public class BinaryShifter {

    private String binaryMessage;

    public BinaryShifter(String textMessage) {
        binaryMessage = convertToBinary(textMessage); //System.out.println(binaryMessage);
    }

    private String convertToBinary(String textMessage) {
        StringBuilder bitsStream = new StringBuilder();
        char[] chars = textMessage.toCharArray();
        for (char aChar : chars) {
            bitsStream.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        return bitsStream.toString();
    }

    public String getBinaryMessage() {
        return binaryMessage;
    }
}
