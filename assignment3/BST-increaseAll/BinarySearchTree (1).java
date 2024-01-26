public class BinarySearchTree {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  Node root;

  // Insert code here:
  public void incRec(Node node, int incVal){
    if(node == null){
      return;
    }
    
    node.data = node.data + incVal;
    incRec(node.left, incVal);
    incRec(node.right, incVal); 
  }

  public void increaseAll(int incVal){
    incRec(root, incVal);
  }




  

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    toStringHelper(root, sb);
    if (sb.length() != 1) {
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }

  private void toStringHelper(Node node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    toStringHelper(node.left, sb);
    sb.append(node.data);
    sb.append(", ");
    toStringHelper(node.right, sb);
  }

  public static void main(String[] args) {
    BinarySearchTree bst_3 = new BinarySearchTree();
    bst_3.root = new Node(4);
    bst_3.root.left = new Node(2);
    bst_3.root.left.left = new Node(1);
    bst_3.root.left.right = new Node(3);
    bst_3.root.right = new Node(6);
    bst_3.root.right.left = new Node(5);
    bst_3.root.right.right = new Node(7);
    // Prints [1, 2, 3, 4, 5, 6, 7]
    System.out.println(bst_3);
    bst_3.increaseAll(1);
    // Should print [2, 3, 4, 5, 6, 7, 8]
    System.out.println(bst_3);
  }
}
