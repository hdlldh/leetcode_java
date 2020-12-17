//There is an m by n grid with a ball. Given the start coordinate (i,j) of the b
//all, you can move the ball to adjacent cell or cross the grid boundary in four d
//irections (up, down, left, right). However, you can at most move N times. Find o
//ut the number of paths to move the ball out of grid boundary. The answer may be 
//very large, return it after mod 109 + 7. 
//
// 
//
// Example 1: 
//
// 
//Input: m = 2, n = 2, N = 2, i = 0, j = 0
//Output: 6
//Explanation:
//
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 3, N = 3, i = 0, j = 1
//Output: 12
//Explanation:
//
// 
//
// 
//
// Note: 
//
// 
// Once you move the ball out of boundary, you cannot move it back. 
// The length and height of the grid is in range [1,50]. 
// N is in range [0,50]. 
// 
// Related Topics Dynamic Programming Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[N+1][m][n];
        int kmod = 1000000007;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k=1; k<=N; k++){
            for (int ci=0; ci<m; ci++){
                for (int cj=0; cj<n; cj++){
                    for (int d=0; d<4; d++){
                        int ti = ci+dirs[d];
                        int tj = cj+dirs[d+1];
                        if (ti<0 || tj<0 || ti>=m || tj>=n) dp[k][ci][cj]++;
                        else dp[k][ci][cj] = (dp[k][ci][cj] + dp[k-1][ti][tj])%kmod;
                    }
                }
            }
        }
        return (int) dp[N][i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
