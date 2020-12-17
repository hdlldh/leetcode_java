//Given a non-empty array containing only positive integers, find if the array c
//an be partitioned into two subsets such that the sum of elements in both subsets
// is equal. 
//
// Note: 
//
// 
// Each of the array element will not exceed 100. 
// The array size will not exceed 200. 
// 
//
// 
//
// Example 1: 
//
// 
//Input: [1, 5, 11, 5]
//
//Output: true
//
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// 
//
// Example 2: 
//
// 
//Input: [1, 2, 3, 5]
//
//Output: false
//
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) sum+=num;
        if (sum%2!=0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int num: nums){
            for (int i=target; i>=num; i--){
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
