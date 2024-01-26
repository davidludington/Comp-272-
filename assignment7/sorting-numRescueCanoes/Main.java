import java.util.Arrays;
class sorting{

/*
        You are given an array people where people[i] is the weight of 
        the ith person, and an infinite number of canoes where each canoe can
        carry a maximum weight of limit. Each canoe carries at most two people
        at the same time, provided the sum of the weight of those people is 
        at most limit.

        Return the minimum number of canoes to carry every given person.

        Example 1:
            Input: people = [1,2], limit = 3
            Output: 1
            Explanation: 1 boat (1, 2)

        Example 2:
            Input: people = [3,2,2,1], limit = 3
            Output: 3
            Explanation: 3 boats (1, 2), (2) and (3)

        Example 3:
            Input: people = [3,5,3,4], limit = 5
            Output: 4
            Explanation: 4 boats (3), (3), (4), (5)
 */

    public int numRescueCanoes(int[] people, int limit) {

      // Insert code here ...
      if(people.length == 0) return 0;
      
      Arrays.sort(people);
      int canoes = 0;
      int left = 0; // beginiing of the array ie lightest people
      int right = people.length - 1; //end of the people array i.e. heaviest people 

      while(left <= right){
        if(people[left] + people[right] <= limit){ //compares heaviest to lightest person
          left++;
          right--;
          canoes++;
        } else{
          right--; //indexes to the nest heviest person to compare them to the lightest person again
          canoes++;
        }
        
      }
      return canoes;
    }
}



public class Main {
    public static void main(String[] args) {
        sorting s = new sorting();

        int people[] = {3,2,2,1};

        System.out.println("Output: " + s.numRescueCanoes(people,3));
    }
}