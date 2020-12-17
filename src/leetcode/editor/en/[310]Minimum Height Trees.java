//For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels. 
//
// Format 
//The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels). 
//
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges. 
//
// Example 1 : 
//
// 
//Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
//
//        0
//        |
//        1
//       / \
//      2   3 
//
//Output: [1]
// 
//
// Example 2 : 
//
// 
//Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
//
//     0  1  2
//      \ | /
//        3
//        |
//        4
//        |
//        5 
//
//Output: [3, 4] 
//
// Note: 
//
// 
// According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.” 
// The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf. 
// 
// Related Topics Breadth-first Search Graph


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n==1){
            ans.add(0);
            return ans;
        }
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> outEdges = new HashMap<>();

        for (int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            inDegree.put(u, inDegree.getOrDefault(u, 0)+1);
            inDegree.put(v, inDegree.getOrDefault(v, 0)+1);
            HashSet<Integer> t = outEdges.getOrDefault(u, new HashSet<>());
            t.add(v);
            outEdges.put(u, t);
            t = outEdges.getOrDefault(v, new HashSet<>());
            t.add(u);
            outEdges.put(v, t);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++){
            if (inDegree.getOrDefault(i,0)==1) queue.offer(i);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            ans.clear();
            for (int i=0; i<size; i++){
                int u = queue.poll();
                ans.add(u);
                if (!outEdges.containsKey(u)) continue;
                for (int v: outEdges.get(u)){
                    int d = inDegree.get(v);
                    d--;
                    if (d==1) queue.offer(v);
                    inDegree.put(v, d);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
