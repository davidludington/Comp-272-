import java.nio.channels.NetworkChannel;
import java.util.*;

class Util {

    public boolean isSubset(int list1[], int list2[]) {

        // Code goes here ....
      HashSet<Integer> set = new HashSet<>();
      for(int num: list1){
        set.add(num);
      }

      for(int num: list2){
        if(!set.contains(num)){
          return false; 
        }
      }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {

      Util u = new Util();

      int list1[] = {1, 2, 5, 30, 20, 50};
      int list2[] = {2, 5, 50};

      System.out.println("Sample Test: " + u.isSubset(list1, list2));

    }
}