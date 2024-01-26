import java.util.PriorityQueue;
import java.util.Collections;
class sorting{

    /*
        Given an array of integers citations where citations[i] is 
        the number of citations a researcher received for their 
        ith paper, return the researcher's h-index.

        According to the definition of h-index on Wikipedia: The 
        h-index is defined as the maximum value of h such
        that the given researcher has published at least h papers 
        that have each been cited at least h times.

        The solution should use the counting bucket sort algorithm.

        Example 1:
            Input: citations = [3,0,6,1,5]
            Output: 3
            Explanation: [3,0,6,1,5] means the researcher has 5 
            papers in total and each of them had received 3, 0, 6, 
            1, 5 citations respectively. Since the researcher has 3 
            papers with at least 3 citations each and the remaining
            two with no more than 3 citations each, their h-index 
            is 3.

        Example 2:
            Input: citations = [1,3,1]
            Output: 1
     */

    public int hIndex( int[] citations) {
      
        // Code goes here ....

      /*
      this code uses a priorty queue to sort the array in descending order, then iterates over the array and increments the h index if the current element is greater than or equal to the index of the current iteration.
        */
      if(citations.length == 0)
        return 0;
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      int h = 0;
      for(int num : citations){
        maxHeap.add(num);
      }

      for(int i = 0; i < citations.length; i++){
        citations[i] = maxHeap.poll();
      }
      //itterating over entire list 
      
      for(int i = 0; i < citations.length; i++){
        if(citations[i] >= i + 1){
          h++;
        }
      }

      /*
      //using binary search
      int low = 0; 
      int high = citations.length - 1;
      while(low <= high){
        int mid = (low + high) / 2;

        if(citations[mid] >= (mid + 1)){
          h++;
          low = mid + 1; //check right of mid
        } else{
          high = mid - 1; //check to left of mid
        }
      }
      */
      
      return h;
    }


}



public class Main {
    public static void main(String[] args) {
        sorting s = new sorting();

        int citation[] = {3, 0, 6, 1, 5};
        int citation1[] = {1,3,1};
      
        System.out.println("Output " + s.hIndex(citation));
        System.out.println("Output " + s.hIndex(citation1));

    }
}
