package com.learning.ads.datastructure.graph;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;


import org.junit.Test;

public class TreeCentersTest {

    @Test
    public void testSingleCenter(){
        int[][] edges = new int[9][2];
        edges[0] = new int[]{2, 9};
        edges[1] = new int[]{3, 4};
        edges[2] = new int[]{6, 7};
        edges[3] = new int[]{0, 1};
        edges[4] = new int[]{1, 2};
        edges[5] = new int[]{5, 3};
        edges[6] = new int[]{6, 2};
        edges[7] = new int[]{6, 8};
        edges[8] = new int[]{2, 3};
        TreeCenters tc = new TreeCenters(10, edges);
        assertEquals(Arrays.asList(2), tc.findCenters());
    }

    @Test
    public void testTwoCenters(){
        int[][] edges = new int[10][2];
        edges[0] = new int[]{2, 9};
        edges[1] = new int[]{3, 4};
        edges[2] = new int[]{6, 7};
        edges[3] = new int[]{0, 1};
        edges[4] = new int[]{1, 2};
        edges[5] = new int[]{5, 3};
        edges[6] = new int[]{6, 2};
        edges[7] = new int[]{6, 8};
        edges[8] = new int[]{2, 3};
        edges[9] = new int[]{10, 8};
        TreeCenters tc = new TreeCenters(11, edges);
        assertEquals(Arrays.asList(2, 6), tc.findCenters());
    }

    @Test
    public void testTwoCentersWithTwoNodes(){
        int[][] edges = new int[1][2];
        edges[0] = new int[]{0, 1};
        TreeCenters tc = new TreeCenters(2, edges);
        assertEquals(Arrays.asList(0, 1), tc.findCenters());
    }

    @Test
    public void testTwoCentersWithFourNodes(){
        int[][] edges = new int[3][2];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{2, 1};
        edges[2] = new int[]{2, 3};
        TreeCenters tc = new TreeCenters(4, edges);
        assertEquals(Arrays.asList(1, 2), tc.findCenters());
    }

    @Test
    public void testOneCentersWithThreeNodes(){
        int[][] edges = new int[2][2];
        edges[0] = new int[]{0, 1};
        edges[1] = new int[]{2, 1};
        TreeCenters tc = new TreeCenters(3, edges);
        assertEquals(Arrays.asList(1), tc.findCenters());
    }
}
