package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReparatorTest {

    private Reparator reparator;
    private ParityManager parityManager;
    private BinaryArrays binaryArrays;

    @BeforeEach
    public void SETUP() {
        reparator = new Reparator();
        parityManager = new ParityManager();
        binaryArrays = new BinaryArrays();
    }

    @Test
    public void REPAIR_SHORT_MESSAGE() {
        ArrayList<Byte> result = reparator.repair(binaryArrays.initShortArrayWithParityLineReparable(), parityManager);
        assertEquals("011001010", result.get(1).getBinaryValue());
    }

    @Test
    public void REPAIR_LONG_MESSAGE_CORE() {
        ArrayList<Byte> result = reparator.repair(binaryArrays.initLongArrayWithParityLineReparable(), parityManager);
        assertEquals("001000001", result.get(2).getBinaryValue());
    }

    @Test
    public void REPAIR_LONG_MESSAGE_END() {
        ArrayList<Byte> result = reparator.repair(binaryArrays.initLongArrayWithParityLineReparable2(), parityManager);
        assertEquals("011011110", result.get(11).getBinaryValue());
    }

    private class BinaryArrays {
        private ArrayList<Byte> initShortArrayWithParityLineReparable() {
            ArrayList<Byte> bytes = new ArrayList<Byte>();
            bytes.add(new Byte("011010100"));
            bytes.add(new Byte("111001010"));//FIRST 1 FALSE
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011101000"));
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("011101000"));
            bytes.add(new Byte("001110010"));
            return bytes;
        }

        private ArrayList<Byte> initLongArrayWithParityLineReparable() {
            ArrayList<Byte> bytes = new ArrayList<Byte>();
            bytes.add(new Byte("011010100"));
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("000000001"));//THIRD 0 FALSE
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
            bytes.add(new Byte("111011110"));//FIRST 1 FALSE
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("000010010"));
            return bytes;
        }
    }
}
