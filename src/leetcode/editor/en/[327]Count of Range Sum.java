//Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive. 
//Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive. 
//
// Note: 
//A naive algorithm of O(n2) is trivial. You MUST do better than that. 
//
// Example: 
//
// 
//Input: nums = [-2,5,-1], lower = -2, upper = 2,
//Output: 3 
//Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
// Related Topics Binary Search Divide and Conquer Sort Binary Indexed Tree Segment Tree

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        TreeMap<Long,Integer> tmap = new TreeMap<>();
        tmap.put(0L, 1);
        int ans = 0;
        long sumi = 0L;
        for (int i=0; i<n; i++){
            sumi += nums[i];
            Long left = sumi - upper;
            Long right = sumi -lower;
            Map<Long, Integer> subTree = tmap.subMap(left, true, right, true);
            for (int val: subTree.values()) ans += val;
            if (tmap.containsKey(sumi)) tmap.put(sumi, tmap.get(sumi)+1);
            else tmap.put(sumi, 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
