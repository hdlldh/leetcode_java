//Say you have an array for which the ith element is the price of a given stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions. 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
//             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3. 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
//             engaging multiple transactions at the same time. You must sell before buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
// Related Topics Array Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<=1) return 0;
        int[][] dp = new int[n][5];
        for (int t=0; t<n; t++) Arrays.fill(dp[t], 0);
        for (int t=1; t<n; t++){
            for (int i=1; i<5; i++){
                if (i%2==0) dp[t][i] = Math.max(dp[t-1][i], dp[t-1][i-1]+prices[t]-prices[t-1]);
                else dp[t][i] = Math.max(dp[t-1][i]+prices[t]-prices[t-1], dp[t-1][i-1]);
            }
        }
        return Math.max(dp[n-1][2],dp[n-1][4]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
