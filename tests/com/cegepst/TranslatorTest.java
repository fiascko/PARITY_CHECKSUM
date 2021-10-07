package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    private Translator translator;

    @BeforeEach
    public void SETUP() {
        translator = new Translator();
    }

    @Test
    public void CONVERT_MESSAGE_TO_BINARY_SHORT_MESSAGE() {
        String result = translator.convertMessageToBinary("Jeremy");
        assertEquals("010010100110010101110010011001010110110101111001", result);
    }

    @Test
    public void CONVERT_MESSAGE_TO_BINARY_LONG_MESSAGE() {
        String result = translator.convertMessageToBinary("Mon nom est Jérémy Fontaine-Ethier.");
        assertEquals("0100110101101111011011100010000001101110011011110110110100100000011001010111001101110100001000000100101011101001011100101110100101101101011110010010000001000110011011110110111001110100011000010110100101101110011001010010110101000101011101000110100001101001011001010111001000101110", result);
    }
}
