import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph2 {
  int numVertices;
  LinkedList<Integer>[] adjListArr;
  List<Integer> vertexValues;

  public Graph2(int numV) {
    numVertices = numV;
    adjListArr = new LinkedList[numVertices];
    vertexValues = new ArrayList<>(numVertices);

    for (int i = 0; i < numVertices; i++) {
      adjListArr[i] = new LinkedList<>();
      vertexValues.add(0);
    }
  }

  public void setValue(int vertexIndex, int value) {
    if (vertexIndex >= 0 && vertexIndex < numVertices) {
      vertexValues.set(vertexIndex, value);
    } else {
      throw new IllegalArgumentException("Invalid vertex index: " + vertexIndex);
    }
  }

  public void addEdge(int src, int dest) {
    adjListArr[src].add(dest);
  }

  public void printGraph() {
    System.out.println("Adjacency Matrix Representation:");
    int[][] matrix = new int[numVertices][numVertices];

    for (int i = 0; i < numVertices; i++) {
      for (Integer dest : adjListArr[i]) {
        matrix[i][dest] = 1;
      }
    }

    System.out.print("  ");
    for (int i = 0; i < numVertices; i++) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < numVertices; i++) {
      System.out.print(i + " ");
      for (int j = 0; j < numVertices; j++) {
        if (matrix[i][j] == 1) {
          System.out.print("| ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
  }

  
  public int findRoot() {
    // Add your code here:
    int count = 0;
    int root = -1;
    int[] incomingEdges = new int[numVertices];
    for(int i = 0; i < numVertices; i++){
      for(Integer dest : adjListArr[i]){
        incomingEdges[dest]++;
      }
    }

    for(int i = 0; i < numVertices; i++){
      if(incomingEdges[i] == 0){
        count++;
        root = i;
      }
    }
    if(count != 1) return -1;

    return vertexValues.get(root);
  }
 
}
