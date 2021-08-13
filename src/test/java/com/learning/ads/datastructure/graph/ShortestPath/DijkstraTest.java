package com.learning.ads.datastructure.graph.ShortestPath;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class DijkstraTest {

    @Test
    public void test0(){
        int[][] edges = new int[6][3];
        edges[0] = new int[]{0, 1, 4};
        edges[1] = new int[]{0, 2, 1};
        edges[2] = new int[]{2, 1, 2};
        edges[3] = new int[]{1, 3, 1};
        edges[4] = new int[]{2, 3, 5};
        edges[5] = new int[]{4, 3, 3};
        Dijkstra dijkstra = new Dijkstra(edges, false);
        assertArrayEquals(new int[]{0, 3, 1, 4, 7}, dijkstra.findSSSP(0));
    }

    @Test
    public void test1(){
        int[][] edges = new int[11][3];
        edges[0] = new int[]{0, 1, 5};
        edges[1] = new int[]{0, 2, 1};
        edges[2] = new int[]{2, 1, 3};
        edges[3] = new int[]{1, 2, 2};
        edges[4] = new int[]{1, 3, 3};
        edges[5] = new int[]{1, 4, 20};
        edges[6] = new int[]{2, 4, 12};
        edges[7] = new int[]{3, 4, 2};
        edges[8] = new int[]{3, 2, 3};
        edges[9] = new int[]{4, 5, 1};
        edges[10] = new int[]{3, 5, 6};
        Dijkstra dijkstra = new Dijkstra(edges, true);
        assertArrayEquals(new int[]{0, 4, 1, 7, 9, 10}, dijkstra.findSSSP(0));
    }
}
