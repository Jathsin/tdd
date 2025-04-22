import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
  @DisplayName("If the list of numbers is empty the result is zero")
  @Test
  public void givenAnEmptyStringWhenAddThenReturnZero() {
    // Arrange
    StringCalculator sc = new StringCalculator();
    int expectedValue = 0 ;

    // Act
    int actualValue = sc.add("") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }
}
