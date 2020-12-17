//Given an integer matrix, find the length of the longest increasing path. 
//
// From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed). 
//
// Example 1: 
//
// 
//Input: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//Output: 4 
//Explanation: The longest increasing path is [1, 2, 6, 9].
// 
//
// Example 2: 
//
// 
//Input: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//Output: 4 
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
// 
// Related Topics Depth-first Search Topological Sort Memoization


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int ans = 0;
        if (m==0) return ans;
        int n = matrix[0].length;
        int[][] mem = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                mem[i][j]=0;
            }
        }
        //Arrays.fill(mem, 0);
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                ans = Math.max(ans, dfs(matrix, i, j, mem));
            }
        }
        return ans;
    }
    private int dfs(int[][] matrix, int i, int j, int[][]mem){
        if (mem[i][j]>0) return mem[i][j];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        mem[i][j] = 1;
        for (int k=0; k<4; k++){
            int ni = i+dx[k];
            int nj = j+dy[k];
            if (ni<0 || ni>=matrix.length || nj<0 || nj>=matrix[0].length) continue;
            if (matrix[i][j] < matrix[ni][nj]) mem[i][j] = Math.max(mem[i][j], dfs(matrix, ni, nj, mem)+1);
        }
        return mem[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
