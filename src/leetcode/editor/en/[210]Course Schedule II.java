//There are a total of n courses you have to take, labeled from 0 to n-1. 
//
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] 
//
// Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses. 
//
// There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array. 
//
// Example 1: 
//
// 
//Input: 2, [[1,0]] 
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
//             course 0. So the correct course order is [0,1] . 
//
// Example 2: 
//
// 
//Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,1,2,3] or [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
//             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
//             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] . 
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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] ans;
        if (visited.size()==numCourses) {
            ans = new int[numCourses];
            for (int i=0; i<numCourses; i++) ans[i] = visited.get(i);
            return ans;
        }
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
