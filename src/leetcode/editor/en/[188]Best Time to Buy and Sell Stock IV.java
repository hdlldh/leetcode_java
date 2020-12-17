//Say you have an array for which the i-th element is the price of a given stock on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most k transactions. 
//
// Note: 
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [2,4,1], k = 2
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: [3,2,6,5,0,3], k = 2
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
//             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// 
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (2*k>=n) return noLimit(prices);
        else return limitK(prices, k);
    }
    private int noLimit(int[] prices) {
        int n = prices.length;
        if (n<=1) return 0;
        int ans = 0;
        for (int i=1; i<n; i++){
            if (prices[i]>prices[i-1]) ans+=prices[i]-prices[i-1];
        }
        return ans;
    }
    private int limitK(int[] prices, int k) {
        int n = prices.length;
        if (n<=1) return 0;
        int[][] dp = new int[n][2*k+1];
        for (int t=0; t<n; t++) Arrays.fill(dp[t], 0);
        int ans = 0;
        for (int t=1; t<n; t++){
            for (int i=1; i<2*k+1; i++){
                if (i%2==0){
                    dp[t][i] = Math.max(dp[t-1][i], dp[t-1][i-1]+prices[t]-prices[t-1]);
                    if (t==n-1) ans = Math.max(ans, dp[t][i]);
                }
                else dp[t][i] = Math.max(dp[t-1][i]+prices[t]-prices[t-1], dp[t-1][i-1]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
