package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReparatorTest {

    private Reparator reparator;
    private ParityManager parityManager;

    @BeforeEach
    public void SETUP() {
        reparator = new Reparator();
        parityManager = new ParityManager();
    }

    @Test
    public void REPAIR_SHORT_MESSAGE() {
        ArrayList<Byte> result = reparator.repair(initShortArrayReparable(), parityManager);
        assertEquals("011001010", result.get(1).getBinaryValue());
    }

    //reparable core
    //reparable end

    private ArrayList<Byte> initShortArrayReparable() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("111001010"));//first 1 false
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("001110010"));
        return bytes;
    }
}
