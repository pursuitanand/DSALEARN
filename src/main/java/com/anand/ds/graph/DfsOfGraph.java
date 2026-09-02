package com.anand.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * MANTRA : MARK (visited[node] = true;) → ADD (result.add(node);)→ LOOP (for (int neighbor : adj.get(node)))→ RECURSE if (!visited[neighbor]) { dfs(neighbor); }
 * Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][],
 * where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS)
 * traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list,
 * and return a list containing the DFS traversal of the graph.
 *
 * Note: Do traverse in the same order as they are in the given adjacency list.
 *
 * Examples:
 * Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]
 *
 * Output: [0, 2, 4, 3, 1]
 * Explanation: Starting from 0, the DFS traversal proceeds as follows:
 * Visit 0 → Output: 0
 * Visit 2 (the first neighbor of 0) → Output: 0, 2
 * Visit 4 (the first neighbor of 2) → Output: 0, 2, 4
 * Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3
 * Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1
 *
 * Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]
 *
 * Output: [0, 1, 2, 3, 4]
 * Explanation: Starting from 0, the DFS traversal proceeds as follows:
 * Visit 0 → Output: 0
 * Visit 1 (the first neighbor of 0) → Output: 0, 1
 * Visit 2 (the first neighbor of 1) → Output: 0, 1, 2
 * Visit 3 (the first neighbor of 2) → Output: 0, 1, 2, 3
 * Backtrack to 2 and visit 4 → Final Output: 0, 1, 2, 3, 4
 *
 * adj = [
 *     [2, 3, 1],   // neighbors of 0
 *     [0],         // neighbors of 1
 *     [0, 4],       // neighbors of 2
 *     [0],         // neighbors of 3
 *     [2]           // neighbors of 4
 * ]
 * Think of it as:
 * 0 → 2, 3, 1
 * 1 → 0
 * 2 → 0, 4
 * 3 → 0
 * 4 → 2
 */
public class DfsOfGraph {
    // DFS = Go as deep as possible, then backtrack.

    /**
     * magine you are exploring a maze:
     *
     * Enter a room.
     * Take the first unexplored door.
     * Keep going deeper.
     * When you hit a dead end, go back.
     * Try the next door.
     * @param adj
     * @return
     */
//    DFS(node):
//
//    1. Mark node visited
//    2. Put node into answer
//    3. Look at neighbors from left to right
//    4. If neighbor isn't visited → DFS(neighbor)
//    ALGORITHM:
//    DFS(node):
//      visited[node] = true
//      answer.add(node)
//
//      for neighbor in adj[node]:
//         if not visited[neighbor]:
//            DFS(neighbor)

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfsHelper(0,adj,visited,result);
        return result;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result){
        // MARK
        visited[node] = true;
        // ADD
        result.add(node);
        // LOOP Explore neighbors from left to right
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                // RECURSE
                dfsHelper(neighbor,adj,visited,result);
            }
        }
    }

    public static void main(String[] args) {
        DfsOfGraph dfsOfGraph = new DfsOfGraph();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1))); // neighbors of 0
        adj.add(new ArrayList<>(List.of(0)));       // neighbors of 1
        adj.add(new ArrayList<>(List.of(0, 4)));    // neighbors of 2
        adj.add(new ArrayList<>(List.of(0)));       // neighbors of 3
        adj.add(new ArrayList<>(List.of(2)));       // neighbors of 4

        ArrayList<Integer> result = dfsOfGraph.dfs(adj);
        System.out.println("DFS Traversal: " + result); // Output: [0, 2, 4, 3, 1]
    }
}
