import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

class Graph1 {
  int numVertices;
  LinkedList<Integer>[] adjListArr;
  List<Integer> vertexValues;

  public Graph1(int numV) {
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

  public int maxAndCount(int vertexIndex) {
    // Add your code here:
    
    int count = 0; 
    boolean[] visited = new boolean[numVertices];
    int[] values = new int[numVertices];
    Arrays.fill(values, Integer.MIN_VALUE);
    int max = dfs(vertexIndex, visited, values);

    for(int value : values){
      if(value == max){
        count++;
      }
    }
    System.out.println("max: " + max);
    System.out.println("count: " + count);

    for(int i = 0; i < values.length; i++){
      System.out.print(values[i] + " ");
    }
    System.out.println();
    return count * max;
  }

  
  private int dfs(int v, boolean[] visited, int[] values){
    visited[v] = true;

    Iterator<Integer> i = adjListArr[v].listIterator();
    int max = Integer.MIN_VALUE;
    while(i.hasNext()){
      int n = i.next();
      if(!visited[n]){
        int temp = dfs(n, visited, values);
        max = Math.max(max, temp);
      }
      
    }
    values[v] = Math.max(values[v], max);
    return Math.max(vertexValues.get(v), max);
  }
  


  

}