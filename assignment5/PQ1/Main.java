
import java.util.*;

class Util {
  
  public int findKthLargest(int[] array, int k) {

    // Code goes here, use a priority queue to help
    Queue<Integer> pq = new PriorityQueue<>();
    
    for(int num: array){
      pq.add(num);
    }

    int kthLargest = Integer.MIN_VALUE;
    while(k > 0){
      kthLargest = pq.poll();
      k--;
    }
    
    return kthLargest;
  }
}


public class Main {
  
    public static void main(String[] args) {
       Util u = new Util();
      
       /* 
        * Sample parameters
        */
      
       int list[] = {1,7,3,10,34,5,8};
       int k = 4;

       /*
        * Output the kth largest number 
        */
      
       System.out.println("The " + k + " largest value is: " + u.findKthLargest(list, k));
    }
}