import java.util.*;

class Solution {


    /*
       Assignment Graphing - Number of groups.
      
       There are n people. Some of them are connected as friends forming a group. 
       If person 'a' is connected to person 'b', and person 'b' is connected to 
       person 'c', they form a connected group.
      
       Not all groups are interconnected, meaning there can be 1 or more groups 
       depending on how people
       are connected.
      
       This example can be viewed as a graph problem, where people are represented 
       as nodes, and edges between them represent people being connected. In this 
       problem, we are representing this graph externally as an non-directed 
       Adjacency Matrix. And the graph itself may not be fully connected, it can 
       have 1 or more non-connected compoents (subgraphs).
      
       Example 1:
         Input : Adjacency Matrix = [ [0,1,0], [1,0,0], [0,0,0] ]
         Output: 2
         Explanation: The Adjacency Matrix defines an undirected graph of 3 nodes 
         (indexed 0 to 2). Where nodes 0 and 1 aee connected, and node 2 is NOT 
         connected. This forms two groups of nodes.
      
       Example 2:
         Input : Adjacency Matrix = [ [0,0,0], [0,0,0], [0,0,0] ]
         Output: 3
         Explanation: The Adjacency Matrix defines an undirected graph of 3 nodes 
         (indexed 0 to 2). There are no connected nodes, hence forming three groups.
      
       Example 3:
         Input : Adjacency Matrix = [ [0,1,0], [1,0,0], [0,1,0] ]
         Output: 1
         Explanation, The adjacency Matrix defined an undirected graph of 3 nodes 
         (index 0 to 2). All three nodes are connected by at least one edge. So they
         form on large group.
     */

    public int numGroups(int[][] adjMatrix) {
        int numNodes = adjMatrix.length;
        Map<Integer,List<Integer>> graph = new HashMap();
        int i = 0, j =0;

        /*
         * Converting the Graph Adjacency Matrix to an Adjacency List 
         * representation. This allows you to use either graph format!
         */

        for(i = 0; i < numNodes ; i++){
            for(j = 0; j < numNodes; j++){
                if( adjMatrix[i][j] == 1 && i != j ){
                    graph.putIfAbsent(i, new ArrayList());  // Add adjList for node i if not there
                    graph.putIfAbsent(j, new ArrayList());  // Add adjList for node j if not there.
                    graph.get(i).add(j);                    // Update node i's adjList to include node j
                    graph.get(j).add(i);                    // Update node j's adjList to include node i
                }
            }
        }


        // Insert code here ... based on code above, you now have two
        // graph representations in which you can utilize for coding this; 
        // either the adjacency matrix or adjaceny list. Both representions
        // define the SAME graph. The Adjaceny list should be easier to use 
        // though :)
      int count = 0;
      boolean[] visited = new boolean[numNodes];

      for(int v = 0; v < numNodes; v++){
        if(!visited[v]){
          count++;
          connected(graph, v, visited);
        }
      }
      
      
        return count;
    }

  private void connected(Map<Integer, List<Integer>> graph, int node, boolean[] visited){
    if(visited[node]){
      return;
    }

    visited[node] = true;

    if(graph.containsKey(node)){
      for(int n : graph.get(node)){
        connected(graph, n, visited);
      }
    }
  }
}


/*
 * Main Driver
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

 
        /*
         * Driver for method numGroups()
         */

        int[][] adjMatrix1 = new int[][] { {0,1,0}, {1,0,0}, {0,0,0} };
        int[][] adjMatrix2 = new int[][] { {0,0,0}, {0,0,0}, {0,0,0} };
        int[][] adjMatrix3 = new int[][] { {0,1,0}, {1,0,0}, {0,1,0} };

        System.out.println("Num of groups in g1: " 
                           + s.numGroups(adjMatrix1) ); // should be 2
        System.out.println("Num of groups in g2: " 
                           + s.numGroups(adjMatrix2) ); // should be 3
        System.out.println("Num of groups in g3: " 
                           + s.numGroups(adjMatrix3) ); // should be 1
    }
}