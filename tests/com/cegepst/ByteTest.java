package com.cegepst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteTest {

    @Test
    void GET_CHAR_FROM_BYTE() {
        Byte byteChar = new Byte("01101010");
        char result = byteChar.getCharFromByte();
        assertEquals('j', result);
    }
}
