package com.cegepst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;

public class InputTest {

    private Scanner reader;

    @BeforeEach
    public void setUp() {reader = new Scanner(System.in);}

    @Test
    public void VALIDATE_OPTION_ENCODE() {
        String result = Input.validateOption(reader, "ENCODE");
        assertEquals("ENCODE", result);
    }

    @Test
    public void VALIDATE_OPTION_DECODE() {
        String result = Input.validateOption(reader, "DECODE");
        assertEquals("DECODE", result);
    }

    @Test
    public void VALIDATE_OPTION_EXIT() {
        String result = Input.validateOption(reader, "EXIT");
        assertEquals("EXIT", result);
    }

    @Test
    public void VALIDATE_ENCODE_LENGTH() {
        Boolean result = Input.validateEncodelength("010001000001100101011101101");
        assertEquals(true, result);
    }

}