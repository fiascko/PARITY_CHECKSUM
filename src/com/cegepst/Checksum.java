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
            String decodeMessage = new Decoder().decode(Input.readBinaryMessage());
            Output.displayDecodeResult(decodeMessage);
        }
        if (option.equals(Input.ENCODE)) {
            Output.displayEncodeMessage();
            String encodeMessage = new Encoder().encode(Input.readTextMessage());
            Output.displayEncodeResult(encodeMessage);
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
