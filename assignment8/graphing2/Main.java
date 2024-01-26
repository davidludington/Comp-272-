public class Main {
  public static void main(String[] args) {
    Graph2 graph = new Graph2(6);

    graph.setValue(0, 10);
    graph.setValue(1, 20);
    graph.setValue(2, 30);
    graph.setValue(3, 40);
    graph.setValue(4, 50);
    graph.setValue(5, 60);

    graph.addEdge(3, 4);
    graph.addEdge(4, 5);
    graph.addEdge(4, 2);
    graph.addEdge(2, 5);
    graph.addEdge(5, 1);
    graph.addEdge(1, 0);
    graph.addEdge(1, 2);

    graph.printGraph();

    int rootValue = graph.findRoot();
    if (rootValue == -1) {
      System.out.println("There is no root vertex in the graph.");
    } else {
      System.out.println("The value at the root vertex of the graph is: " + rootValue);
    }
  }
}
