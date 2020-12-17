//You are given a m x n 2D grid initialized with these three possible values. 
//
// 
// -1 - A wall or an obstacle. 
// 0 - A gate. 
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647. 
// 
//
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF. 
//
// Example: 
//
// Given the 2D grid: 
//
// 
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
// 
//
// After running your function, the 2D grid should be: 
//
// 
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
// 
// Related Topics Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m==0) return;
        int n = rooms[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (rooms[i][j]==0){
                    queue.addLast(i);
                    queue.addLast(j);
                }
            }
        }
        int level = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()){
            int size = queue.size()/2;
            level++;
            for (int k=0; k< size; k++){
                int i = queue.removeFirst();
                int j = queue.removeFirst();
                for (int l=0; l<4; l++){
                    int ni = i + dx[l];
                    int nj = j + dy[l];
                    if (ni<0 || ni>=m || nj<0 || nj>=n || rooms[ni][nj]<level) continue;
                    rooms[ni][nj] = level;
                    queue.addLast(ni);
                    queue.addLast(nj);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
