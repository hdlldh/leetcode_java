//There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. 
//
// The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses. 
//
// Note: 
//All costs are positive integers. 
//
// Example: 
//
// 
//Input: [[1,5,3],[2,9,4]]
//Output: 5
//Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
//             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 
// 
//
// Follow up: 
//Could you solve it in O(nk) runtime? 
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n==0) return 0;
        int k = costs[0].length;
        int[][] dp = new int[n+1][k];
        for (int i=0; i<=n; i++) Arrays.fill(dp[i], 0);
        int last0 = 0;
        int last1 = 0;
        int curr0 = 0;
        int curr1 = 0;
        for (int i=1; i<=n; i++){
            int min0= Integer.MAX_VALUE;
            int min1 = Integer.MAX_VALUE;
            for (int j=0; j<k; j++){
                if (j!=last0) dp[i][j] = dp[i-1][last0] + costs[i-1][j];
                else dp[i][j] = dp[i-1][last1] + costs[i-1][j];
                if (dp[i][j]<min0){
                    min1 = min0;
                    min0 = dp[i][j];
                    curr1 = curr0;
                    curr0 = j;
                }else if (dp[i][j]<min1){
                    min1 = dp[i][j];
                    curr1 = j;
                }
            }
            last0 = curr0;
            last1 = curr1;
        }
        return dp[n][curr0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
