//
//You are given a list of non-negative integers, a1, a2, ..., an, and a target, 
//S. Now you have 2 symbols + and -. For each integer, you should choose one from 
//+ and - as its new symbol.
// 
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
//get S. 
// 
//
// Example 1: 
// 
//Input: nums is [1, 1, 1, 1, 1], S is 3. 
//Output: 5
//Explanation: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//There are 5 ways to assign symbols to make the sum of nums be target 3.
// 
// 
//
// Note: 
// 
// The length of the given array is positive and will not exceed 20. 
// The sum of elements in the given array will not exceed 1000. 
// Your output answer is guaranteed to be fitted in a 32-bit integer. 
// 
// Related Topics Dynamic Programming Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sums = 0;
        for (int num: nums) sums+=num;
        if (S>sums || S< -sums) return 0;
        int[] dp = new int[2*sums+1];
        dp[sums] = 1;
        for (int num: nums){
            int[] dp2 = new int[2*sums+1];
            for (int i=0; i<2*sums+1; i++){
                int dp_left = (i-num>=0)? dp[i-num]:0;
                int dp_right = (i+num<2*sums+1)?dp[i+num]:0;
                dp2[i] = dp_left + dp_right;
            }
            dp = dp2;
        }
        return dp[S+sums];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
