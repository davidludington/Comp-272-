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
  public String preOrder(Node node){
    String result = "";

    if(node == null){
      return result;
    }

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while(!stack.empty()){
      Node myNode = stack.peek();
      result += Integer.toString(myNode.data) + " ";
      stack.pop();

      if(myNode.right != null){
        stack.push(myNode.right);
      }
      if(myNode.left != null){
        stack.push(myNode.left);
      }
    }
    return result;
    
    
    /*
    String result = "";

    if(node == null){
      return result;
    }

    result += Integer.toString(node.data);

    preOrder(node.left);
    preOrder(node.right);

    return result;
  */
  }
  

  public String preOrder(){
    return preOrder(root);
  }


  public static void main(String[] args) {
    BinaryTree myTree = new BinaryTree();
    myTree.root = new Node(1,
        new Node(2,
            new Node(4, null, null),
            new Node(5, null, null)),
        new Node(3, null, null));

    System.out.println(myTree.preOrder());
  }
}