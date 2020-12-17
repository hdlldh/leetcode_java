//In a given 2D binary array A, there are two islands. (An island is a 4-directi
//onally connected group of 1s not connected to any other 1s.) 
//
// Now, we may change 0s to 1s so as to connect the two islands together to form
// 1 island. 
//
// Return the smallest number of 0s that must be flipped. (It is guaranteed that
// the answer is at least 1.) 
//
// 
//
// Example 1: 
//
// 
//Input: [[0,1],[1,0]]
//Output: 1
// 
//
// 
// Example 2: 
//
// 
//Input: [[0,1,0],[0,0,0],[0,0,1]]
//Output: 2
// 
//
// 
// Example 3: 
//
// 
//Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//Output: 1 
//
// 
// 
// 
//
// Note: 
//
// 
// 1 <= A.length = A[0].length <= 100 
// A[i][j] == 0 or A[i][j] == 1 
// 
//
// 
// 
// 
// 
// Related Topics Depth-first Search Breadth-first Search



import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        boolean found = false;
        for (int i=0; i<m && !found; i++){
            for (int j=0; j<n && !found; j++){
                if (A[i][j]==1){
                    found = true;
                    dfs(A, i, j, visited, queue);
                }
            }
        }

        int steps = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                int[] p = queue.poll();
                for (int k=0; k<4; k++){
                    int ti = p[0] + dirs[k];
                    int tj = p[1] + dirs[k+1];
                    if (ti<0 || ti>=m || tj<0 || tj>=n) continue;
                    if (visited[ti][tj]==1) continue;
                    if (A[ti][tj]==1) return steps;
                    queue.offer(new int[]{ti, tj});
                    visited[ti][tj]=1;
                }
                size--;
            }
            steps++;
        }
        return steps;
    }
    private void dfs(int[][] A, int i, int j, int[][] visited, Queue<int[]> queue){
        int m = A.length;
        int n = A[0].length;
        if (i<0 || i>=m || j<0 || j>=n) return;
        if (A[i][j]==0 || visited[i][j]==1) return;
        queue.offer(new int[]{i, j});
        visited[i][j] = 1;
        int[] dirs = {-1, 0, 1, 0, -1};
        for (int k=0; k<4; k++) {
            int ti = i+dirs[k];
            int tj = j+dirs[k+1];
            dfs(A, ti, tj, visited, queue);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
