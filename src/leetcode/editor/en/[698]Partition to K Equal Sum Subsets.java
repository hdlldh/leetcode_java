//Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal. 
//
// 
//
// Example 1: 
//
// 
//Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//Output: True
//Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
// 
//
// 
//
// Note: 
//
// 
// 1 <= k <= len(nums) <= 16. 
// 0 < nums[i] < 10000. 
// 
// Related Topics Dynamic Programming Recursion


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) sum+=nums[i];
        if (sum%k!=0) return false;
        int target = sum/k;
        Arrays.sort(nums);
        if (nums[nums.length-1]>target) return false;
        if (k==1) return true;
        int[] checker = new int[k];
        Arrays.fill(checker, 0);
        return dfs(nums, k, target, nums.length-1, checker);
    }
    private boolean dfs(int[] nums, int k, int target,  int start, int[] checker){
        if (start<0){
            for (int ck: checker){
                if (ck!=target) return false;
            }
            return true;
        }
        for (int i=0; i<k; i++){
            if (nums[start]+checker[i]>target) continue;
            checker[i] += nums[start];
            if (dfs(nums, k, target, start-1, checker)) return true;
            checker[i] -= nums[start];
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
