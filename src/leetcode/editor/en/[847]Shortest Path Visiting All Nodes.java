//An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph. 
//
// graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected. 
//
// Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges. 
//
// 
//
// 
// 
//
// Example 1: 
//
// 
//Input: [[1,2,3],[0],[0],[0]]
//Output: 4
//Explanation: One possible path is [1,0,2,0,3] 
//
// Example 2: 
//
// 
//Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
//Output: 4
//Explanation: One possible path is [0,1,4,2,3]
// 
//
// 
//
// Note: 
//
// 
// 1 <= graph.length <= 12 
// 0 <= graph[i].length < graph.length 
// 
// Related Topics Dynamic Programming Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        LinkedList<int[]> queue = new LinkedList<>();
        int step = 0;
        int[] pair;
        for (int i=0; i<n; i++){
            pair = new int[2];
            pair[0] = i;
            pair[1] = 1<<i;
            queue.offer(pair);
        }
        int[][] visited = new int[n][1<<n];
        int target = (1<<n) -1;
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                pair = queue.poll();
                int u = pair[0];
                int status = pair[1];
                if (status==target) return steps;
                for (int v: graph[u]){
                    int status1 = status | (1<<v);
                    if (visited[v][status1]==1) continue;
                    visited[v][status1]=1;
                    pair = new int[2];
                    pair[0] = v;
                    pair[1] = status1;
                    queue.offer(pair);
                }
            }
            steps++;
        }
        return steps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
