import java.util.*;

class Util {
  
  public int[] sort2Arrays(int[] array1, int[] array2) {

    // Code goes here, use a priority queue to help sort the arrays
    
    int[] sortedArray = new int[array1.length + array2.length];

    for(int i = 0; i < array1.length; i++){
      sortedArray[i] = array1[i];
    }

    for(int i = 0; i < array2.length; i++){
      sortedArray[i + array1.length] = array2[i];
    }

    Queue<Integer> pq1 = new PriorityQueue<>();
    for(int num: sortedArray){
      pq1.add(num);
    }

    for(int i = 0; i < sortedArray.length; i++){
      sortedArray[i] = pq1.poll();
    }
    
    

  return sortedArray;
  }
}


public class Main {
  
    public static void main(String[] args) {
       Util u = new Util();
      
       /* 
        * Sample array parameters
        */
      
       int list1[] = {4,1,5};
       int list2[] = {3,2};;
       int sorted[];

       /*
        * Sort the  2 arrays 
        */
       sorted = u.sort2Arrays(list1, list2);

       /*
        * Print the combined sorted array
        */
      
       for (int i=0; i < sorted.length ; i++)
         System.out.print(sorted[i] + " ");
       System.out.println();
      
    }
}