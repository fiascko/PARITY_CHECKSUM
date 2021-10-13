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
    public void DETECT_SHORT_MESSAGE_ERROR() {
        Boolean result = reparator.detectError(initShortArrayError(), parityManager);
        assertEquals(false, result);
    }

    @Test
    public void DETECT_SHORT_MESSAGE_OK() {
        Boolean result = reparator.detectError(initShortArray(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_ERROR() {
        Boolean result = reparator.detectError(initLongArrayError(), parityManager);
        assertEquals(false, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_OK() {
        Boolean result = reparator.detectError(initLongArray(), parityManager);
        assertEquals(true, result);
    }

    private ArrayList<Byte> initShortArray() {
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

    private ArrayList<Byte> initShortArrayError() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010101"));//last 1 false
        bytes.add(new Byte("011001011"));//last 1 false
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

    private ArrayList<Byte> initLongArrayError() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("111100111"));//first 1 false
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("000110011"));
        bytes.add(new Byte("011001111"));
        bytes.add(new Byte("011100101"));//last 1 false
        bytes.add(new Byte("011011111"));//last 1 false
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("000010010"));
        return bytes;
    }
}
