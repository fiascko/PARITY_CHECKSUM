package com.cegepst;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityManagerTest {

    @Test
    void oddParityBit() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.addParityBit("01100001");
        assertEquals("011000011", result);
    }

    @Test
    void evenParityBit() {
        ParityManager parityManager = new ParityManager();
        String result = parityManager.addParityBit("01100000");
        assertEquals("011000000", result);
    }


}
