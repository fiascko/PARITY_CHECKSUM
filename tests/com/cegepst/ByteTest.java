package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteTest {

    private Byte binaryValue;

    @BeforeEach
    public void SETUP() {
        binaryValue = new Byte("01101010");
    }

    @Test
    void GET_CHAR() {
        char result = binaryValue.getChar();
        assertEquals('j', result);
    }

    @Test
    void GET_BINARY_VALUE() {
        String result = binaryValue.getBinaryValue();
        assertEquals("01101010", result);
    }
}
