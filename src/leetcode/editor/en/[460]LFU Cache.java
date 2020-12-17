//Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted. 
//
// Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed. 
//
// 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// 
//
// Example: 
//
// 
//LFUCache cache = new LFUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.get(3);       // returns 3.
//cache.put(4, 4);    // evicts key 1.
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {
    int capacity;
    HashMap<Integer, LinkedHashMap<Integer, Integer>> freq2node;
    HashMap<Integer, Integer> key2freq;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freq2node = new HashMap<>();
        key2freq = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!key2freq.containsKey(key)) return -1;
        int freq = key2freq.get(key);
        LinkedHashMap<Integer, Integer> nodes = freq2node.get(freq);
        int value = nodes.get(key);
        nodes.remove(key);
        if (nodes.size()==0) {
            freq2node.remove(freq);
            if (freq == minFreq) minFreq++;
        }
        freq++;
        key2freq.put(key, freq);
        nodes = freq2node.getOrDefault(freq, new LinkedHashMap<>());
        nodes.put(key, value);
        freq2node.put(freq, nodes);
        return value;
    }
    
    public void put(int key, int value) {
        if (capacity==0) return;
        LinkedHashMap<Integer, Integer> nodes;
        if (key2freq.containsKey(key)){
            int freq = key2freq.get(key);
            nodes = freq2node.get(freq);
            nodes.put(key, value);
            get(key);
            return;
        }
        if (key2freq.size()==capacity){
            int k1=0;
            nodes = freq2node.get(minFreq);
            for (int k: nodes.keySet()){
                k1 = k;
                break;
            }
            nodes.remove(k1);
            if (nodes.size()==0) freq2node.remove(minFreq);
            key2freq.remove(k1);
        }
        int freq = 1;
        minFreq = 1;
        key2freq.put(key, freq);
        nodes = freq2node.getOrDefault(freq, new LinkedHashMap<>());
        nodes.put(key, value);
        freq2node.put(freq, nodes);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
