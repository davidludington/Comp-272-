import java.util.PriorityQueue;
import java.util.Collections;


class Solution {

    public int lastBoulder(int[] boulders) {

        // Add code here
      if(boulders.length == 0) return -1;
      
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

      for(int boulder : boulders){
        maxHeap.offer(boulder);
      }

      

      while(maxHeap.size() > 1){
        int x = maxHeap.poll();
        int y = maxHeap.poll();
        //System.out.print(x + " " + y + " " + "*");

        int remaningWeight = Math.abs(x - y);
        if(remaningWeight > 0){
          maxHeap.offer(remaningWeight);
        }
      }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}


public class Main {
    public static void main(String[] args) {

      Solution s1 = new Solution();
      int list[] = {2,7,4,1,8,1};
      int list2[] = {};

      System.out.println("Output: " + s1.lastBoulder(list));
      System.out.println("Output: " + s1.lastBoulder(list2));
      
    }
}