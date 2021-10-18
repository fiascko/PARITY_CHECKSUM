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
        ArrayList<Byte> result = reparator.repair(initShortArrayWithParityLineReparable(), parityManager);
        assertEquals("011001010", result.get(1).getBinaryValue());
    }

    @Test
    public void REPAIR_LONG_CORE_MESSAGE() {
        ArrayList<Byte> result = reparator.repair(initLongArrayWithParityLineReparable1(), parityManager);
        assertEquals("001000001", result.get(2).getBinaryValue());
    }

    //reparable end

    private ArrayList<Byte> initShortArrayWithParityLineReparable() {
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

    private ArrayList<Byte> initLongArrayWithParityLineReparable1() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("011000001"));//here second 1 false
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("000110011"));
        bytes.add(new Byte("011001111"));
        bytes.add(new Byte("011100100"));
        bytes.add(new Byte("011011110"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("000010010"));
        return bytes;
    }

    private ArrayList<Byte> initLongArrayWithParityLineReparable2() { //for the end check
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("000110011"));
        bytes.add(new Byte("011001111"));
        bytes.add(new Byte("011100100"));
        bytes.add(new Byte("111011110"));//here first 1 false
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("000010010"));
        return bytes;
    }
}
