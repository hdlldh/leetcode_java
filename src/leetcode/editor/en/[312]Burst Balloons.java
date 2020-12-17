//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent. 
//
// Find the maximum coins you can collect by bursting the balloons wisely. 
//
// Note: 
//
// 
// You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them. 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// Example: 
//
// 
//Input: [3,1,5,8]
//Output: 167 
//Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// Related Topics Divide and Conquer Dynamic Programming


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n+2];
        for (int i=0; i<n; i++) nums1[i+1] = nums[i];
        nums1[0] = 1;
        nums1[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        for (int i=0; i<=n+1; i++) Arrays.fill(dp[i],0 );
        for (int l = 1; l<=n; l++){
            for (int i=1; i<=n-l+1; i++){
                int j = i+l-1;
                for (int k = i; k<=j; k++)
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + nums1[k]*nums1[i-1]*nums1[j+1]);
            }
        }
        return dp[1][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
