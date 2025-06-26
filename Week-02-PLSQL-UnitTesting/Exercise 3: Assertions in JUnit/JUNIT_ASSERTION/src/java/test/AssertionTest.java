package com.example.test;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class AssertionTest {

	
	@Test
    public void testAssertions() {
        assertEquals(5, 2 + 3, "2 + 3 always equals  5");
        assertTrue(5 > 3, "True condition");
        assertFalse(5 < 3, "Fasle conditiom");
        assertNull(null, "Its null");
        assertNotNull(new Object(), "Not null");
    }
	
}
