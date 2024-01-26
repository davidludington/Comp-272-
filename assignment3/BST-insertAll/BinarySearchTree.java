public class BinarySearchTree {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
      //this.left = null;
      //this.right = null;
    }
  }

  Node root;

  // Insert code here:
  private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }
  
  public void insert(int val){
    root = insertRec(root, val);
  }

  public void insertAll(int[] array){
    for(int val : array){
      insert(val);
      //System.out.println(this);
    }
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
    BinarySearchTree bst_0 = new BinarySearchTree();
    int[] values = { 3, 4, 2, 1, 5 };
    // Prints []
    System.out.println(bst_0);
    bst_0.insertAll(values);
    //bst_0.insert(4);
    //bst_0.insert(7);
    //bst_0.insert(8);
    //System.out.println(bst_0);
    
    // Should print [1, 2, 3, 4, 5]
    System.out.println(bst_0);
  }
}