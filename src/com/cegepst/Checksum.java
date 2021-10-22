package com.cegepst;

public class Checksum {

    public void start() {
        boolean checksum = true;
        while (checksum) {
            String option = chooseAnOption();
            checksum = startOption(option);
        }
    }

    //return la string et faire fun pour output
    private boolean startOption(String option) {
        if (option.equals(Input.DECODE)) {
            decoding();
        }
        if (option.equals(Input.ENCODE)) {
            encoding();
        }
        return !option.equals(Input.EXIT);
    }

    private void decoding() {
        Output.displayDecodeMessage();
        String decodeMessage = new Decoder().decode(Input.readBinaryMessage());
        Output.displayDecodeResult(decodeMessage);
    }

    private void encoding() {
        Output.displayEncodeMessage();
        String encodeMessage = new Encoder().encode(Input.readTextMessage());
        Output.displayEncodeResult(encodeMessage);
    }

    private String chooseAnOption() {
        Output.displayOptions();
        return Input.readOption();
    }
}
