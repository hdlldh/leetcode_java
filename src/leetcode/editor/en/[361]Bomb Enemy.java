//Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (th
//e number zero), return the maximum enemies you can kill using one bomb. 
//The bomb kills all the enemies in the same row and column from the planted poi
//nt until it hits the wall since the wall is too strong to be destroyed. 
//Note: You can only put the bomb at an empty cell. 
//
// Example: 
//
// 
// 
//Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//Output: 3 
//Explanation: For the given grid,
//
//0 E 0 0 
//E 0 W E 
//0 E 0 0
//
//Placing a bomb at (1,1) kills 3 enemies.
// 
// Related Topics Dynamic Programming




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        if (m==0) return ans;
        int n = grid[0].length;
        int[][] v1 = new int[m][n];
        int[][] v2 = new int[m][n];
        int[][] v3 = new int[m][n];
        int[][] v4 = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                if (grid[i][j-1]=='W') continue;
                v1[i][j] = (grid[i][j-1]=='E')?v1[i][j-1]+1:v1[i][j-1];
            }
            for (int j=n-2; j>=0; j--){
                if (grid[i][j+1]=='W') continue;
                v2[i][j] = (grid[i][j+1]=='E')?v2[i][j+1]+1:v2[i][j+1];
            }
        }
        for (int j=0; j<n; j++){
            for (int i=1; i<m; i++){
                if (grid[i-1][j]=='W') continue;
                v3[i][j] = (grid[i-1][j]=='E')?v3[i-1][j]+1:v3[i-1][j];
            }
            for (int i=m-2; i>=0; i--){
                if (grid[i+1][j]=='W') continue;
                v4[i][j] = (grid[i+1][j]=='E')?v4[i+1][j]+1:v4[i+1][j];
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]=='0') ans = Math.max(ans, v1[i][j]+v2[i][j]+v3[i][j]+v4[i][j]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
