import org.testng.annotations.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
  StringCalculator sc;

  @BeforeEach
  public void setUp() {
    sc = new StringCalculator();
  }

  @AfterEach
  public void tearDown() {
    sc = null;
  }

  @DisplayName("If the list of numbers is empty the result is zero")
  @Test
  public void givenAnEmptyStringWhenAddThenReturnZero() {
    // Arrange
    int expectedValue = 0 ;

    // Act
    int actualValue = sc.add("") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }

  @DisplayName("If the list of numbers has only one number it returns that number")
  @Test
  public void givenAStringWithOneNumberReturnThatNumber() {
    // Arrange
    int expectedValue = 2 ;

    // Act
    int actualValue = sc.add("2") ;

    // Assert
    assertEquals(expectedValue, actualValue);
  }
}
