//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. 
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. 
//
// Example 1: 
//
// 
//Input: [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//             because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        if (n==1) return nums[0];
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        for (int i=0; i<nums.length-1; i++){
            nums1[i] = nums[i+1];
            nums2[i] = nums[i];
        }
        return Math.max(helper(nums1), helper(nums2));
        
    }
    public int helper(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        if (n==1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = nums[0];
        for (int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
