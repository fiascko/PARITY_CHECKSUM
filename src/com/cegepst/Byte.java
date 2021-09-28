package com.cegepst;

public class Byte {

    private String charByte;
    private ParityEvaluator parityEvaluator;

    public Byte(String bits) {
        parityEvaluator = new ParityEvaluator();
        charByte = bits;
        charByte = parityEvaluator.addParityBit(charByte);
    }
}
