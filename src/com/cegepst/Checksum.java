package com.cegepst;

public class Checksum {

    public void start() {
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
        return !option.equals(Input.EXIT);
    }

    private String chooseAnOption() {
        Output.displayOptions();
        return Input.readOption();
    }
}
