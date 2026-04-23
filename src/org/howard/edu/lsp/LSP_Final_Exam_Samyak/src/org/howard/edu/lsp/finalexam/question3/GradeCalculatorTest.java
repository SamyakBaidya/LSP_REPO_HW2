package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class GradeCalculatorTest {
    private final GradeCalculator calc = new GradeCalculator();

    @Test
    void testAverage() {
        assertEquals(90.0, calc.average(90, 90, 90));
    }

    @Test
    void testLetterGrade() {
        assertEquals("B", calc.letterGrade(85.5));
    }

    @Test
    void testIsPassing() {
        assertTrue(calc.isPassing(60.0));
    }

    @Test
    @DisplayName("Boundary Value: Minimum Passing")
    void testBoundaryPassing() {
        assertTrue(calc.isPassing(60.0));
        assertFalse(calc.isPassing(59.9));
    }

    @Test
    @DisplayName("Boundary Value: Max Score")
    void testBoundaryMax() {
        assertEquals(100.0, calc.average(100, 100, 100));
    }

    @Test
    void testExceptionLow() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-5, 50, 50));
    }

    @Test
    void testExceptionHigh() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(105, 50, 50));
    }
}