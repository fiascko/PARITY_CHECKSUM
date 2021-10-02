package com.cegepst;

public class Checksum {

    private static final String DECODE = "DECODE";
    private static final String ENCODE = "ENCODE";
    private static final String EXIT = "EXIT";

    public Checksum() {
        boolean checksum = true;
        while (checksum) {
            checksum = startOption();
        }
    }

    private boolean startOption() {
        String option = chooseAnOption();
        if (option.equals(DECODE)) {
            Output.displayDecodeMessage();
            new Decoder(Input.readBinaryMessage());
        }
        if (option.equals(ENCODE)) {
            Output.displayEncodeMessage();
            new Encoder(Input.readTextMessage());
        }
        if (option.equals(EXIT)) {
            return false;
        }
        return true;
    }

    private String chooseAnOption() {
        Output.displayOptions();
        return Input.readOption();
    }
}
