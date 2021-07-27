package com.learning.ads.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Find tree centers in undirected graph.
 * 
 * Center node(s) of tree is(are) always the middle element(s) in the longest
 * path in the tree
 * 
 * We remove leaf nodes layer by layer like we peel onions. The remaining ones
 * leaf after peeling are center node(s)
 * 
 * @author Arun Rahul
 */
public class TreeCenters {

    Map<Integer, List<Integer>> graph;
    int[] degree;
    int size;
    public TreeCenters(int size, int[][] edges){
        this.graph = new HashMap<>();
        this.degree = new int[size];
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], (a) -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], (a) -> new ArrayList<>()).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        this.size = size;
    }
    public List<Integer> findCenters() {
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        // there can be atmost 2 center nodes.
        int count = size;
        while (count > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                List<Integer> neighbours = graph.get(leaf);
                if (neighbours == null) {
                    continue;
                }
                for (int neighbour : neighbours) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        newLeaves.add(neighbour);
                    }
                }
                /*
                    Set this nodes degree to 0, since we are removing(not physically) it form graph by decreasing all its neighbours' degree
                    When we process leaf's any neighbour N, leaf appears as N's neighbour but with degree 0 which does not satisfy our condition on line 46, 
                    and hence won't be added to leaves again.
                */
                degree[leaf] = 0;
            }
            //since we processed current leaves, remove them from total count
            count -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
}
