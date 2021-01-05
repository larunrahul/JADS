package com.learning.ads.datastructure.graph.scc;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * Implementation of Kosaraju's strongly connected components for directed Graph
 * 
 * https://www.geeksforgeeks.org/strongly-connected-components/
 * 
 * https://cp-algorithms.com/graph/strongly-connected-components.html
 * 
 * Introduction to Algorithms, CLRS
 * 
 * Time complexity: O(|E| + |V|)
 * 
 * Space complexity: O(|V|)
 * 
 * @author Arun Rahul
 */
public class KosarajuSCC {

    private LinkedList<Integer> list = new LinkedList<>();

    List<List<Integer>> graph = new ArrayList<>();

    int N;

    public KosarajuSCC(int[][] edges, int vertices){
        graph = new ArrayList<>();
        this.N = vertices;
        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
        }
    }

    /**
     * 
     * Steps
     * 
     * 1) Run DFS of graph and not completed time for each vertext. Store them in
     * stack (we used LinkedList in following implementation) so that last completed
     * vertex is at top of stack.
     * 
     * 2) Create Transpose of input graph.
     * 
     * 3) Run DFS again and process edges in the order we pop out from stack.
     * 
     * @param adj
     * @param N
     * @return
     */
    public int stronglyConnectedComponents() {
        boolean[] visited = new boolean[N];

        // run dfs and prepare list of node in decreasing order of complete time
        for (int i = 0; i < N; i++) {
            if (!visited[i])
                dfs(graph, i, visited, true);
        }

        // prepare transpose of given graph
        List<List<Integer>> graphT = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graphT.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j : graph.get(i)) {
                graphT.get(j).add(i);
            }
        }

        visited = new boolean[N];
        int count = 0;

        // run dfs again in decreasing order of complete time
        while (!list.isEmpty()) {
            int i = list.pollFirst();
            if (!visited[i]) {
                dfs(graphT, i, visited, false);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean add) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour])
                dfs(graph, neighbour, visited, add);
        }
        if (add)
            list.offerFirst(node); // add to front of list
    }
}