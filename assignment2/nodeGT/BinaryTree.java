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

  public int NodesGT(int val) {
    return NodesGT(root, val);
  }

  public int NodesGT(Node node, int val) { //helper method to recursivly traverse the tree 
    int gt = 0;
    if(node == null){
      return gt;
    }
    /*

    if(node.data > val){
      gt++;
    }

    if(node.right != null){
      NodesGT(node.right, val);
    }
    if(node.left != null){
      NodesGT(node.left, val);
    }
    */

    
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while(!stack.empty()){
      Node myNode = stack.peek();
      if(myNode.data > val){
        gt++;
      }
      stack.pop();

      if(myNode.right != null){
        stack.push(myNode.right);
      }
      if(myNode.left != null){
        stack.push(myNode.left);
      }
    }
    return gt;
  }


  public static void main(String[] args) {
    BinaryTree myTree = new BinaryTree();
    myTree.root = new Node(88,
        new Node(29,
            new Node(42, null, null),
            new Node(5,
                new Node(17,
                    new Node(99, null, null),
                    new Node(987, null, null)),
                null)),
        new Node(34, null, null));
    System.out.println(myTree.NodesGT(17));
  }
}