//David Ludington 
//COMP 272 002
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

  public void replaceValues(int k, int l) {
    replaceValues(root, k, l);
  }

  public void replaceValues(Node node,int k, int l) { //helper method to allow for recursive traversal of tree
    if(node == null){
      return;
    }

    replaceValues(node.left, k, l);

    if(node.data == k){
      node.data = l;
    }

    replaceValues(node.right, k, l);
    
  }

  public String toString() {
    return toStringHelper(root);
  }

  private String toStringHelper(Node n) {
    if (n == null) {
      return "";
    }
    return n.data + " " + toStringHelper(n.left) + toStringHelper(n.right);
  }

  public static void main(String[] args) {
    BinaryTree myTree = new BinaryTree();
    myTree.root = new Node(105,
        new Node(20,
            new Node(30, null, null),
            new Node(160,
                new Node(50,
                    new Node(90, null, null),
                    new Node(160, null, null)),
                null)),
        new Node(80, null, null));
    System.out.println(myTree);
    myTree.replaceValues(160, 0);
    System.out.println(myTree);
  }
}