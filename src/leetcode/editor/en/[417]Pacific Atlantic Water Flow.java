//Given an m x n matrix of non-negative integers representing the height of each
// unit cell in a continent, the "Pacific ocean" touches the left and top edges of
// the matrix and the "Atlantic ocean" touches the right and bottom edges. 
//
// Water can only flow in four directions (up, down, left, or right) from a cell
// to another one with height equal or lower. 
//
// Find the list of grid coordinates where water can flow to both the Pacific an
//d Atlantic ocean. 
//
// Note: 
//
// 
// The order of returned grid coordinates does not matter. 
// Both m and n are less than 150. 
// 
//
// 
//
// Example: 
//
// 
//Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
//Return:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with paren
//theses in above matrix).
// 
//
// 
// Related Topics Depth-first Search Breadth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = matrix.length;
        if (m==0) return ans;
        int n = matrix[0].length;
        LinkedList<int[]> pac_queue = new LinkedList<>();
        int[][] pac_visited = new int[m][n];
        LinkedList<int[]> ant_queue = new LinkedList<>();
        int[][] ant_visited = new int[m][n];
        for (int i=0; i<m; i++){
            pac_queue.offer(new int[]{i, 0});
            pac_visited[i][0] = 1;
            ant_queue.offer(new int[]{i, n-1});
            ant_visited[i][n-1] = 1;
        }
        for (int j=0; j<n; j++){
            pac_queue.offer(new int[]{0, j});
            pac_visited[0][j] = 1;
            ant_queue.offer(new int[]{m-1, j});
            ant_visited[m-1][j] =1;
        }
        helper(matrix, pac_queue, pac_visited);
        helper(matrix, ant_queue, ant_visited);
        for (int i = 0; i<m; i++){
            for (int j=0; j<n; j++){
                if (pac_visited[i][j]==1 && ant_visited[i][j]==1){
                    ArrayList<Integer> p = new ArrayList<>();
                    p.add(i);
                    p.add(j);
                    ans.add(p);
                }
            }
        }
        return ans;
    }
    private void helper(int[][] matrix, LinkedList<int[]> queue, int[][] visited){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()){
            int[] u = queue.poll();
            int x = u[0];
            int y = u[1];
            for (int k=0; k<4; k++){
                int tx = x+dx[k];
                int ty = y+dy[k];
                if (tx<0 || tx>=m || ty<0 || ty>=n) continue;
                if (matrix[tx][ty]<matrix[x][y] || visited[tx][ty]==1) continue;
                queue.offer(new int[]{tx, ty});
                visited[tx][ty]=1;
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
