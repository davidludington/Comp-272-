import java.util.*;

public class TreeSetProblem {

  // Insert code here:
  public static Set different(Set<Integer> a,Set<Integer> b){
    Set<Integer> result = new TreeSet<>();

    for(int ele : a){
      if(!b.contains(ele)){
        result.add(ele);
      }
    }

    for(int ele : b){
      if(!a.contains(ele)){
        result.add(ele);
      }
    }
    
    return result;
  }





  

  public static void main(String[] args) {
    Set<Integer> treeSet0 = new TreeSet<>();
    treeSet0.add(9);
    treeSet0.add(7);
    treeSet0.add(6);
    treeSet0.add(3);
    Set<Integer> treeSet1 = new TreeSet<>();
    treeSet1.add(4);
    treeSet1.add(7);
    treeSet1.add(6);
    treeSet1.add(2);

    System.out.println(treeSet0);
    System.out.println(treeSet1);
    // Should print [2, 3, 4, 9]
    System.out.println(different(treeSet0, treeSet1));
  }

}
