//Starting with an undirected graph (the "original graph") with nodes from 0 to 
//N-1, subdivisions are made to some of the edges. 
//
// The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) 
//such that (i, j) is an edge of the original graph, 
//
// and n is the total number of new nodes on that edge. 
//
// Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x
//_2, ..., x_n) are added to the original graph, 
//
// and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n
//, j) are added to the original graph. 
//
// Now, you start at node 0 from the original graph, and in each move, you trave
//l along one edge. 
//
// Return how many nodes you can reach in at most M moves. 
//
// 
//
// Example 1: 
//
// 
//Input: edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
//Output: 13
//Explanation: 
//The nodes that are reachable in the final graph after M = 6 moves are indicate
//d below.
//
// 
//
// 
// Example 2: 
//
// 
//Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
//Output: 23 
//
// 
// 
//
// Note: 
//
// 
// 0 <= edges.length <= 10000 
// 0 <= edges[i][0] < edges[i][1] < N 
// There does not exist any i != j for which edges[i][0] == edges[j][0] and edge
//s[i][1] == edges[j][1]. 
// The original graph has no parallel edges. 
// 0 <= edges[i][2] <= 10000 
// 0 <= M <= 10^9 
// 1 <= N <= 3000 
// A reachable node is a node that can be travelled to using at most M moves sta
//rting from node 0. 
// 
//
// 
// 
// 
// Related Topics Heap



import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i=0; i<edges.length; i++){
            graph.putIfAbsent(edges[i][0], new HashMap<>());
            graph.putIfAbsent(edges[i][1], new HashMap<>());
            HashMap<Integer, Integer> t = graph.get(edges[i][0]);
            t.put(edges[i][1], edges[i][2]+1);
            t = graph.get(edges[i][1]);
            t.put(edges[i][0], edges[i][2]+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)-> -x[0]));
        pq.offer(new int[]{M, 0});
        HashMap<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()){
            int[] p = pq.poll();
            if (seen.containsKey(p[1])) continue;
            if (p[0]<0) break;
            seen.put(p[1], p[0]);
            for (int v: graph.getOrDefault(p[1], new HashMap<>()).keySet()){
                if (seen.containsKey(v)) continue;
                pq.offer(new int[]{p[0]-graph.get(p[1]).get(v), v});
            }
        }
        int ans = seen.size();
        for (int i=0; i<edges.length; i++){
            int nu = (seen.containsKey(edges[i][0]))? seen.get(edges[i][0]): 0;
            int nv = (seen.containsKey(edges[i][1]))? seen.get(edges[i][1]): 0;
            ans += Math.min(edges[i][2], nu+nv);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
