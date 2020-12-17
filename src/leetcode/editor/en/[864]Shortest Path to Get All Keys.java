//We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is
// the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks. 
//
// We start at the starting point, and one move consists of walking one space in
// one of the 4 cardinal directions. We cannot walk outside the grid, or walk into
// a wall. If we walk over a key, we pick it up. We can't walk over a lock unless 
//we have the corresponding key. 
//
// For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter
// of the first K letters of the English alphabet in the grid. This means that the
//re is exactly one key for each lock, and one lock for each key; and also that th
//e letters used to represent the keys and locks were chosen in the same order as 
//the English alphabet. 
//
// Return the lowest number of moves to acquire all keys. If it's impossible, re
//turn -1. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: ["@.a.#","###.#","b.A.B"]
//Output: 8
// 
//
// 
// Example 2: 
//
// 
//Input: ["@..aA","..B#.","....b"]
//Output: 6
// 
// 
//
// 
//
// Note: 
//
// 
// 1 <= grid.length <= 30 
// 1 <= grid[0].length <= 30 
// grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F' 
// The number of keys is in [1, 6]. Each key has a different letter and opens ex
//actly one lock. 
// 
// 
// Related Topics Heap Breadth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> seen= new HashSet<>();
        int allKey = 0;
        int status = 0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i].charAt(j)=='@'){
                    status = (i<<16) | (j<<8);
                    queue.offer(status);
                    seen.add(status);
                }else if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f'){
                    allKey |= 1<<(grid[i].charAt(j)-'a');
                }
            }
        }
        int steps = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int t=0; t<size; t++){
                status = queue.poll();
                int i = status>>16;
                int j = status>>8 & 0xFF;
                int s = status & 0xFF;
                if (s==allKey) return steps;
                for (int k=0; k<4; k++) {
                    int ti = i + dirs[k];
                    int tj = j + dirs[k + 1];
                    if (ti < 0 || ti >= m || tj < 0 || tj >= n) continue;
                    char ch = grid[ti].charAt(tj);
                    if (ch == '#') continue;
                    if (ch >= 'A' && ch <= 'F' && (s & (1 << (ch - 'A'))) == 0) continue;
                    int new_status = s | (ti << 16) | (tj << 8);
                    if (ch >= 'a' && ch <= 'f') new_status |= 1 << (ch - 'a');
                    if (seen.contains(new_status)) continue;
                    queue.offer(new_status);
                    seen.add(new_status);
                }
            }
            steps++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
