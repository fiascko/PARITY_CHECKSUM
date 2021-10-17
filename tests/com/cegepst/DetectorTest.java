package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectorTest {

    private Detector detector;
    private ParityManager parityManager;

    @BeforeEach
    public void SETUP() {
        detector = new Detector();
        parityManager = new ParityManager();
    }

    @Test
    public void DETECT_SHORT_MESSAGE_ERROR() {
        Boolean result = detector.detectError(initShortArrayError(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_SHORT_MESSAGE_OK() {
        Boolean result = detector.detectError(initShortArray(), parityManager);
        assertEquals(false, result);
    }

    @Test
    public void DETECT_SHORT_MESSAGE_BYTE_ERROR() {
        Boolean result = detector.detectError(initShortArrayErrorInByte(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_BYTE_END_ERROR() {
        Boolean result = detector.detectError(initLongArrayErrorByteEnd(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_BYTE_CORE_ERROR() {
        Boolean result = detector.detectError(initLongArrayErrorByteCore(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_ERROR() {
        Boolean result = detector.detectError(initLongArrayError(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_ERROR2() {
        Boolean result = detector.detectError(initLongArrayError2(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_OK() {
        Boolean result = detector.detectError(initLongArray(), parityManager);
        assertEquals(false, result);
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


    private ArrayList<Byte> initShortArrayErrorInByte() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("000010100"));// second 0 false And 3e 0 false
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

    private ArrayList<Byte> initLongArrayReparable() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("111100111"));//First 1 false
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

    private ArrayList<Byte> initLongArrayErrorByteCore() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("011010100"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("010000001"));//second 1 false - third 0 false
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

    private ArrayList<Byte> initLongArrayErrorByteEnd() {
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
        bytes.add(new Byte("000100100"));//second 0 false - third 0 false
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
        bytes.add(new Byte("111100111"));//First 1 false
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("000110011"));
        bytes.add(new Byte("011001111"));
        bytes.add(new Byte("011100101"));//Last 1 false
        bytes.add(new Byte("011011111"));//Last 1 false
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("000010010"));
        return bytes;
    }

    private ArrayList<Byte> initLongArrayError2() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("010010101"));
        bytes.add(new Byte("011001010"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011001100"));
        bytes.add(new Byte("011000011"));
        bytes.add(new Byte("011010010"));
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("001100101"));
        bytes.add(new Byte("011101011"));
        bytes.add(new Byte("111011101"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("011011000"));
        bytes.add(new Byte("011011110"));
        bytes.add(new Byte("011011101"));
        bytes.add(new Byte("011001111"));
        bytes.add(new Byte("001000001"));
        bytes.add(new Byte("000100010"));
        bytes.add(new Byte("011101000"));
        bytes.add(new Byte("111001010"));//First 1 false
        bytes.add(new Byte("011100111"));
        bytes.add(new Byte("001101000"));//Second 0 false
        bytes.add(new Byte("000101101"));
        return bytes;
    }
}
