//David Ludington 
//COMP 272-002

import java.util.*;

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

  // Your code here:

  public String traverseByLevel() {
    StringBuilder result = new StringBuilder();
    Queue<Node> queue = new LinkedList<>();

    if (root != null) {
      queue.add(root);

      while (!queue.isEmpty()) {
        Node currentNode = queue.poll();
        result.append(currentNode.data).append(" ");

        for (Node child : currentNode.getChildren()) {
          queue.add(child);
        }
      }
    }

    return result.toString().trim();
  }
  /*
  public String traverseByLevel(){
    String result = "";
    int h = getHeight(root);
    for(int i = 0; i < h; i++){
       result += returnCurrentLevel(root, i);
    }
    return result;
  }

  public int returnCurrentLevel(Node node, int level){
    if(root == null) return 0;
    if(level == 1){
      return root.data;
    }else if(level < 1){
      returnCurrentLevel(root.children.get(0), level - 1);
      returnCurrentLevel(root.children.get(1), level - 1);
    }
    return -1;
  }

  public int getHeight(Node node){
    if(root == null) return 0;
    else{
      int lHeight = getHeight(root.getChildren().get(0));
      int rHeight = getHeight(root.getChildren().get(1));

      if(lHeight > rHeight){
        return lHeight;
      }else{
        return rHeight;
      }
    }
  }
    */   




  

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
    // Should print: 1 2 3 4 5 6 7 8 9
    //System.out.print();
    System.out.println(myTree.traverseByLevel());
  }
}
