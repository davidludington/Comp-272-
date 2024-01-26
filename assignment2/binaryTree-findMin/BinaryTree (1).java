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

  public int findMin() {
    return findMin(root);
  }

  public int findMin(Node node) {
    int min = Integer.MAX_VALUE; // sets min to greatest int
    if(node == null){
      return min;
    }
    Stack<Node> stack = new Stack<>(); //creates stack to push nodes onto
    stack.push(root);
  /*
    does comparison 
    pushes right child node
    pushes left child node
    does comparison preoder 
      */
    while(!stack.empty()){
      Node myNode = stack.peek();
      if(myNode.data < min){ //does comparison 
        min = myNode.data;
      }
      stack.pop();

      if(myNode.right != null){
        stack.push(myNode.right);
      }
      if(myNode.left != null){
        stack.push(myNode.left);
      }
    }
    return min;
  }
  

  public static void main(String[] args) {
    BinaryTree myTree = new BinaryTree();
    myTree.root = new Node(10,
        new Node(5,
            new Node(20, null, null),
            new Node(25,
                new Node(15,
                    new Node(30, null, null),
                    new Node(35, null, null)),
                null)),
        new Node(40, null, null));
    System.out.println(myTree.findMin());
  }
}