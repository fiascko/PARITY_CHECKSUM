package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityManagerTest {

    private ParityManager parityManager;

    @BeforeEach
    void setUp() {parityManager = new ParityManager();}

    @Test
    void CALCULATE_PARITY_BIT_EVEN() {
        String result = parityManager.calculateParityBit("00101101");
        assertEquals("0", result);
    }

    @Test
    void CALCULATE_PARITY_BIT_ODD() {
        String result = parityManager.calculateParityBit("01001010");
        assertEquals("1", result);
    }

    @Test
    void ERASE_PARITY_BIT() {
        String result = parityManager.eraseParityBit("010010101");
        assertEquals("01001010", result);
    }
}
