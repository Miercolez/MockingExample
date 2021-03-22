package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    //Step 1
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

    //Step 2
    @ParameterizedTest
    @CsvSource(value =
            {"1,2,3:6"
                    , "1,2,3,4:10"
                    , "1,2,3,4,5:15"
                    , "1,2,3,4,5,6:21"
                    , "1,2,3,4,5,6,7:28"}
            , delimiter = ':')
    @DisplayName("Adding multiple numbers")
    void addingMultipleNumbers(String input, int expected) {
        assertEquals(expected, calculator.add(input));
    }


}
