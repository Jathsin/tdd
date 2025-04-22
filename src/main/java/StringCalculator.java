import java.lang.reflect.Array;
import java.util.ArrayList;

public class StringCalculator {
  int add(String numbers) {
    int n = 0;
    if (!numbers.isEmpty()) {
      //Might have two numbers separated by comma
      String[] numbers_split = numbers.split(",");
      n = sumTokens(numbers_split);
    }
    return n;
  }

  //Auxiliar methods
  private int sumTokens(String[] numbers_split) {
    int n = 0;
    for(int i = 0 ; i < numbers_split.length ; i++) {
      n += Integer.parseInt(numbers_split[i]);
    }
    return n;
  }
}
