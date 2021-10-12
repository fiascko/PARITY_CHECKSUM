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
        ArrayList<Byte> bytes = initShortArray();
        ArrayList<Byte> result = parityManager.addParityLines(bytes);
        assertEquals("010010101", bytes.get(0).getBinaryValue());
        assertEquals("011001010", bytes.get(1).getBinaryValue());
        assertEquals("001000001", bytes.get(2).getBinaryValue());
        assertEquals("011101000", bytes.get(3).getBinaryValue());
        assertEquals("011001010", bytes.get(4).getBinaryValue());
        assertEquals("011100111", bytes.get(5).getBinaryValue());
        assertEquals("011101000", bytes.get(6).getBinaryValue());
        assertEquals("000110011", bytes.get(7).getBinaryValue());
    }

    @Test
    public void ERASE_PARITY_LINE_SHORT_MESSAGE() {
        ArrayList<Byte> bytes = initShortArrayWithParityLine();
        ArrayList<Byte> result = parityManager.eraseParityLines(initShortArrayWithParityLine());
        assertEquals(bytes.size() - 1,  result.size());
    }

//    @Test
//    public void ERASE_PARITY_LINES_LONG_MESSAGE() {
//        ArrayList<Byte> bytes = initShortArrayWithParityLine();
//        ArrayList<Byte> result = parityManager.eraseParityLines(initShortArrayWithParityLine());
//        assertEquals(bytes.size() - 1,  result.size());
//    }

    //    @Test
//    public void ADD_PARITY_LINES_LONG_MESSAGE() {
//        ArrayList<Byte> bytes = initLongArray();
//        ArrayList<Byte> result = parityManager.addParityLines(bytes);
//        assertEquals("010010101", bytes.get(0).getBinaryValue());
//        assertEquals("011001010", bytes.get(1).getBinaryValue());
//    }

//    private ArrayList<Byte> initLongArray() {
//        ArrayList<Byte> bytes = new ArrayList<Byte>();
//        bytes.add(new Byte("010010101"));
//
//        return bytes;
//    }

    //    private ArrayList<Byte> initLongArrayWithParityLines() {
//        ArrayList<Byte> bytes = new ArrayList<Byte>();
//        bytes.add(new Byte("010010101"));
//
//        return bytes;
//    }

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

//    private ArrayList<Byte> initLongArrayWithParityLine() {
//        ArrayList<Byte> bytes = new ArrayList<Byte>();
//        return bytes;
//    }
}