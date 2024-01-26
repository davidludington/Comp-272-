import java.util.*;

class Solution {

    /*
       To reach your goal of 'master programmer', you need to complete 'n'
       certification exams, each being specific to a topic. Some exams have 
       prerequisites of taking and passing earlier certificate exams.

       You can represent these 'n' tests as nodes in a graph, numbered from 0 to n-1. 
       And represent the prerequisite between taking exams as directed edges between 
       two nodes which represent those two exams.

       You are given an array exam prerequisites where prerequisites[i] = [ai, bi] 
       indicates that you must take exam bi first if you want to take exam ai.

       For example, the pair [0, 1], indicates that to take exam certification 0, 
       you have to first have the certification for exam 1.

       Return true if you can finish all certification exams. Otherwise, return false.


       Example 1:

       Input: numExams = 2, prerequisites = [[1,0]]
       Output: true
       Explanation: There are a total of 2 exams to take. To take exam 1 you should 
       have completed the certification of exam 0. So it is possible.

       Example 2:

       Input: numExams = 2, prerequisites = [[1,0],[0,1]]
       Output: false
       Explanation: There are a total of 2 exams to take. To take exam 1 you should 
       have completed the certification of exam 0, and to take exams 0 you should also 
       have completed the certification of exam 1. So it is impossible.
    */

    public boolean canFinish(int numExams, int[][] prerequisites) {
        int numNodes = numExams;                             // Number of nodes in graph
        ArrayList<Integer>[] adj 
                     = getAdjList(numExams, prerequisites);  // Build graph adjacency list

        // Add code here, if you detect a cycle in the directed graph, 
        // then return false, else return true. Note, all nodes
        // may not be connected (e.g., no prereq for an exam)

      boolean[] visited = new boolean[numNodes];
      boolean[] recStack = new boolean[numNodes];
      for(int i = 0; i < numNodes; i++){
        if(!visited[i] && hasCycle(i, adj, visited, recStack)){
          return false;
        }
      }

      
        return true;
    }

  private boolean hasCycle(int node, ArrayList<Integer>[] adj, boolean[] visited, boolean[] recStack){
    visited[node] = true;
    recStack[node] = true;

    for(int neighbor : adj[node]){
      if(!visited[neighbor]){
        if(hasCycle(neighbor, adj, visited, recStack)){
          return true;
        }
      } else if (recStack[neighbor]){
        return true;
      }
    }

    recStack[node] = false;
    return false;
  }

  
    /*
     * Building an Adjacency List for the directed graph based 
     * on number of nodes and passed in directed edged.
     */

    private ArrayList<Integer>[] getAdjList(int numNodes, int[][] edges){
        ArrayList<Integer>[] adj = new ArrayList[numNodes];

        for (int node = 0; node < numNodes; node++){
            adj[node] = new ArrayList<Integer>();
        }
        for (int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
}


/*
 * Main Driver
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        /*
         * Driver Code for method canFinish(), the driver builds 
         * simple directed graphs, where edges represent prereqs. 
         * NOTE: Your code should build more complex directed graphs.
         */

        int[][] g1 = new int[][] { {0,1} };          // Prereq edges for graph g1 of 2 nodes
        int[][] g2 = new int[][] { {1,0}, {0,1} };   // Prereq edges for graph g2 of 2 nodes
        int[][] g3 = new int[][] { {1,0}, {3,1} };   // Prereq edges for graph g3 of 4 nodes

        System.out.println("Graph g1 output: " + s.canFinish( 2, g1) ); // Should be true
        System.out.println("Graph g2 output: " + s.canFinish( 2, g2) ); // Should be false
        System.out.println("Graph g3 output: " + s.canFinish( 4, g3) ); // Should be true

        // Add more testing with and without cycles in directed 
        // graphs. Include larger directed graphs, 
        // as the JUnit tests will run more complex graphs. 
        // your code should work on more complex ones!


    }
}