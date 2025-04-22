import java.lang.reflect.Array;
import java.util.ArrayList;

public class StringCalculator {
  int add(String numbers) throws NegativeNumberException{
    int n = 0;
    if (!numbers.isEmpty()) {
      ArrayList<Integer> numbers_list = tokenize(numbers);
      //System.out.println(numbers_list);
      if (hasNegative(numbers_list)) {
        throw new NegativeNumberException("ERROR: found negative number");
      }
      n = sumTokens(numbers_list);
    }
    return n;
  }

  //Auxiliar methods
  private ArrayList<Integer> tokenize(String numbers) {
    String[] numbers_split = sepTokens(numbers);
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0 ; i < numbers_split.length ; i++) {
      list.add(Integer.parseInt(numbers_split[i]));
    }
    return list;
  }

  private boolean hasNegative(ArrayList<Integer> numbers_list) {
    int i = 0;
    while (i < numbers_list.size() && numbers_list.get(i)>= 0 ) {
      ++i;
    }
    return i < numbers_list.size();
  }

  private int sumTokens(ArrayList<Integer> numbers_list) {
    int n = 0;
    for(int i = 0 ; i < numbers_list.size() ; i++) {
      n += numbers_list.get(i);
    }
    return n;
  }

  private String[] sepTokens(String numbers) {
    String sep = ",|\n";
    String[] numbers_split;
    if (numbers.startsWith("//")) {
      sep = String.valueOf(numbers.charAt(2));
      numbers = numbers.substring(4);
    }
    return numbers.split(sep);
  }
}
