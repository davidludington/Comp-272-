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
  
  public int maximumElement(){
    if(root == null){
      return -1;
    }

    Node current = root;

    while(current.right != null){
      current = current.right;
    }

    return current.data;
  }


  

  public static void main(String[] args) {
    BinarySearchTree bst_2 = new BinarySearchTree();
    bst_2.root = new Node(5);
    bst_2.root.left = new Node(3);
    bst_2.root.right = new Node(7);
    bst_2.root.left.left = new Node(2);
    bst_2.root.left.right = new Node(4);
    bst_2.root.right.left = new Node(6);
    bst_2.root.right.right = new Node(8);
    // Should print 8
    System.out.println(bst_2.maximumElement());
  }
}