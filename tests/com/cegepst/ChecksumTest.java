//package com.cegepst;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ChecksumTest {
//
//    private Checksum checksum;
//
//    @BeforeEach
//    public void setUp() {
//        checksum = new Checksum();
//    }
//
//    @Test
//    void START_OPTION_ENCODE() {
//        Boolean result = checksum.startOption("ENCODE");
//        assertEquals(true, result);
//    }
//
//    @Test
//    void START_OPTION_DECODE() {
//        Boolean result = checksum.startOption("DECODE");
//        assertEquals(true, result);
//    }
//
//    @Test
//    void START_OPTION_EXIT() {
//        Boolean result = checksum.startOption("EXIT");
//        assertEquals(false, result);
//    }
//}
