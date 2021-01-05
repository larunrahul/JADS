package com.learning.ads.datastructure.graph.scc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of Tarjan's strong connected components for directed graph
 * 
 * https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components
 * 
 * https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm
 * 
 * Time complexity: O(|E| + |V|)
 * 
 * Space complexity: O(|V|) since we need 3 extra arrays one for lowlink, index,
 * stack apart from implicit stack used by dfs, all of size |v|. Hence 4 * |V| =
 * O(|V|).
 * 
 * An optimized (but asymptotically same) version of Tarjan's algorithms is at
 * {@link TarjanSCCOptimized}
 * 
 * @author Arun Rahul
 */
public class TarjanSCC {

    private int time = 0;
    LinkedList<Integer> stack = new LinkedList<>();
    int[] lowlink, index;
    boolean[] stackPresence;
    int sccCount = 0;
    List<List<Integer>> graph = new ArrayList<>();
    int N;

    public TarjanSCC(int[][] edges, int N) {
        lowlink = new int[N];
        index = new int[N];
        stackPresence = new boolean[N];
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
            if (index[i] == 0)
                sccTarjan(graph, i);
        }
        return sccCount;
    }

    private void sccTarjan(List<List<Integer>> graph, int node) {
        index[node] = ++time;
        lowlink[node] = index[node];
        stack.addFirst(node);
        stackPresence[node] = true;
        for (int neighbour : graph.get(node)) {
            // if neighbour is unvisited, visit it. In otherwords this is tree edge
            if (index[neighbour] == 0) { // unvisited
                sccTarjan(graph, neighbour);
                /**
                 * after visiting, if neighbour can reach to a node above this node in dfs tree
                 * (in otherwords ancestor of this node), update current nodes lowlink value
                 * with it.
                 * 
                 * In otherwords if lowlink of neighbour is less than current node, then current node can
                 * reach to the lowlink ancestor through this neighbour. Hence update lowlink
                 * value of current node with that of neighbour node.
                 */
                lowlink[node] = Math.min(lowlink[node], lowlink[neighbour]);
            } else if (stackPresence[neighbour]) { // is present on current stack

                /**
                 * If this neighbour is present in the stack, it means we are visiting a
                 * neighbour which is already present in current dfs tree. That means this is an
                 * ancestor to current node. In other words this is back edge.
                 * 
                 * Technically speaking for finding SCC, the following linke can also be used
                 * instead of what we actually used
                 * 
                 * lowlink[node] = Math.min(lowlink[node], lowlink[neighbour]);
                 * 
                 * Although this works, this is not theoretically correct since we are updating
                 * lowlink value of current node with a neighbour (which is also its ancestor)
                 * processing of which is not complete yet. It completes only when dfs
                 * backtracks to that ancestor node. That ancestor might have other children
                 * which are not processed yet, hence this value although works is not right.
                 */
                lowlink[node] = Math.min(lowlink[node], index[neighbour]);
            }
            // if it is neither tree edge not back edge its a cross edge, ignore it
        }
        /*
         * we do not remove the nodes from the stack always when we backtrack. As shown
         * below, we remove all nodes in stack only when we find the root of current
         * SCC. When lowlink and index are same for given node, that means none of the
         * descendants including this node has any path to the ancestors currnent node
         * in dfs tree. In otherwords, this is start of current SCC.
         */
        if (lowlink[node] == index[node]) {
            sccCount++;
            int n = -1;
            List<Integer> list = new ArrayList<>();
            while (n != node) {
                n = stack.removeFirst();
                stackPresence[n] = false;
                list.add(n);
            }
            System.out.print(list + " ");
        }
    }
}
