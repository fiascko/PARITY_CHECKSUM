package com.cegepst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityManagerTest {

    @Test
    void testCalculateParityBit() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.calculateParityBit("01100001");
        assertEquals("1", result);
    }

    @Test
    void testcalculateParityBit() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.calculateParityBit("01100000");
        assertEquals("0", result);
    }
}
