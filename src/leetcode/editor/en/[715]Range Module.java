//A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner. 
//
// addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked. 
//
// queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right)
// is currently being tracked. 
//
// removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right). 
//
// Example 1: 
// 
//addRange(10, 20): null
//removeRange(14, 16): null
//queryRange(10, 14): true (Every number in [10, 14) is being tracked)
//queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
//queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
// 
// 
//
// Note:
// A half open interval [left, right) denotes all real numbers left <= x < right. 
//
// 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange. 
// The total number of calls to addRange in a single test case is at most 1000. 
// The total number of calls to queryRange in a single test case is at most 5000. 
// The total number of calls to removeRange in a single test case is at most 1000. 
// Related Topics Segment Tree Ordered Map


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class RangeModule {
    TreeMap<Integer, Integer> ranges;
    public RangeModule() {
        ranges = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        ranges.put(left, right);
        TreeMap<Integer, Integer> new_ranges = new TreeMap<>();
        for (Map.Entry<Integer, Integer> m: ranges.entrySet()){
            if (new_ranges.isEmpty() || new_ranges.lastEntry().getValue()<m.getKey()){
                new_ranges.put(m.getKey(), m.getValue());
            }else{
                int key = new_ranges.lastKey();
                int val = new_ranges.lastEntry().getValue();
                val = Math.max(val, m.getValue());
                new_ranges.put(key, val);
            }
        }
        ranges = new_ranges;
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> it = ranges.higherEntry(left);
        if (!ranges.isEmpty()){
            if (it==null) it = ranges.lastEntry();
            else it = ranges.lowerEntry(it.getKey());
            return it!=null && it.getValue()>=right;
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        TreeMap<Integer, Integer> new_ranges = new TreeMap<>();
        for (Map.Entry<Integer, Integer> m: ranges.entrySet()){
            if (m.getKey()>=right || m.getValue()<=left){
                new_ranges.put(m.getKey(), m.getValue());
            }else{
                if (m.getKey()<left) new_ranges.put(m.getKey(), left);
                if (m.getValue()>right) new_ranges.put(right, m.getValue());
            }
        }
        ranges = new_ranges;
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
