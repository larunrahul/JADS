package com.learning.ads.datastructure.tree;

public class Trie {
    
    private class TrieNode{
        boolean leaf;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26]; 
        }
    }
    
    private TrieNode trie;

    /** Initialize your data structure here. */
    public Trie() {
        trie = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = trie;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.leaf = true; //once word is added, mark the last char as leaf, so that when we call exist(word), it returns true
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = trie;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.leaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = trie;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null){
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}
