package com.learning.ads.datastructure.graph.scc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TarjanSCCTest {
    @Test
    public void test(){
        int[][] edges1 = {{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}};
        assertEquals(3, new TarjanSCC(edges1, 5).stronglyConnectedComponents());
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        assertEquals(1, new TarjanSCC(edges2, 3).stronglyConnectedComponents());
        int[][] edges3 = {{1, 2}, {2, 0}, {2, 2}};
        assertEquals(3, new TarjanSCC(edges3, 3).stronglyConnectedComponents());
        int[][] edges4 = {{1, 2}, {2, 3}, {3, 1}};
        assertEquals(2, new TarjanSCC(edges4, 4).stronglyConnectedComponents());
        int[][] edges5 = {{4, 4}, {3, 1}, {0, 2}, {6, 3}, {6, 5},{1, 4},{1, 7}, {3, 7}, {1, 0}, {3, 3}, {4, 3}, {1, 4}, {7, 6}};
        assertEquals(4, new TarjanSCC(edges5, 8).stronglyConnectedComponents());
        int[][] edges6 = {{2, 8}, {8, 0}, {7, 5}, {5, 5}};
        assertEquals(9, new TarjanSCC(edges6, 9).stronglyConnectedComponents());
    }
}
