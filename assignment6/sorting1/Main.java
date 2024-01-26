import java.util.*;

public class Main {
    public static ArrayList<String> showDuplicates(ArrayList<String> input) {
        // Your code here
      ArrayList<String> duplicates = new ArrayList<>();

      for(int i = 0; i < input.size(); i++){
        String curr = input.get(i);
        for(int j = i + 1; j < input.size(); j++){
          if(curr.equals(input.get(j)) && !duplicates.contains(curr)){
            duplicates.add(curr);
          }
        }
      }
        return duplicates;
    }

    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("apple", "apple", "banana", "banana", "banana", "cherry", "cherry", "cherry", "cherry"));
        System.out.println(showDuplicates(test));  // Expected: [apple, banana, cherry]
    }
}


