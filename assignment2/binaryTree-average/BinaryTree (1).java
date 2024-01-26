//David Ludington 
//COMP 272 002
import java.util.Stack;
public class BinaryTree {

  public BinaryTree() {
    root = null;
  }

  public BinaryTree(Node node) {
    root = node;
  }

  static class Node {

    Node(int d, Node l, Node r) {
      data = d;
      left = l;
      right = r;
    }

    public int data;
    public Node left;
    public Node right;
  }

  public Node root;

  public double average() {
    if(root == null){
      return Double.NaN;
    }
    return average(root);
  }

  public double average(Node node) {
    double total = 0;
    int numEle = 0;
    if(node == null){
      return 0.0;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while(!stack.empty()){
      Node myNode = stack.peek();
      total += myNode.data;
      numEle++;
      stack.pop();

      if(myNode.right != null){
        stack.push(myNode.right);
      }
      if(myNode.left != null){
        stack.push(myNode.left);
      }
    }
    return total/numEle;
    
  }

  public static void main(String[] args) {

    BinaryTree myTree = new BinaryTree();
    myTree.root = new Node(1,
        new Node(2,
            new Node(3, null, null),
            new Node(10,
                new Node(9,
                    new Node(8, null, null),
                    new Node(7, null, null)),
                null)),
        new Node(6, null, null));
    // Should print out 5.75
    System.out.println(myTree.average());
  }
}