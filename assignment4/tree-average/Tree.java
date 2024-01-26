//David Ludington 
//COMP 272-002

import java.util.ArrayList;


public class Tree {

  public Tree() {
    root = null;
  }

  public Tree(int val) {
    root = new Node(val);
  }

  static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
    Node parent = null;

    public Node(int d) {
      data = d;
    }

    public Node addChild(int d) {
      Node n = new Node(d);
      n.setParent(this);
      children.add(n);
      return n;
    }

    public ArrayList<Node> getChildren() {
      return children;
    }

    public void setParent(Node p) {
      parent = p;
    }

    public Node getParent() {
      return parent;
    }
  }

  Node root = null;

  // Enter your code here:
  public double average(){
    int[] sum = {0};
    int[] count = {0};
    traverse(root, sum, count);
    if(count[0] == 0){
      return Double.NaN;
    }
    return (double) sum[0]/count[0];
  }

  public void traverse(Node n, int[] sum, int[] count){
    if(n == null){
      return;
    }
    sum[0] += n.data;
    count[0]++;
    for(Node child : n.getChildren()){
      traverse(child, sum, count);

    }
    
  }
  

  public static void main(String[] args) {
    Tree myTree = new Tree(1);
    Tree.Node n2 = myTree.root.addChild(2);
    Tree.Node n3 = myTree.root.addChild(3);
    n2.addChild(4);
    n2.addChild(5);
    n2.addChild(6);
    n3.addChild(7);
    n3.addChild(8);
    n3.addChild(9);
    // Should print 5.0
    System.out.println(myTree.average());
  }
}
