//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (r
//epresenting land) connected 4-directionally (horizontal or vertical.) You may as
//sume all four edges of the grid are surrounded by water. 
//
// Count the number of distinct islands. An island is considered to be the same 
//as another if and only if one island can be translated (and not rotated or refle
//cted) to equal the other. 
//
// Example 1: 
// 
//11000
//11000
//00011
//00011
// 
//Given the above grid map, return 1.
// 
//
// Example 2: 
// 11011
//10000
//00001
//11011 
//Given the above grid map, return 3. 
//Notice that:
// 
//11
//1
// 
//and
// 
// 1
//11
// 
//are considered different island shapes, because we do not consider reflection 
/// rotation.
// 
//
// Note:
//The length of each dimension in the given grid does not exceed 50.
// Related Topics Hash Table Depth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] seen = new int[m][n];
        HashSet<String> ans = new HashSet<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1 && seen[i][j]==0){
                    StringBuilder shape = new StringBuilder();
                    dfs(grid, seen, i, j, i, j, shape);
                    ans.add(shape.toString());
                }
            }
        }
        return ans.size();
    }
    private void dfs(int[][] grid, int[][] seen, int i, int j, int i0, int j0, StringBuilder shape){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0 || i>=m || j<0 || j>=n) return;
        if (grid[i][j]==0 || seen[i][j]==1) return;
        seen[i][j] = 1;
        int[] dirs = {-1, 0, 1, 0, -1};
        shape.append(i-i0);
        shape.append(j-j0);
        for (int k=0; k<4; k++) dfs(grid, seen, i+dirs[k], j+dirs[k+1], i0, j0, shape);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
