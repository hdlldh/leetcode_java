//You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where: 
//
// 
// Each 0 marks an empty land which you can pass by freely. 
// Each 1 marks a building which you cannot pass through. 
// Each 2 marks an obstacle which you cannot pass through. 
// 
//
// Example: 
//
// 
//Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
//
//1 - 0 - 2 - 0 - 1
//|   |   |   |   |
//0 - 0 - 0 - 0 - 0
//|   |   |   |   |
//0 - 0 - 1 - 0 - 0
//
//Output: 7 
//
//Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
//             the point (1,2) is an ideal empty land to build a house, as the total 
//             travel distance of 3+3+1=7 is minimal. So return 7. 
//
// Note: 
//There will be at least one building. If it is not possible to build such house according to the above rules, return -1. 
// Related Topics Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m==0) return -1;
        int n = grid[0].length;
        int[][] count = new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(count[i], 0);
        int maxCnt = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]==1){
                    bfs(grid, i, j, count);
                    maxCnt++;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j]==maxCnt){
                    ans = Math.min(ans, -grid[i][j]);
                }
            }
        }
        if (ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
    private void bfs(int[][] grid, int i, int j, int[][] count){
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(i*n+j);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(i*n+j);
        int dist = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()){
            int size = queue.size();
            dist++;
            for (int l=0; l<size; l++){
                int t = queue.removeFirst();
                int ti = t/n;
                int tj = t%n;
                for (int k=0; k<4; k++){
                    int ni = ti+dx[k];
                    int nj = tj+dy[k];
                    if (ni<0 || ni>=m || nj<0 || nj>=n || grid[ni][nj]>0 || visited.contains(ni*n+nj)) continue;
                    queue.addLast(ni*n+nj);
                    visited.add(ni*n+nj);
                    grid[ni][nj] -= dist;
                    count[ni][nj]++;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
