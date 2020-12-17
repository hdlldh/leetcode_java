//On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j). 
//
// Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim. 
//
// You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)? 
//
// Example 1: 
//
// 
//Input: [[0,2],[1,3]]
//Output: 3
//Explanation:
//At time 0, you are in grid location (0, 0).
//You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
//
//You cannot reach point (1, 1) until time 3.
//When the depth of water is 3, we can swim anywhere inside the grid.
// 
//
// Example 2: 
//
// 
//Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
//Output: 16
//Explanation:
// 0  1  2  3  4
//24 23 22 21  5
//12 13 14 15 16
//11 17 18 19 20
//10  9  8  7  6
//
//The final route is marked in bold.
//We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
// 
//
// Note: 
//
// 
// 2 <= N <= 50. 
// grid[i][j] is a permutation of [0, ..., N*N - 1]. 
// 
// Related Topics Binary Search Heap Depth-first Search Union Find

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int swimInWater2(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[]x )->x[0]));
        pq.offer(new int[]{grid[0][0],0, 0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0*n+0);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!pq.isEmpty()){
            int[] u = pq.poll();
            if (u[1]==n-1 && u[2]==n-1) return u[0];
            for (int k=0; k<4; k++){
                int tx = u[1] + dx[k];
                int ty = u[2] + dy[k];
                if (tx<0 || tx>=n || ty<0 || ty>=n) continue;
                if (visited.contains(tx*n+ty)) continue;
                int v = Math.max(u[0], grid[tx][ty]);
                pq.offer(new int[]{v, tx, ty});
                visited.add(tx*n+ty);
            }
        }
        return 0;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = grid[0][0];
        int high = n*n -1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (bfs(grid, mid)) high = mid -1;
            else low = mid +1;
        }
        return low;
    }
    private boolean bfs(int[][] grid, int target){
        int n = grid.length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] visited = new int[n][n];
        visited[0][0] = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()){
            int[] u = queue.poll();
            if (u[0]==n-1 && u[1]== n-1) return true;
            for (int k=0; k<4; k++){
                int tx = u[0] + dx[k];
                int ty = u[1] + dy[k];
                if (tx<0 || tx>=n || ty<0 || ty>=n || grid[tx][ty]>target || visited[tx][ty]==1) continue;
                queue.offer(new int[]{tx, ty});
                visited[tx][ty] = 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
