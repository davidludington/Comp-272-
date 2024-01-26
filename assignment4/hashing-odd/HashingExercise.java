//David Ludington 
//Comp 272-002


import java.util.*;
class HashingExercise {

  // Your code here:
  public static ArrayList<String> odd(HashMap<Integer, String> map){
    ArrayList<String> odds = new ArrayList<>();
    

    for(int key : map.keySet()){
      if(key % 2 != 0){
        odds.add(map.get(key));
      }
      
    }
    return odds;
  }



  

  public static void main(String[] args) {
    HashMap<Integer, String> hash_map = new HashMap<>();
    hash_map.put(1, "Diana");
    hash_map.put(2, "Naomi");
    hash_map.put(3, "Adam");
    hash_map.put(4, "Eric");
    hash_map.put(5, "Kavitha");
    hash_map.put(6, "Yu");
    hash_map.put(7, "Mushjtaba");
    hash_map.put(8, "Marisa");
    hash_map.put(9, "Peter");
    hash_map.put(10, "Slanovich");
    // Should print: [Adam, Diana, Kavitha, Mushjtaba, Peter]
    System.out.println(odd(hash_map));
  }
}
