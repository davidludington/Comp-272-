import java.util.Stack;

public class Stacks {
    public static boolean isPalindrome(String input) {
      Stack<Character> myStack = new Stack<>(); //creates stack to put characters into that will poped off in reverse order 
      input = input.toLowerCase(); //removes case sensitivity 
      input = input.replaceAll(" ", ""); //removes spaces 
      String reverse = ""; // strign to pop stack into 
      for(int i = 0; i < input.length(); i++){ // for loop to push string onto the stack
        myStack.push(input.charAt(i));
      }

      while(!myStack.empty()){ //pops characters from stack onto string in reverse order compared to input string
        reverse += myStack.pop();
      }
      //System.out.println(reverse);

      if(input.equals(reverse)) // compares input to reversed string 
        return true;
      else{
        return false;
      }
      
    }

    public static int findLargestK(Stack<Integer> stack, int k) {
      
      int kIndex = -1; //initalizes k 
      for(int i = 0; i < stack.size(); i++){ //indexes through stack changing kIndex as it finds elemests of the stack that are equal to k parameter 
        if(stack.get(i) == k){
          kIndex = i;
        }
      }

      return kIndex;
    }

    public static void main(String[] args) {
        String testString = "Race Car";
      // Should print true
        System.out.println(isPalindrome(testString));

        Stack<Integer> myStack = new Stack<>();
        myStack.push(5);
        myStack.push(3);
        myStack.push(1);
        myStack.push(4);
        myStack.push(1);
        System.out.println(myStack);
      // Should print 4
        System.out.println(findLargestK(myStack, 1));
    }
}
