package com.cegepst;

public class Checksum {

    public Checksum() {
        Output.displayOptions();
        startOption(Input.readOption());
    }

    private void startOption(String option) {
        if (option.equals("DECODE")) {
            Output.displayDecodeMessage();
            new Decode(Input.readBinaryMessage());
            return;
        }
        Output.displayEncodeMessage();
        new Encode(Input.readTextMessage());
    }
}
