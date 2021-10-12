package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    private Translator translator;

    @BeforeEach
    public void SETUP() {
        translator = new Translator();
    }

    @Test
    public void CONVERT_MESSAGE_TO_BINARY_SHORT_MESSAGE() {
        String result = translator.convertMessageToBinary("Jeremy");
        assertEquals("010010100110010101110010011001010110110101111001", result);
    }

    @Test
    public void CONVERT_MESSAGE_TO_BINARY_LONG_MESSAGE() {
        String result = translator.convertMessageToBinary("Mon nom est Jérémy Fontaine-Ethier.");
        assertEquals("0100110101101111011011100010000001101110011011110110110100100000011001010111001101110100001000000100101011101001011100101110100101101101011110010010000001000110011011110110111001110100011000010110100101101110011001010010110101000101011101000110100001101001011001010111001000101110", result);
    }

    @Test
    public void CONVERT_BINARY_TO_MESSAGE_SHORT() {
        ArrayList<Byte> bytes = initShortBinaryArray();
        ArrayList<Character> result = translator.convertBytesToCharacters(bytes, new ArrayList<Character>());
        assertEquals('a', result.get(0));
    }

    @Test
    public void CONVERT_BINARY_TO_MESSAGE_LONG() {
        ArrayList<Byte> bytes = initLongBinaryArray();
        ArrayList<Character> result = translator.convertBytesToCharacters(bytes, new ArrayList<Character>());
        assertEquals('a', result.get(0));
        assertEquals('b', result.get(1));
        assertEquals('c', result.get(2));
        assertEquals('d', result.get(3));
        assertEquals('e', result.get(4));
        assertEquals('f', result.get(5));
        assertEquals('g', result.get(6));
        assertEquals('h', result.get(7));
        assertEquals('i', result.get(8));
        assertEquals('j', result.get(9));
        assertEquals('k', result.get(10));
    }

    private ArrayList<Byte> initShortBinaryArray() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("01100001"));
        return bytes;
    }

    private ArrayList<Byte> initLongBinaryArray() {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        bytes.add(new Byte("01100001"));
        bytes.add(new Byte("01100010"));
        bytes.add(new Byte("01100011"));
        bytes.add(new Byte("01100100"));
        bytes.add(new Byte("01100101"));
        bytes.add(new Byte("01100110"));
        bytes.add(new Byte("01100111"));
        bytes.add(new Byte("01101000"));
        bytes.add(new Byte("01101001"));
        bytes.add(new Byte("01101010"));
        bytes.add(new Byte("01101011"));
        return bytes;
    }
}
