//Implement a data structure supporting the following operations: 
//
// 
// 
// Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string. 
// Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string. 
// GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "". 
// GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "". 
// 
// 
//
// 
//Challenge: Perform all these in O(1) time complexity.
// Related Topics Design


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Vnode{
    HashSet<String> keys;
    int value;
    Vnode prev;
    Vnode next;
}
class AllOne {
    Vnode head;
    Vnode tail;
    HashMap<String, Vnode> key2pos;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Vnode();
        head.value = -1;
        head.keys = new HashSet<>();
        tail = new Vnode();
        tail.value = -1;
        tail.keys = new HashSet<>();
        head.next = tail;
        tail.prev = head;
        key2pos = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Vnode curPos;
        int curVal;
        if (!key2pos.containsKey(key)) {
            curPos = head;
            curVal = 0;
        } else {
            curPos = key2pos.get(key);
            curVal = curPos.value;
        }
        if (curPos.next.value != curVal + 1) {
            Vnode t = new Vnode();
            t.value = curVal + 1;
            t.keys = new HashSet<>();
            t.keys.add(key);
            curPos.next.prev = t;
            t.next = curPos.next;
            curPos.next = t;
            t.prev = curPos;
            key2pos.put(key, t);
        } else {
            curPos.next.keys.add(key);
            key2pos.put(key, curPos.next);
        }
        if (curPos.keys.contains(key)) curPos.keys.remove(key);
        if (curPos != head && curPos.keys.isEmpty()) {
            curPos.prev.next = curPos.next;
            curPos.next.prev = curPos.prev;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!key2pos.containsKey(key)) return;
        Vnode curPos = key2pos.get(key);
        int curVal = curPos.value;
        if (curVal > 1){
            if (curPos.prev.value != curVal -1){
                Vnode t = new Vnode();
                t.value = curVal - 1;
                t.keys = new HashSet<>();
                t.keys.add(key);
                curPos.prev.next = t;
                t.prev =curPos.prev;
                curPos.prev = t;
                t.next = curPos;
                key2pos.put(key, t);
            }else{
                curPos.prev.keys.add(key);
                key2pos.put(key, curPos.prev);
            }
        }else key2pos.remove(key);
        curPos.keys.remove(key);
        if (curPos.keys.isEmpty()){
            curPos.prev.next = curPos.next;
            curPos.next.prev = curPos.prev;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.next == tail) return "";
        return tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)
