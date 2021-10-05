package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    private Translator translator;

    @BeforeEach
    protected void setUp() {translator = new Translator();}

    @Test
    protected void CONVERT_MESSAGE_TO_BINARY() {
        String result = translator.convertMessageToBinary("Jeremy");
        assertEquals("010010100110010101110010011001010110110101111001", result);
    }
}
