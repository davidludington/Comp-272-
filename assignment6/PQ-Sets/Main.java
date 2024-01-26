import java.util.PriorityQueue;
import java.util.Arrays;



class Solution {

    public <T> PriorityQueue<T> union(PriorityQueue<T> set1, PriorityQueue<T> set2) {

        // Add code here
      PriorityQueue<T> union = new PriorityQueue<T>();
      union.addAll(set1);
      union.addAll(set2);
      return union;
    }

    public <T> PriorityQueue<T> difference(PriorityQueue<T> set1, PriorityQueue<T> set2) {

        // Add code here
        PriorityQueue<T> difference = new PriorityQueue<T>();
      
        for(T ele: set1){
          if(!set2.contains(ele)){
            difference.add(ele);
          }
        }
        return difference;
    }

    public <T> PriorityQueue<T> intersection(PriorityQueue<T> set1, PriorityQueue<T> set2) {

        // Add code here 
      PriorityQueue<T> intersection = new PriorityQueue<T>();
      for(T ele: set1){
        if(set2.contains(ele)){
          intersection.add(ele);
        }
      }
        return intersection;
    }

}


public class Main {
    public static void main(String[] args) {

        PriorityQueue<String> queue1 = new PriorityQueue<>(Arrays.asList(
                "George", "Jim", "John", "Blake", "Kevin", "Michael"));
        PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList(
                "George", "Katie", "Kevin", "Michelle", "Ryan"));
        Solution s2 = new Solution();

        System.out.println("Unions of sets: " + s2.union(queue1, queue2) );
        System.out.println("Difference of sets: " + s2.difference(queue1, queue2) );
        System.out.println("Intersection of sets: " + s2.intersection(queue1, queue2) );
    }
}