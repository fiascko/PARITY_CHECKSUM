package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectorTest {

    private Detector detector;
    private ParityManager parityManager;
    private BinaryArrays binaryArrays;

    @BeforeEach
    public void SETUP() {
        detector = new Detector();
        parityManager = new ParityManager();
        binaryArrays = new BinaryArrays();
    }

    @Test
    public void DETECT_SHORT_MESSAGE_OK() {
        Boolean result = detector.detectError(binaryArrays.initShortArray(), parityManager);
        assertEquals(false, result);
    }

    @Test
    public void DETECT_SHORT_MESSAGE_ERROR() {
        Boolean result = detector.detectError(binaryArrays.initShortArrayError(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_SHORT_MESSAGE_BYTE_ERROR() {
        Boolean result = detector.detectError(binaryArrays.initShortArrayErrorInByte(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_OK() {
        Boolean result = detector.detectError(binaryArrays.initLongArray(), parityManager);
        assertEquals(false, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_ERROR() {
        Boolean result = detector.detectError(binaryArrays.initLongArrayError(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_ERROR_2() {
        Boolean result = detector.detectError(binaryArrays.initLongArrayError2(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_ERROR_3() {
        Boolean result = detector.detectError(binaryArrays.initLongArrayError3(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_BYTE_CORE_ERROR() {
        Boolean result = detector.detectError(binaryArrays.initLongArrayErrorByteCore(), parityManager);
        assertEquals(true, result);
    }

    @Test
    public void DETECT_LONG_MESSAGE_BYTE_END_ERROR() {
        Boolean result = detector.detectError(binaryArrays.initLongArrayErrorByteEnd(), parityManager);
        assertEquals(true, result);
    }

    private class BinaryArrays {
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
            bytes.add(new Byte("011010101"));//LAST 1 FALSE
            bytes.add(new Byte("011001011"));//LAST 1 FALSE
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
            bytes.add(new Byte("000010100"));//SECOND 0 FALSE AND THIRD 0 FALSE
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
            bytes.add(new Byte("111100111"));//FIRST 1 FALSE
            bytes.add(new Byte("011101000"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("000110011"));
            bytes.add(new Byte("011001111"));
            bytes.add(new Byte("011100101"));//LAST 1 FALSE
            bytes.add(new Byte("011011111"));//LAST 1 FALSE
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
            bytes.add(new Byte("111001010"));//FIRST 1 FALSE
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("001101000"));//SECOND 0 FALSE
            bytes.add(new Byte("000101101"));
            return bytes;
        }

        private ArrayList<Byte> initLongArrayError3() {
            ArrayList<Byte> bytes = new ArrayList<Byte>();
            bytes.add(new Byte("011010100"));
            bytes.add(new Byte("011001010"));
            bytes.add(new Byte("001000001"));
            bytes.add(new Byte("011101000"));
            bytes.add(new Byte("111001010"));//FIRST 1 FALSE
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("001101000"));//SECOND 0 FALSE
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
            bytes.add(new Byte("010000001"));//SECOND 1 FALSE AND THIRD 0 FALSE
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
            bytes.add(new Byte("000100100"));//SECOND 0 FALSE AND THIRD 0 FALSE
            bytes.add(new Byte("011011110"));
            bytes.add(new Byte("011100111"));
            bytes.add(new Byte("000010010"));
            return bytes;
        }
    }
}
