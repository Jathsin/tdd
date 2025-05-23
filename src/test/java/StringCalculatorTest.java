import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
  private StringCalculator sc;

  @BeforeEach
  void setUp() {
    sc = new StringCalculator();
  }

  @AfterEach
  void tearDown() {
    sc = null;
  }

  @DisplayName("If the list of numbers is empty the result is zero")
  @Test
  void givenAnEmptyStringWhenAddThenReturnZero() {
    // Arrange
    int expectedValue = 0 ;

    // Act
    int actualValue = sc.add("") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("If the list of numbers has only one number it returns that number")
  @Test
  void givenAStringWithOneNumberReturnThatNumber() {
    // Arrange
    int expectedValue = 2 ;

    // Act
    int actualValue = sc.add("2") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("If the list of numbers has two numbers separated by comma it returns the sum of both")
  @Test
  void givenAStringWithTwoNumbersReturnsSum() {
    // Arrange
    int expectedValue = 5 ;

    // Act
    int actualValue = sc.add("2,3") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("If the list of numbers has several numbers separated by comma it returns the total sum")
  @Test
  void givenAStringWithSeveralNumbersReturnsSum() {
    // Arrange
    int expectedValue = 8 ;

    // Act
    int actualValue = sc.add("1,2,3,2") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("The string has several numbers separated by commas or end of line")
  @Test
  void givenAStringWithSeveralNumbersSeparatedByCommasOrEndOfLine() {
    // Arrange
    int expectedValue = 8 ;

    // Act
    int actualValue = sc.add("1,2,3\n2") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("The string has several numbers separated by user defined delimiter")
  @Test
  void givenAStringWithSeveralNumbersSeparatedByUserDefinedDelimiter() {
    // Arrange
    int expectedValue = 8 ;

    // Act
    int actualValue = sc.add("//;\n2;1;3;2") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("The string has negative numbers, the method should throw NegativeNumberException")
  @Test
  void givenAStringWithNegativeNumbersThrowsException() {

    Exception exception =
            assertThrows(NegativeNumberException.class, () ->
                    sc.add("//;\n2;1;3;-2"));
    assertEquals("ERROR: found negative number", exception.getMessage());
  }
}
