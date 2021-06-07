package com.learning.ads.datastructure.graph.scc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of Tarjan's strong connected components for directed graph
 * 
 * https://sites.google.com/site/indy256/algo/scc_tarjan
 * 
 * One more similar optimization can be found at
 * https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/TarjanSccSolverAdjacencyList.java
 * 
 * Time complexity: O(|E| + |V|)
 * 
 * Space complexity: O(|V|) since we need 1 extra arrays one for lowlink apart
 * from implicit stack used by dfs, all of size |v|. Hence 2 * |V| = O(|V|).
 * 
 * @author Arun Rahul
 */
public class TarjanSCCOptimized {
    private int time = 0;
    LinkedList<Integer> stack = new LinkedList<>();
    int[] lowlink;
    int sccCount = 0;
    List<List<Integer>> graph = new ArrayList<>();
    int N;

    public TarjanSCCOptimized(int[][] edges, int N) {
        lowlink = new int[N];
        this.N = N;

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
    }

    /**
     * 1) Run DFS on graph. While running keep track of all the vertices that are
     * part of current dfs tree in stack. Nodes are placed on a stack in the order
     * in which they are visited.
     * 
     * When the depth-first search recursively visits a node v and its descendants,
     * those nodes are not all necessarily popped from the stack when this recursive
     * call returns. The crucial invariant property is that a node remains on the
     * stack after it has been visited if and only if there exists a path in the
     * input graph from it to some node earlier on the stack. In other words, it
     * means that in the DFS a node would be only removed from the stack after all
     * its connected paths have been traversed. When the DFS will backtrack it would
     * remove the nodes on a single path and return to the root in order to start a
     * new path.
     * 
     * lowlink[] represents the smallest index of any node known to be reachable
     * from v through v's DFS subtree, including v itself
     * 
     * @return
     */
    public int stronglyConnectedComponents() {
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (lowlink[i] == 0)
                sccTarjan(graph, i);
        }
        return sccCount;
    }

    private void sccTarjan(List<List<Integer>> graph, int node) {
        lowlink[node] = ++time;
        stack.addFirst(node);
        boolean isRoot = true;
        for (int neighbour : graph.get(node)) {
            /**
             * A lowlink value of zero represens unvisited node. If neighbour is unvisited,
             * visit it. In otherwords this is tree edge.
             */
            if (lowlink[neighbour] == 0)
                sccTarjan(graph, neighbour);
            /**
             * if lowlink of neighbour is less than current node, then current node can
             * reach to the lowlink ancestor through this neighbour. Hence update lowlink
             * value of current node with that of neighbour node.
             * 
             * If we are updating that means this is not the root since for root lowlink
             * value doesn't change as there is no child of root's sub tree which can reach
             * root's ancestor.
             */
            if (lowlink[neighbour] < lowlink[node]) {
                lowlink[node] = lowlink[neighbour];
                isRoot = false;
            }
        }
        /*
         * we do not remove the nodes from the stack always when we backtrack. As shown
         * below, we remove all nodes in stack only when we find the root of current
         * SCC.
         */
        if (isRoot) {
            sccCount++;
            int n = -1;
            List<Integer> list = new ArrayList<>();
            while (n != node) {
                n = stack.removeFirst();
                /**
                 * This is must. If we don't set this, when we are processing some other SCC,
                 * the second "if" condition in line 91 above runs and gives wrong values since
                 * lowlink value of this node is less than that of future node which we process
                 * in other scc.
                 * 
                 * Run it through example graph {{1, 2}, {2, 0}, {2, 2}} which shows why the
                 * following line is needed.
                 */
                lowlink[n] = Integer.MAX_VALUE;
                list.add(n);
            }
            System.out.print(list + " ");
        }
    }
}
