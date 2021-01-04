package com.example.myPackage;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities utilities;

    @org.junit.Before
    public void setup(){
        utilities = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        assertArrayEquals(new char[] {'e', 'l'}, utilities.everyNthChar(new char[]{'h','e','l','l','o'},2));
        assertFalse(Arrays.equals(new char[] {'e', 'l'}, utilities.everyNthChar(new char[]{'h','e','l','l','o'},10)));
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertNull("Null is provided. We got this covered", utilities.removePairs(null));
        assertEquals("Ab", utilities.removePairs("Ab"));
        assertEquals("", utilities.removePairs(new String()));
        assertEquals("", utilities.removePairs(""));

    }

    @org.junit.Test (expected = ArithmeticException.class)
    public void converter_artihmeticExcepion() {
        utilities.converter(5,0);
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300,utilities.converter(10,5));
    }


    @org.junit.Test
    public void nullIfOddLength() {
        assertEquals("AAAA",utilities.nullIfOddLength("AAAA"));
        assertNull("Null was not found",utilities.nullIfOddLength("AAAAA"));
    }
}