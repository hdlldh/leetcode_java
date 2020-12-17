//There are n servers numbered from 0 to n-1 connected by undirected server-to-s
//erver connections forming a network where connections[i] = [a, b] represents a c
//onnection between servers a and b. Any server can reach any other server directl
//y or indirectly through the network. 
//
// A critical connection is a connection that, if removed, will make some server
// unable to reach some other server. 
//
// Return all critical connections in the network in any order. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//Output: [[1,3]]
//Explanation: [[3,1]] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10^5 
// n-1 <= connections.length <= 10^5 
// connections[i][0] != connections[i][1] 
// There are no repeated connections. 
// 
// Related Topics Depth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int id;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i=0;i<n;i++) graph[i] = new ArrayList<>();
        for (List<Integer> conn: connections){
            int u = conn.get(0);
            int v = conn.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        id = 0;
        int[] ids = new int[n];
        Arrays.fill(ids, -1);
        int[] low = new int[n];
        for (int i=0; i<n; i++){
            if (ids[i]==-1) dfs(graph,i, ids, low, i, ans);
        }
        return ans;
    }
    private void dfs(List<Integer>[] graph, int u, int[] ids, int[] low, int parent, List<List<Integer>> ans){
        ids[u] = id;
        low[u] = id;
        id++;
        for (int j=0; j< graph[u].size(); j++){
            int v = graph[u].get(j);
            if (v == parent) continue;
            if (ids[v]==-1) {
                dfs(graph, v, ids, low, u, ans);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > ids[u]) ans.add(Arrays.asList(u, v));
            }
            else{
                low[u] = Math.min(low[u], ids[v]);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
