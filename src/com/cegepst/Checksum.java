package com.cegepst;

public class Checksum {

    public Checksum() {
        boolean checksum = true;
        while (checksum) {
            String option = chooseAnOption();
            checksum = startOption(option);
        }
    }

    private boolean startOption(String option) {
        if (option.equals(Input.DECODE)) {
            Output.displayDecodeMessage();
            new Decoder(Input.readBinaryMessage());
        }
        if (option.equals(Input.ENCODE)) {
            Output.displayEncodeMessage();
            new Encoder(Input.readTextMessage());
        }
        if (option.equals(Input.EXIT)) {
            return false;
        }
        return true;
    }

    private String chooseAnOption() {
        Output.displayOptions();
        return Input.readOption();
    }
}
