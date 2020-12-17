//On a 2D plane, we place stones at some integer coordinate points. Each coordinate point may have at most one stone. 
//
// Now, a move consists of removing a stone that shares a column or row with another stone on the grid. 
//
// What is the largest possible number of moves we can make? 
//
// 
//
// 
// Example 1: 
//
// 
//Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//Output: 5
// 
//
// 
// Example 2: 
//
// 
//Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//Output: 3
// 
//
// 
// Example 3: 
//
// 
//Input: stones = [[0,0]]
//Output: 0
// 
//
// 
//
// Note: 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= stones[i][j] < 10000 
// 
// 
// 
// 
// Related Topics Depth-first Search Union Find


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[20000];
        for (int i=0; i<20000; i++) parent[i]=i;
        for (int[] stone: stones){
            union(parent, stone[0], stone[1]+10000);
        }
        HashSet<Integer> roots = new HashSet<>();
        for (int[] stone: stones) roots.add(find(parent, stone[0]));
        return n-roots.size();
    }
    private int find(int[] parent, int i){
        while (i!=parent[i]) i=parent[i];
        return i;
    }
    private void union(int[] parent, int i, int j){
        int root_i = find(parent, i);
        int root_j = find(parent, j);
        if (root_i!=root_j) parent[root_j] = root_i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
