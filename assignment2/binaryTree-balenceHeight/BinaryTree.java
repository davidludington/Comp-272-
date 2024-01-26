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

  public int balanceHeight(Node node) {
    int leftHeight = 0;
    int rightHeight = 0;

    if(node == null){
      return 0;
    }

    leftHeight = height(node.left);
    rightHeight= height(node.right);

    if(Math.abs(leftHeight - rightHeight) <= 1 && (balanceHeight(node.left) != -1) && (balanceHeight(node.right) != -1)){ //checks difference between left and right tree heights and checks to see if that diffence is greater than 1(i.e tree is unbalanced) then recursively checks if the child nodes/subtrees 
      return height(root);
    }
    return -1;
  }

  public int height(Node node){ // method to determine height of tree
    if(node == null)
      return 0;

    return 1 + Math.max(height(node.left), height(node.right)); //recursivly adds 1 to the height as it goes down each child tree/node of the root 
  }



public static void main(String[] args) {
  BinaryTree myTree = new BinaryTree();

  myTree.root = new Node(50,
        new Node(30,
            new Node(20, 
                new Node(10, null, null),
                new Node(25, null, null)
            ),
            new Node(40,
                new Node(35, null, null),
                new Node(45, null, null)
            )
        ),
        new Node(70,
            new Node(65, null, null),
            new Node(80, 
                new Node(75, null, null),
                null
            )
        )
    );
    
    System.out.println(myTree.balanceHeight(myTree.root));
  //System.out.println(myTree.height(myTree.root));
  }
}
