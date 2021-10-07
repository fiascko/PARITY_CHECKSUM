package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncoderTest {

    private Encoder encoder;

    @BeforeEach
    public void SETUP() {
        encoder = new Encoder();
    }

    @Test
    void ENCODE_LONG_MESSAGE() {
        String result = encoder.encode("Mon nom est Jeremy");
        assertEquals("010011010011011110011011101001000001011011101011011110011011011001000001001000001011001010011100111011101000001000001010010101011001010011100100011001010011110101011011011011110011000101000", result);
    }

    @Test
    void ENCODE_SHORT_MESSAGE() {
        String result = encoder.encode("Moi");
        assertEquals("010011010011011110011010010010010110", result);
    }
}
