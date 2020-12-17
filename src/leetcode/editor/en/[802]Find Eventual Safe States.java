//In a directed graph, we start at some node and every turn, walk along a directed edge of the graph. If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop. 
//
// Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node. More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps. 
//
// Which nodes are eventually safe? Return them as an array in sorted order. 
//
// The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph. The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph. 
//
// 
//Example:
//Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//Output: [2,4,5,6]
//Here is a diagram of the above graph.
//
// 
//
// 
//
// Note: 
//
// 
// graph will have length at most 10000. 
// The number of edges in the graph will not exceed 32000. 
// Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1]. 
// 
// Related Topics Depth-first Search Graph


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> outEdges = new HashMap<>();
        for (int i=0;i<n; i++){
            inDegree.put(i, graph[i].length);
            for (int j: graph[i]){
                HashSet<Integer> t = outEdges.getOrDefault(j, new HashSet<>());
                t.add(i);
                outEdges.put(j, t);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (inDegree.getOrDefault(i, 0)==0) queue.offer(i);
        }
        while (!queue.isEmpty()){
            int u = queue.poll();
            ans.add(u);
            if (!outEdges.containsKey(u)) continue;
            for (int v: outEdges.get(u)){
                inDegree.put(v, inDegree.getOrDefault(v, 0)-1);
                if (inDegree.get(v)==0) queue.offer(v);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
