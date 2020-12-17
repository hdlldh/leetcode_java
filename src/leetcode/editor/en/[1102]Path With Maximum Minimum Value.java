//Given a matrix of integers A with R rows and C columns, find the maximum score
// of a path starting at [0,0] and ending at [R-1,C-1]. 
//
// The score of a path is the minimum value in that path. For example, the value
// of the path 8 → 4 → 5 → 9 is 4. 
//
// A path moves some number of times from one visited cell to any neighbouring u
//nvisited cell in one of the 4 cardinal directions (north, east, west, south). 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: [[5,4,5],[1,2,6],[7,4,6]]
//Output: 4
//Explanation: 
//The path with the maximum score is highlighted in yellow. 
// 
//
// Example 2: 
//
// 
//
// 
//Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
//Output: 2 
//
// Example 3: 
//
// 
//
// 
//Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3
//]]
//Output: 3 
//
// 
//
// Note: 
//
// 
// 1 <= R, C <= 100 
// 0 <= A[i][j] <= 10^9 
// 
// Related Topics Depth-first Search Union Find Graph


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)->-x[0]));
        pq.offer(new int[]{A[0][0], 0, 0});
        int[][] seen = new int[m][n];
        int ans = A[0][0];
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()){
            int[] p = pq.poll();
            if (seen[p[1]][p[2]]==1) continue;
            seen[p[1]][p[2]]=1;
            ans = Math.min(ans, p[0]);
            if (p[1]==m-1 && p[2]==n-1) return ans;
            for (int k=0; k<4; k++){
                int ti = p[1]+dirs[k];
                int tj = p[2]+dirs[k+1];
                if (ti<0 || ti>=m || tj<0 || tj>=n) continue;
                pq.offer(new int[]{A[ti][tj], ti, tj});
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
