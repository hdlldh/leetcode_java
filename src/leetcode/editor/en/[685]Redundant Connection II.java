//
//In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
// 
//The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
// 
//The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
// 
//Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
// Example 1: 
// 
//Input: [[1,2], [1,3], [2,3]]
//Output: [2,3]
//Explanation: The given directed graph will be like this:
//  1
// / \
//v   v
//2-->3
// 
// 
// Example 2: 
// 
//Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
//Output: [4,1]
//Explanation: The given directed graph will be like this:
//5 <- 1 -> 2
//     ^    |
//     |    v
//     4 <- 3
// 
// 
// Note: 
// The size of the input 2D-array will be between 3 and 1000. 
// Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array. 
// Related Topics Tree Depth-first Search Union Find Graph


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] roots = new int[n];
        for (int i=0; i<n; i++) roots[i] = i;
        HashMap<Integer, Integer> parents = new HashMap<>();
        int i;
        int[] first = null;
        int[] second = null;
        for (i=0; i<n; i++){
            int p = edges[i][0];
            int q = edges[i][1];
            if (parents.containsKey(q)){
                first = new int[2];
                first[0] = parents.get(q);
                first[1] = q;
                second = new int[2];
                second[0] = p;
                second[1] = q;
            }else parents.put(q, p);
        }
        for (i=0; i<n; i++){
            int p = edges[i][0];
            int q = edges[i][1];
            if (parents.get(q)!=p) continue;
            if (find(roots, p-1) == find(roots, q-1)){
                if (first==null) return edges[i];
                else return first;
            } union(roots, p-1, q-1);
            ;
        }
        return second;
    }
    private int find(int[] roots, int p){
        while (p!=roots[p]) p = roots[p];
        return p;
    }
    private void union(int[] roots, int p, int q){
        int root_p = find(roots, p);
        int root_q = find(roots, q);
        roots[root_q] = root_p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
