//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1. 
//
//
// Example 1: 
// 
//Input: [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
// 
// 
//
// Example 2: 
// 
//Input: [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
// 
// 
//
// Note:
//The length of the given binary array will not exceed 50,000.
// Related Topics Hash Table


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(0, -1);
        int ans = 0;
        int presum = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]==1) presum++;
            else presum--;
            if (!mem.containsKey(presum)) mem.put(presum, i);
            else ans = Math.max(ans, i-mem.get(presum));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
