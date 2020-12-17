//In an infinite chess board with coordinates from -infinity to +infinity, you h
//ave a knight at square [0, 0]. 
//
// A knight has 8 possible moves it can make, as illustrated below. Each move is
// two squares in a cardinal direction, then one square in an orthogonal direction
//. 
//
// 
//
// Return the minimum number of steps needed to move the knight to the square [x
//, y]. It is guaranteed the answer exists. 
//
// 
// Example 1: 
//
// 
//Input: x = 2, y = 1
//Output: 1
//Explanation: [0, 0] → [2, 1]
// 
//
// Example 2: 
//
// 
//Input: x = 5, y = 5
//Output: 4
//Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
// 
//
// 
// Constraints: 
//
// 
// |x| + |y| <= 300 
// 
// Related Topics Breadth-first Search

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] dirs = {{1,-2},{1,2},{-1,-2},{-1,2},{2,-1},{2,1},{-2,-1},{-2,1}};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        x = (x>=0)?x:-x;
        y = (y>=0)?y:-y;
        int[][] visited = new int[310][310];
        visited[3][3] = 1;
        int steps=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int s=0; s<size; s++){
                int[] p = queue.poll();
                if (p[0]==x && p[1]==y) return steps;
                for (int k=0; k<8; k++){
                    int tx = p[0]+dirs[k][0];
                    int ty = p[1]+dirs[k][1];
                    if (tx<-3 || ty<-3 || visited[tx+3][ty+3]==1) continue;
                    queue.offer(new int[]{tx, ty});
                    visited[tx+3][ty+3] = 1;
                }
            }
            steps++;
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
