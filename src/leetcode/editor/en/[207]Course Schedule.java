//There are a total of n courses you have to take, labeled from 0 to n-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses? 
//
// Example 1: 
//
// 
//Input: 2, [[1,0]] 
//Output: true
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0. So it is possible. 
//
// Example 2: 
//
// 
//Input: 2, [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0, and to take course 0 you should
//             also have finished course 1. So it is impossible.
// 
//
// Note: 
//
// 
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented. 
// You may assume that there are no duplicate edges in the input prerequisites. 
// 
// Related Topics Depth-first Search Breadth-first Search Graph Topological Sort


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> outEdges = new HashMap<>();
        for (int i=0; i<prerequisites.length; i++){
            int s = prerequisites[i][1];
            int t = prerequisites[i][0];
            inDegree.put(t, inDegree.getOrDefault(t, 0)+1);
            HashSet<Integer> tmp = outEdges.getOrDefault(s, new HashSet<>());
            tmp.add(t);
            outEdges.put(s, tmp);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        for (int i=0; i<numCourses; i++){
            if (inDegree.getOrDefault(i, 0)==0){
                queue.offer(i);
                visited.add(i);
            }
        }

        while (!queue.isEmpty()){
            int s = queue.poll();
            if (!outEdges.containsKey(s)) continue;
            for (int t: outEdges.get(s)){
                int edges = inDegree.get(t);
                edges--;
                if (edges==0){
                    queue.offer(t);
                    visited.add(t);
                }
                inDegree.put(t, edges);
            }
        }
        return visited.size()==numCourses;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
