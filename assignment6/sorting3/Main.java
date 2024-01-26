import java.util.*;
    /**
     * Finds pairs in the input array that add up to k.
     * 
     * @param input Array of integers
     * @param k     The sum to find pairs for
     * @return A list of strings, each string is a pair in the format "(a, b)"
     */
public class Main {
    public static ArrayList<String> pair(int[] input, int k) {
        // Your code here
           
      ArrayList<String> pairs = new ArrayList<String>();

      //Hash set to know what numbers have been added 
      HashSet<Integer> addedNums = new HashSet<Integer>();
      
  
      for(int i = 0; i < input.length; i++){
        int num = input[i];
        for(int j = i + 1; j < input.length; j++){
          if(num + input[j] == k && !addedNums.contains(num) && !addedNums.contains(input[j])){
            addedNums.add(num);
            addedNums.add(input[j]);
            pairs.add("(" + num + ", " + input[j] + ")");
          }
        }
      }
        
        return pairs;
    }



  public static void main(String[] args) {
    int[] input = new int[]{2, 3, 3, 4, 5, 6, 7};
    int k = 9;
    ArrayList<String> result = pair(input, k);
    System.out.println(result);
  }
}