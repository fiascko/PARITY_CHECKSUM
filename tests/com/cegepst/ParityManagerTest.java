package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParityManagerTest {

    private ParityManager parityManager;

    @BeforeEach
    public void SETUP() {
        parityManager = new ParityManager();
    }

    @Test
    public void GET_DESIRED_PARITY_BIT() {
        String result = parityManager.getDesiredByteParityBit(initShortArray(), parityManager, 4);
        assertEquals("0", result);
    }

    @Test
    public void GET_CURRENT_PARITY_BIT() {
        String result = parityManager.getCurrentParityBit(initShortArray(), 3);
        assertEquals("0", result);
    }

    @Test
    public void VALIDATE_COL_PARITY_BIT() {
        boolean result = parityManager.validateColParityBit(initShortArray().get(1).getBinaryValue(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void CALCULATE_PARITY_BIT_EVEN() {
        String result = parityManager.calculateParityBit("00101101");
        assertEquals("0", result);
    }

    @Test
    public void CALCULATE_PARITY_BIT_ODD() {
        String result = parityManager.calculateParityBit("01001010");
        assertEquals("1", result);
    }

    @Test
    public void ERASE_PARITY_BIT_EVEN() {
        String result = parityManager.eraseParityBit("010010101");
        assertEquals("01001010", result);
    }

    @Test
    public void ERASE_PARITY_BIT_ODD() {
        String result = parityManager.eraseParityBit("010011100");
        assertEquals("01001110", result);
    }

    @Test
    public void ADD_PARITY_LINE_SHORT_MESSAGE() {
        ArrayList<Byte> result = parityManager.addParityLines(initShortArray());
        assertEquals("010010101", result.get(0).getBinaryValue());
        assertEquals("011001010", result.get(1).getBinaryValue());
        assertEquals("001000001", result.get(2).getBinaryValue());
        assertEquals("011101000", result.get(3).getBinaryValue());
        assertEquals("011001010", result.get(4).getBinaryValue());
        assertEquals("011100111", result.get(5).getBinaryValue());
        assertEquals("011101000", result.get(6).getBinaryValue());
        assertEquals("000110011", result.get(7).getBinaryValue());
    }

    @Test
    public void ERASE_PARITY_LINE_SHORT_MESSAGE() {
        ArrayList<Byte> bytes = initShortArrayWithParityLine();
        ArrayList<Byte> result = parityManager.eraseParityLines(initShortArrayWithParityLine());
        assertEquals(bytes.size() - 1,  result.size());
    }

    @Test
    public void ERASE_PARITY_LINE_LONG_MESSAGE() {
        ArrayList<Byte> bytes = initLongArrayWithParityLine();
        ArrayList<Byte> result = parityManager.eraseParityLines(initLongArrayWithParityLine());
        assertEquals(bytes.size() - 2,  result.size());
    }


    @Test
    public void ADD_PARITY_LINES_LONG_MESSAGE() {
        ArrayList<Byte> result = parityManager.addParityLines(initLongArray());
        assertEquals("011010100", result.get(0).getBinaryValue());
        assertEquals("011001010", result.get(1).getBinaryValue());
        assertEquals("001000001", result.get(2).getBinaryValue());
        assertEquals("011101000", result.get(3).getBinaryValue());
        assertEquals("011001010", result.get(4).getBinaryValue());
        assertEquals("011100111", result.get(5).getBinaryValue());
        assertEquals("011101000", result.get(6).getBinaryValue());
        assertEquals("001000001", result.get(7).getBinaryValue());
        assertEquals("000110011", result.get(8).getBinaryValue());
        assertEquals("011001111", result.get(9).getBinaryValue());
        assertEquals("011100100", result.get(10).getBinaryValue());
        assertEquals("011011110", result.get(11).getBinaryValue());
        assertEquals("011100111", result.get(12).getBinaryValue());
        assertEquals("000010010", result.get(13).getBinaryValue());
    }

    private ArrayList<Byte> initShortArray() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("010010101"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("011101000"));
        return bytes;
    }

    private ArrayList<Byte> initShortArrayWithParityLine() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("001110010"));
        return bytes;
    }

    private ArrayList<Byte> initLongArray() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));//0
        bytes.add(new Byte("011001010"));//1
        bytes.add(new Byte("001000001"));//2
        bytes.add(new Byte("011101000"));//3
        bytes.add(new Byte("011001010"));//4
        bytes.add(new Byte("011100111"));//5
        bytes.add(new Byte("011101000"));//6
        bytes.add(new Byte("001000001"));//7
        bytes.add(new Byte("011001111"));//8
        bytes.add(new Byte("011100100"));//9
        bytes.add(new Byte("011011110"));//10
        bytes.add(new Byte("011100111"));//11
        return bytes;
    }

    private ArrayList<Byte> initLongArrayWithParityLine() {
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
        bytes.add(new Byte("011011110"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("000010010"));
        return bytes;
    }
}














