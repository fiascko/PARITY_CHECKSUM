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

    @Test
    public void REPAIR_LONG_MESSAGE() {
        ArrayList<Byte> result = reparator.repair(binaryArrays.initLongArrayWithParityLineReparable3(), parityManager);
        assertEquals("011010100", result.get(0).getBinaryValue());
        assertEquals("011100100", result.get(21).getBinaryValue());//lui a regler
    }

    private static class BinaryArrays {
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

        private ArrayList<Byte> initLongArrayWithParityLineReparable2() {
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

        private ArrayList<Byte> initLongArrayWithParityLineReparable3() {
            ArrayList<Byte> bytes = new ArrayList<Byte>();
            bytes.add(new Byte("001010100"));//SECOND 0 FALSE
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011001100"));
            bytes.add(new Byte("011000011"));
            bytes.add(new Byte("011010010"));
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("000100100"));//line
            bytes.add(new Byte("011101011"));
            bytes.add(new Byte("011011101"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011101000"));
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("011101000"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("000011011"));//line
            bytes.add(new Byte("011100001"));
            bytes.add(new Byte("011011110"));
            bytes.add(new Byte("011101011"));
            bytes.add(new Byte("111100100"));//i21 - FIRST 1 FALSE
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011000101"));
            bytes.add(new Byte("011011110"));
            bytes.add(new Byte("011101011"));
            bytes.add(new Byte("010000001"));//line
            bytes.add(new Byte("011000110"));
            bytes.add(new Byte("011011000"));
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("011100100"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011001001"));
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("011101011"));
            bytes.add(new Byte("010011001"));//line
            bytes.add(new Byte("011110000"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011001100"));
            bytes.add(new Byte("011011110"));
            bytes.add(new Byte("011010010"));
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("010010110"));//line
            return bytes;
        }
    }
}
