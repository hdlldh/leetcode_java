//You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1. 
//
// Example 1: 
//
// 
//Input: coins = [1, 2, 5], amount = 11
//Output: 3 
//Explanation: 11 = 5 + 5 + 1 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Note: 
//You may assume that you have an infinite number of each kind of coin. 
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0; i<coins.length; i++) {
            if (coins[i]<=amount) dp[coins[i]] = 1;
        }
        for (int i=1; i<=amount; i++){
            for (int coin: coins){
                if (i==coin) dp[i] =1;
                else if (i>coin){
                    if (dp[i-coin]==Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }

        }
        if (dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
