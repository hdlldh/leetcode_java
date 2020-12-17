//In an N by N square grid, each cell is either empty (0) or blocked (1). 
//
// A clear path from top-left to bottom-right has length k if and only if it is 
//composed of cells C_1, C_2, ..., C_k such that: 
//
// 
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are d
//ifferent and share an edge or corner) 
// C_1 is at location (0, 0) (ie. has value grid[0][0]) 
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1]) 
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0). 
//
// 
//
// Return the length of the shortest such clear path from top-left to bottom-rig
//ht. If such a path does not exist, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: [[0,1],[1,0]]
//
//
//Output: 2
//
// 
//
// 
// Example 2: 
//
// 
//Input: [[0,0,0],[1,1,0],[1,1,0]]
//
//
//Output: 4
//
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[r][c] is 0 or 1 
// 
// Related Topics Breadth-first Search

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0]==1) return -1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] visited = new int[m][n];
        visited[0][0] = 1;
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int s=0; s<size; s++){
                int[] p = queue.poll();
                if (p[0]==m-1 && p[1]==n-1) return steps+1;
                for (int dx=-1; dx<=1; dx++){
                    for (int dy=-1; dy<=1; dy++){
                        int vx = p[0] + dx;
                        int vy = p[1] + dy;
                        if (vx<0||vx>=m||vy<0||vy>=n) continue;
                        if (grid[vx][vy]==1 || visited[vx][vy]==1) continue;
                        queue.offer(new int[]{vx, vy});
                        visited[vx][vy]=1;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
