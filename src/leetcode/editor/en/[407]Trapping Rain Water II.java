//Given an m x n matrix of positive integers representing the height of each uni
//t cell in a 2D elevation map, compute the volume of water it is able to trap aft
//er raining. 
//
// 
//
// Note: 
//
// Both m and n are less than 110. The height of each unit cell is greater than 
//0 and is less than 20,000. 
//
// 
//
// Example: 
//
// 
//Given the following 3x6 height map:
//[
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
//
//Return 4.
// 
//
// 
//
// The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,
//3,3,2,3,1]] before the rain. 
//
// 
//
// 
//
// After the rain, water is trapped between the blocks. The total volume of wate
//r trapped is 4. 
// Related Topics Heap Breadth-first Search


import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int ans = 0;
        int m = heightMap.length;
        if (m==0) return ans;
        int n = heightMap[0].length;
        int mxH = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)->x[0]));
        int[][] seen = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==0 || i==m-1 || j==0 || j==n-1){
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    seen[i][j] = 1;
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()){
            int[] u = pq.poll();
            mxH = Math.max(mxH, u[0]);
            for (int k=0; k<4; k++){
                int ti = u[1] + dirs[k];
                int tj = u[2] + dirs[k+1];
                if (ti<0 || ti>=m || tj<0 || tj>=n) continue;
                if (seen[ti][tj]==1) continue;
                ans += Math.max(0, mxH - heightMap[ti][tj]);
                pq.offer(new int[]{heightMap[ti][tj], ti, tj});
                seen[ti][tj] = 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
