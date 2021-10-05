package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    private Scanner reader;

    @BeforeEach
    protected void setUp() {reader = new Scanner(System.in);}

    @Test
    protected void VALIDATE_OPTION_ENCODE() {
        String result = Input.validateOption(reader, "ENCODE");
        assertEquals("ENCODE", result);
    }

    @Test
    protected void VALIDATE_OPTION_DECODE() {
        String result = Input.validateOption(reader, "DECODE");
        assertEquals("DECODE", result);
    }

    @Test
    protected void VALIDATE_OPTION_EXIT() {
        String result = Input.validateOption(reader, "EXIT");
        assertEquals("EXIT", result);
    }
}