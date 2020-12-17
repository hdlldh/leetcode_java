//There is a ball in a maze with empty spaces and walls. The ball can go through
// empty spaces by rolling up, down, left or right, but it won't stop rolling unti
//l hitting a wall. When the ball stops, it could choose the next direction. 
//
// Given the ball's start position, the destination and the maze, determine whet
//her the ball could stop at the destination. 
//
// The maze is represented by a binary 2D array. 1 means the wall and 0 means th
//e empty space. You may assume that the borders of the maze are all walls. The st
//art and destination coordinates are represented by row and column indexes. 
//
// 
//
// Example 1: 
//
// 
//Input 1: a maze represented by a 2D array
//
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//
//Input 2: start coordinate (rowStart, colStart) = (0, 4)
//Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//
//Output: true
//
//Explanation: One possible way is : left -> down -> left -> down -> right -> do
//wn -> right.
//
// 
//
// Example 2: 
//
// 
//Input 1: a maze represented by a 2D array
//
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//
//Input 2: start coordinate (rowStart, colStart) = (0, 4)
//Input 3: destination coordinate (rowDest, colDest) = (3, 2)
//
//Output: false
//
//Explanation: There is no way for the ball to stop at the destination.
//
// 
//
// 
//
// Note: 
//
// 
// There is only one ball and one destination in the maze. 
// Both the ball and the destination exist on an empty space, and they will not 
//be at the same position initially. 
// The given maze does not contain border (like the red rectangle in the example
// pictures), but you could assume the border of the maze are all walls. 
// The maze contains at least 2 empty spaces, and both the width and height of t
//he maze won't exceed 100. 
// 
// Related Topics Depth-first Search Breadth-first Search

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m= maze.length;
        int n = maze[0].length;
        int[] dirs ={-1, 0, 1, 0, -1};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        int[][] visited =  new int[m][n];
        visited[start[0]][start[1]] = 1;
        while (!queue.isEmpty()){
            int[] u = queue.poll();
            System.out.println(u[0]+","+u[1]);
            if (u[0]==destination[0] && u[1]==destination[1]) return true;
            for (int k=0; k<4; k++){
                int vx = u[0] + dirs[k];
                int vy = u[1] + dirs[k+1];
                while (vx>=0 && vx<m && vy>=0 && vy<n && maze[vx][vy]==0){
                    vx += dirs[k];
                    vy += dirs[k+1];
                }
                vx -= dirs[k];
                vy -= dirs[k+1];
                if (visited[vx][vy]==0){
                    queue.offer(new int[]{vx, vy});
                    visited[vx][vy] = 1;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
