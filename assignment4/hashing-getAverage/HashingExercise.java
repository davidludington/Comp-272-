//David Ludington
//Comp 272-002

import java.util.*;
class HashingExercise {

    // Your code here:
  public static double getAverage(HashMap<Integer, Integer> map, int[] arr){
    int sum = 0;
    int count = 0;

    
    for(int index : arr){
      if(map.containsKey(index)){
        sum += map.get(index);
        count++;
      }
    }

    if(count == 0){
      return 0.0;
    }

    return (double) sum/count;
  }


  
  
    public static void main(String[] args) {
        HashMap<Integer, Integer> hash_map2 = new HashMap<>();
        hash_map2.put(1, 10);
        hash_map2.put(2, 20);
        hash_map2.put(5, 50);
        int[] arr = {1, 2, 7, 8};
      // Should print 15.0
        System.out.println(getAverage(hash_map2, arr));
    }
}
