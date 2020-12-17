//Implement a trie with insert, search, and startsWith methods. 
//
// Example: 
//
// 
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
// 
//
// Note: 
//
// 
// You may assume that all inputs are consist of lowercase letters a-z. 
// All inputs are guaranteed to be non-empty strings. 
// 
// Related Topics Design Trie


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children=new HashMap<>();
    boolean isEnd=false;
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (Character ch: word.toCharArray()){
            p = p.children.computeIfAbsent(ch, c->new TrieNode());
        }
        p.children.put('#', new TrieNode());
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(char ch: word.toCharArray()){
            if (!p.children.containsKey(ch)) return false;
            p = p.children.get(ch);
        }
        if (p.children.containsKey('#')) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(char ch: prefix.toCharArray()){
            if (!p.children.containsKey(ch)) return false;
            p = p.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
