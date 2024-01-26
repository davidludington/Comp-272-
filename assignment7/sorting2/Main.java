import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    // Code for testing
    int[][] testArrays = {
        { 10, 3, 25, 8, 6 },
        { 15, 13, 11, 14, 20 },
        { 2, 4, 6, 8, 10, 1, 3, 5, 7, 9 },
        { 30, 45, 22, 9, 18, 39, 6, 12 },
        { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
    };

    int[] testKs = { 5, 3, 2, 6, 4 };

    for (int i = 0; i < testArrays.length; i++) {
      int[] testArray = testArrays[i];
      int k = testKs[i];

      System.out.println("Input array: " + Arrays.toString(testArray) + ", k = " + k);

      LUCSorter.check(testArray, k);

      System.out.println("Output array: " + Arrays.toString(testArray) + "\n");
    }
    
  }
}