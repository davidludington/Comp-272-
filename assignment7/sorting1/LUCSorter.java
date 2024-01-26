public class LUCSorter {

  private final int[] intArray;

  public LUCSorter(int[] intArray) {
    this.intArray = intArray;
  }

  public void sort() {
    // Add loop bounds
    for (int i = 0; i < intArray.length; i++) {
      int maxPos = maximumPosition(i);
      swap(maxPos, i);
    }
  }

  private int maximumPosition(int from) {
   // Add your code below
    int maxPos = from;
    for(int i = from + 1; i < intArray.length; i++){
      if(intArray[i] > intArray[maxPos]){
        maxPos = i;
      }
    }
    //System.out.println(maxPos);
    return maxPos;
  }

  private void swap(int i, int j) {
    int temp = intArray[i];
    intArray[i] = intArray[j];
    intArray[j] = temp;
  }

  // Check your code using this method
  public static int[] check(int[] values) {
    LUCSorter sorter = new LUCSorter(values);
    sorter.sort();
    return values;
  }
}

