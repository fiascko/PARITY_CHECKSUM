package com.cegepst;

public class Checksum {

    public Checksum() {
        Output.displayOptions();
        startOption(Input.readOption());
    }

    private void startOption(String option) {
        if (option.equals("DECODE")) {
            Output.displayDecodeMessage();
            new Decoder(Input.readBinaryMessage());
            return;
        }
        Output.displayEncodeMessage();
        new Encoder(Input.readTextMessage());
    }
}
