package com.cegepst;

public class Checksum {

    public Checksum() {
        while (true) {
            Output.displayOptions();
            startOption(Input.readOption());
        }
    }

    private void startOption(String option) {
        if (option.equals("DECODE")) {
            Output.displayDecodeMessage();
            new Decoder(Input.readBinaryMessage());
            return;
        }
        if (option.equals("ENCODE")) {
            Output.displayEncodeMessage();
            new Encoder(Input.readTextMessage());
            return;
        }
        if (option.equals("EXIT")) {
            System.exit(0);
        }
        return;
    }
}
