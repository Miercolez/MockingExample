package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    //Step 3
    @Test
    @DisplayName("Adding with new lines")
    void addingWithNewLines() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    //Step 4
    @Test
    @DisplayName("Adding with different delimiters")
    void addingWithDifferentDelimiters() {
        assertEquals(3, calculator.add("//;\n1;2"));
        assertEquals(15, calculator.add("1/2\n3;4,5"));
    }

    //Step 5
    @Test
    @DisplayName("Adding negative numbers")
    void addingNegativeNumbers() {
        var illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> calculator.add("-4;-5"));

        assertEquals("negatives not allowed -4 -5", illegalArgumentException.getMessage());
    }

    //Step 6
    @Test
    @DisplayName("Excluding numbers bigger than 1000")
    void excludingNumbersBiggerThan1000() {
        assertEquals(4, calculator.add("1,1001,3,2005"));
    }


}
