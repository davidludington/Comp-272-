import java.util.*;

public class TreeMapProblem {

  // Insert code here:
  public static TreeMap<Integer, String> removeEven(Map<Integer, String> inputMap){
    TreeMap<Integer, String> noEven = new TreeMap<>();
    
    for(Map.Entry<Integer, String> person: inputMap.entrySet()){
      Integer key = person.getKey();
      if(key % 2 != 0){
        noEven.put(key, person.getValue());
      }
    }
    return noEven;
  }





  

  public static void main(String[] args) {
    Map<Integer, String> ages = new TreeMap<>();
    ages.put(10, "James");
    ages.put(13, "Tony");
    ages.put(15, "Britany");
    ages.put(16, "Maria");
    ages.put(17, "Geoffrey");
    System.out.println(ages);
    // Should print {13=Tony, 15=Britany, 17=Geoffrey}
    System.out.println(removeEven(ages));
  }
}
