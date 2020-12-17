//In a 2D grid of 0s and 1s, we change at most one 0 to a 1. 
//
// After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s). 
//
// Example 1: 
//
// 
//Input: [[1, 0], [0, 1]]
//Output: 3
//Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
// 
//
// Example 2: 
//
// 
//Input: [[1, 1], [1, 0]]
//Output: 4
//Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4. 
//
// Example 3: 
//
// 
//Input: [[1, 1], [1, 1]]
//Output: 4
//Explanation: Can't change any 0 to 1, only one island with area = 4. 
//
// 
//
// Notes: 
//
// 
// 1 <= grid.length = grid[0].length <= 50. 
// 0 <= grid[i][j] <= 1. 
// 
//
// 
// Related Topics Depth-first Search


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestIsland(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int color = 2;
        int ans = 0;
        HashMap<Integer, Integer> areas = new HashMap<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    areas.put(color, getArea(grid, i, j, color));
                    ans = Math.max(ans, areas.get(color));
                    color++;
                }
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==0){
                    HashSet<Integer> nei = new HashSet<>();
                    if (i>0) nei.add(grid[i-1][j]);
                    if (j>0) nei.add(grid[i][j-1]);
                    if (i<m-1) nei.add(grid[i+1][j]);
                    if (j<n-1) nei.add(grid[i][j+1]);
                    int area = 1;
                    for (int c: nei){
                        if (c>1) area+= areas.get(c);
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
    private int getArea(int[][] grid, int i, int j, int color){
        int m= grid.length;
        int n=grid[0].length;
        if (i<0 || i>=m || j<0 || j>=n) return 0;
        if (grid[i][j] != 1) return 0;
        grid[i][j] = color;
        int[] di = {0, -1, 0, 1};
        int[] dj = {-1, 0, 1, 0};
        int ans = 1;
        for (int k=0; k<4; k++) ans+=getArea(grid, i+di[k], j+dj[k], color);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
