package com.learning.ads.datastructure.set;

/**
 * @author Arun Rahul
 * 
 *         Based on Introduction to Algorithms (CLRS), CORMEN et,al.
 * 
 *         With union by rank and path compression, a single call might take
 *         O(logn) in the worst case, but if we do m such calls back to back we
 *         will end up with complexity O(m α(n)) where α(n) is very slow growing
 *         inverse Ackermann function.
 * 
 *         In most of paracical applications α(n) <= 4. That means for m
 *         operations, on average each of them run in constant time. Alone,
 *         union by rank yields a running time of O(m logn)
 * 
 *         Also, it's worth mentioning that DisjointSet with union by size / rank, but
 *         without path compression works in O(logn) time per query.
 */
public class DisjointSet {

	// to store parents
	private int[] parent;

	/*
	 * for rank heurestic, we consider height (more precisely the upper bound on
	 * tree height since height will get smaller when applying path compression).
	 * 
	 * The term rank is preferred instead of height because if path compression
	 * technique is used, then rank is not always equal to height.
	 * 
	 * rank[x] is bigger than or equal to the number of edges in the longest path
	 * between node x and a sub-leaf
	 */
	private int[] rank;

	// number of disjoint sets
	private int count;

	public DisjointSet(int size) {
		parent = new int[size];
		// initial ranks of each set is 0
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			makeSet(i);
		}
	}

	public void makeSet(int element) {
		// each element is its own parent
		parent[element] = element;
		count++;
	}

	public void union(int element1, int element2) {
		link(find(element1), find(element2));
	}

	/**
	 * If the roots have unequal rank, we make the root with higher rank the parent
	 * of the root with lower rank, but the ranks themselves remain unchanged. If,
	 * instead, the roots have equal ranks, we arbitrarily choose one of the roots
	 * as the parent and increment its rank.
	 * 
	 * @param set1
	 * @param set2
	 */
	private void link(int set1, int set2) {
		//if both are same sets, don't need to merge
		if(set1 == set2) return;
		// update parent of Set with smaller rank to Set with larger rank.
		// If both Sets are of equal rank chose one arbitrarily
		if (rank[set1] > rank[set2])
			parent[set2] = set1;
		else {
			parent[set1] = set2;
			// if ranks of both sets are equal, since we point one set to another, increment
			// rank of parent
			if (rank[set1] == rank[set2])
				rank[set2]++;
		}
		// since we are merging two sets, it reduces total count 
		count--;
	}

	/**
	 * When we do path compression in find, in reality it might decrease the height
	 * of tree, but we dont decrease it in code since we use upper bound on height
	 * instead of exact height
	 * 
	 * @param element
	 * @return
	 */
	public int find(int element) {
		if (element != parent[element])
			parent[element] = find(parent[element]);
		// path compression
		return parent[element];
	}

	public int getCount(){
		return count;
	}
}
