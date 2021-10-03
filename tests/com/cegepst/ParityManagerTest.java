package com.cegepst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityManagerTest {

    //check si before each

    @Test
    void CALCULATE_PARITY_BIT_EVEN() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.calculateParityBit("00101101");
        assertEquals("0", result);
    }

    @Test
    void CALCULATE_PARITY_BIT_ODD() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.calculateParityBit("01001010");
        assertEquals("1", result);
    }

    @Test
    void ERASE_PARITY_BIT() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.eraseParityBit("010010101");
        assertEquals("01001010", result);
    }
}
