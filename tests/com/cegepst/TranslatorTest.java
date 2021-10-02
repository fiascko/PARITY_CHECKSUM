package com.cegepst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    @Test
    void CONVERT_MESSAGE_TO_BINARY() {
        Translator translator = new Translator();
        String result = translator.convertMessageToBinary("Jeremy");
        assertEquals("010010100110010101110010011001010110110101111001", result);
    }
}
