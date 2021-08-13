package com.learning.ads.datastructure.heap.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedule {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char c : tasks){
            counts[c - 'A']++;
        }
        class Node{
            int c;
            int i;
            Node(int c, int i){
                this.c = c;
                this.i = i;
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            int l = Integer.compare(b.c, a.c);
            if(l == 0) return Integer.compare(a.i, b.i);
            return l;
        });
        for(int i = 0; i < 26; i++){
            if(counts[i] != 0){
                pq.add(new Node(counts[i], i));
            }
        }
        int ans = 0;
        while(!pq.isEmpty()){
            List<Node> cset = new ArrayList<>();
            int lk = n + 1;
            while(!pq.isEmpty() && lk > 0){
                cset.add(pq.poll());
                lk--;
            }
            ans += cset.size();
            for(int i = 0; i < cset.size(); i++){
                cset.get(i).c -= 1;
                if(cset.get(i).c != 0){
                    pq.add(cset.get(i));
                }
            }
            if(lk != 0 && !pq.isEmpty() && pq.peek().i == cset.get(0).i){
                ans += lk;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        TaskSchedule ts = new TaskSchedule();
        System.out.println(ts.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
        System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        System.out.println(ts.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(ts.leastInterval(new char[]{'A','A','A'}, 2));
    }
}