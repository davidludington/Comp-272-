public class Main {
  public static void main(String[] args) {
    Graph1 graph = new Graph1(8);

    graph.setValue(0, 2);
    graph.setValue(1, 4);
    graph.setValue(2, 100);
    graph.setValue(3, -1000);
    graph.setValue(4, 100);
    graph.setValue(5, 26);
    graph.setValue(6, -5);
    graph.setValue(7, 10);

    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 5);
    graph.addEdge(5, 4);
    graph.addEdge(5, 6);
    graph.addEdge(6, 7);
    graph.addEdge(4, 1);
    graph.addEdge(4, 3);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);

    graph.printGraph();

    System.out.println(graph.maxAndCount(0));
  }
}
