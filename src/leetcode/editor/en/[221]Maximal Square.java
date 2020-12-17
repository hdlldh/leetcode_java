//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area. 
//
// Example: 
//
// 
//Input: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(dp[i],0);
        int ans = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j]=='0') continue;
                dp[i][j] = 1;
                if (i>0 && j>0) dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans*ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
