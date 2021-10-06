package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoderTest {

    private Decoder decoder;

    @BeforeEach
    public void setUp() {decoder = new Decoder();}

    @Test
    void DECODE_LONG_MESSAGE() {
        String result = decoder.decode("010011010011011110011011101001000001011011101011011110011011011001000001001000001011001010011100111011101000001000001010010101011001010011100100011001010011110101011011011011110011000101000");
        assertEquals("Mon nom est Jeremy", result);
    }

    @Test
    void DECODE_SHORT_MESSAGE() {
        String result = decoder.decode("010011010011011110011010010010010110");
        assertEquals("Moi", result);
    }
}
