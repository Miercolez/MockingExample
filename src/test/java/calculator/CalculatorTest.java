package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Adding empty string")
    void addingEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    @DisplayName("Adding one number")
    void addingOneNumber() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    @DisplayName("Adding two numbers")
    void addingTwoNumbers() {
        assertEquals(3, calculator.add("1,2"));
    }

}
