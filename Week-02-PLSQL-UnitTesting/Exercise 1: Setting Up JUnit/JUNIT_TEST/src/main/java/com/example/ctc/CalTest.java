package com.example.ctc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalTest {

	@Test
    void testAdd() {
        Cal calc = new Cal();
        int result = calc.add(3, 2);
        assertEquals(5, result);
    }

}
