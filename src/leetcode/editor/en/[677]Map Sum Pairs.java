//
//Implement a MapSum class with insert, and sum methods.
// 
//
// 
//For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
// 
//
// 
//For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
// 
//
// Example 1: 
// 
//Input: insert("apple", 3), Output: Null
//Input: sum("ap"), Output: 3
//Input: insert("app", 2), Output: Null
//Input: sum("ap"), Output: 5
// 
// 
// Related Topics Trie


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    int score=0;
}
class MapSum {
    TrieNode root;
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode p = root;
        for (char ch: key.toCharArray()){
            p.children.putIfAbsent(ch, new TrieNode());
            p = p.children.get(ch);
            p.score += diff;
        }
    }
    
    public int sum(String prefix) {
        TrieNode p = root;
        for (char ch: prefix.toCharArray()) {
            p.children.putIfAbsent(ch, new TrieNode());
            p = p.children.get(ch);
        }
        return p.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
