package com.learning.ads.datastructure.graph.ShortestPath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given an undirected non-negative weighted graph, find shortest distance from a given source vertex to all other vertices
 * 
 * @author Arun Rahul
 */
public class Dijkstra {
    class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    Map<Integer, Set<Node>> graph;
    int maxVertex;
    //build unweighted graph
    public Dijkstra(int[][] edges, boolean isDirected){
        graph = new HashMap<>();
        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], (a) -> new HashSet<>()).add(new Node(edge[1], edge[2]));
            if(!isDirected){
                graph.computeIfAbsent(edge[1], (a) -> new HashSet<>()).add(new Node(edge[0], edge[2]));
            }
            
            maxVertex = Math.max(maxVertex, Math.max(edge[1], edge[0]));
        }
    }

    public int[] findSSSP(int source){
        int[] distance = new int[maxVertex + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        boolean[] visited = new boolean[maxVertex + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.add(new Node(source, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.vertex] = true;
            /*
                If distance of current vertex is less than what it is holding in queue, 
                means a better distance is already found and it is a stale node in queue. 
                We can skip it.
            */
            if(distance[cur.vertex] < cur.weight) continue;
            if(!graph.containsKey(cur.vertex)) continue;
            for(Node neighbour : graph.get(cur.vertex)){
                if(visited[neighbour.vertex]) continue;
                if(distance[cur.vertex] + neighbour.weight < distance[neighbour.vertex]){
                    distance[neighbour.vertex] = distance[cur.vertex] + neighbour.weight;
                    pq.add(new Node(neighbour.vertex, distance[neighbour.vertex]));
                }
            }
        }
        return distance;
    }
}
