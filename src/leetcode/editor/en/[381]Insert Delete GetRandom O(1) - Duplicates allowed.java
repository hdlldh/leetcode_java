//Design a data structure that supports all following operations in average O(1) time. 
//Note: Duplicate elements are allowed.
// 
// 
// insert(val): Inserts an item val to the collection. 
// remove(val): Removes an item val from the collection if present. 
// getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains. 
// 
// 
//
// Example:
// 
//// Init an empty collection.
//RandomizedCollection collection = new RandomizedCollection();
//
//// Inserts 1 to the collection. Returns true as the collection did not contain 1.
//collection.insert(1);
//
//// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
//collection.insert(1);
//
//// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
//collection.insert(2);
//
//// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
//collection.getRandom();
//
//// Removes 1 from the collection, returns true. Collection now contains [1,2].
//collection.remove(1);
//
//// getRandom should return 1 and 2 both equally likely.
//collection.getRandom();
// 
// Related Topics Array Hash Table Design

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class RandomizedCollection {
    ArrayList<Integer> data;
    HashMap<Integer, HashSet<Integer>> pos;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        data = new ArrayList<>();
        pos = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = (pos.containsKey(val))?false:true;
        HashSet<Integer> t= pos.getOrDefault(val, new HashSet<>());
        t.add(data.size());
        pos.put(val, t);
        data.add(val);
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!pos.containsKey(val)) return false;
        HashSet<Integer> t = pos.get(val);
        int p = t.iterator().next();
        t.remove(p);
        if (t.size()==0) pos.remove(val);
        int last = data.size()-1;
        if (p!=last){
            int lastNum = data.get(last);
            data.set(p, lastNum);
            t = pos.get(lastNum);
            t.remove(last);
            t.add(p);
        }
        data.remove(last);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(data.size()==0) return -1;
        Random rand = new Random();
        return data.get(rand.nextInt(data.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
