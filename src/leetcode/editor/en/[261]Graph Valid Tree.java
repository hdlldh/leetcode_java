//Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree. 
//
// Example 1: 
//
// 
//Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//Output: true 
//
// Example 2: 
//
// 
//Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//Output: false 
//
// Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges. 
// Related Topics Depth-first Search Breadth-first Search Union Find Graph

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validTree2(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> outEdges = new HashMap<>();
        for (int i=0;i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            HashSet<Integer> t;
            t = outEdges.getOrDefault(u, new HashSet<>());
            t.add(v);
            outEdges.put(u, t);
            t = outEdges.getOrDefault(v, new HashSet<>());
            t.add(u);
            outEdges.put(v, t);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()){
            int u = queue.poll();
            if (!outEdges.containsKey(u)) continue;
            for (int v: outEdges.get(u)){
                if (visited.contains(v)) return false;
                queue.offer(v);
                visited.add(v);
                outEdges.get(v).remove(u);
            }
        }
        if (visited.size()!=n) return false;
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i=0; i<n; i++) roots[i] = i;
        for (int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int x = find(roots, u);
            int y = find(roots, v);
            if (x==y) return false;
            roots[x] = y;
            n--;
        }
        return n==1;
    }
    private int find(int[] roots, int i){
        while (roots[i]!=i) i = roots[i];
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
