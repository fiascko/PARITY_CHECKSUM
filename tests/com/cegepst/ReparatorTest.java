package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReparatorTest {

    private Reparator reparator;

    @BeforeEach
    public void SETUP() {
        reparator = new Reparator();
    }

//    ARRAY TEST
//    @Test
//    public void DETECT_SHORT_MESSAGE_ERROR() {
//        String result = reparator.detectError("00101101");
//        assertEquals("0", result);
//    }
}
