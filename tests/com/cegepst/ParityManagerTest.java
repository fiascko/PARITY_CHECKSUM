package com.cegepst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityManagerTest {

    @Test
    void calculateParityBitEven() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.calculateParityBit("00101101");
        assertEquals("0", result);
    }

    @Test
    void calculateParityBitOdd() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.calculateParityBit("01001010");
        assertEquals("1", result);
    }
}
