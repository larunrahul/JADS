package com.learning.ads.datastructure.graph.scc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KosarajuSCCTest {
    private KosarajuSCC kosaraju = new KosarajuSCC();

    @Test
    public void test(){
        int[][] edges1 = {{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}};
        assertEquals(3, kosaraju.stronglyConnectedComponents(prepareGraph(edges1, 5), 5));
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        assertEquals(1, kosaraju.stronglyConnectedComponents(prepareGraph(edges2, 3), 3));
        
    }

    private List<List<Integer>> prepareGraph(int[][] edges, int vertices){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
        }
        return graph;
    }

}
