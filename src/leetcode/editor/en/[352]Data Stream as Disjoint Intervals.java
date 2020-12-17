//Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals. 
//
// For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be: 
//
// 
//[1, 1]
//[1, 1], [3, 3]
//[1, 1], [3, 3], [7, 7]
//[1, 3], [7, 7]
//[1, 3], [6, 7]
// 
//
// 
//
// Follow up: 
//
// What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size? 
// Related Topics Binary Search Ordered Map


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class SummaryRanges {
    TreeSet<int[]> data;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        data = new TreeSet<>(Comparator.comparing((int[] x)->x[0]).thenComparing((int[] x)->x[1]));
    }

    public void addNum(int val) {
        int[] t = {val, val};
        int[] floor = data.floor(t);
        if (floor!=null){
            if (floor[1]>=val) return;
            else if (val== floor[1]+1){
                t[0] = floor[0];
                data.remove(floor);
            }
        }
        int[] ceil = data.ceiling(t);
        if (ceil!= null){
            if (ceil[0]<=val) return;
            else if (ceil[0]==val+1){
                t[1] = ceil[1];
                data.remove(ceil);
            }
        }
        data.add(t);

    }

    public int[][] getIntervals() {
        int[][] ans = new int[data.size()][2];
        int[] start = data.first();
        int i =0;
        for (int[] t: data){
            ans[i][0] = t[0];
            ans[i][1] = t[1];
            i++;
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
//leetcode submit region end(Prohibit modification and deletion)
