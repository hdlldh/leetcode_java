//Design a data structure that supports the following two operations: 
//
// 
//void addWord(word)
//bool search(word)
// 
//
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter. 
//
// Example: 
//
// 
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// Note: 
//You may assume that all words are consist of lowercase letters a-z. 
// Related Topics Backtracking Design Trie


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    char ch;
    HashMap<Character, TrieNode> children=new HashMap<>();
    boolean isEnd=false;
}
class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for (Character ch: word.toCharArray()){
            p = p.children.computeIfAbsent(ch, c->new TrieNode());
        }
        p.children.put('#', new TrieNode());
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }
    private boolean helper(TrieNode p, String word, int i){
        if (i>=word.length()){
            if (p.children.containsKey('#')) return true;
            return false;
        }
        char ch = word.charAt(i);
        if (ch!='.'){
            if (p.children.containsKey(ch)) return helper(p.children.get(ch), word, i+1);
            else return false;
        }
        boolean ans = false;
        for (char c: p.children.keySet()){
            if (c=='#') continue;
            ans = ans || helper(p.children.get(c), word, i+1);
        }
        return ans;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
