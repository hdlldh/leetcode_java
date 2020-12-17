//Given a set of N people (numbered 1, 2, ..., N), we would like to split everyo
//ne into two groups of any size. 
//
// Each person may dislike some other people, and they should not go into the sa
//me group. 
//
// Formally, if dislikes[i] = [a, b], it means it is not allowed to put the peop
//le numbered a and b into the same group. 
//
// Return true if and only if it is possible to split everyone into two groups i
//n this way. 
//
// 
//
// 
// 
// 
// 
// 
// 
//
// 
// Example 1: 
//
// 
//Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
//Output: true
//Explanation: group1 [1,4], group2 [2,3]
// 
//
// 
// Example 2: 
//
// 
//Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
//Output: false
// 
//
// 
// Example 3: 
//
// 
//Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//Output: false
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 2000 
// 0 <= dislikes.length <= 10000 
// 1 <= dislikes[i][j] <= N 
// dislikes[i][0] < dislikes[i][1] 
// There does not exist i != j for which dislikes[i] == dislikes[j]. 
// 
// 
// 
// 
// Related Topics Depth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, HashSet<Integer>> graph;
    public boolean possibleBipartition2(int N, int[][] dislikes) {
        graph = new HashMap<>();
        for (int[] p: dislikes){
            graph.putIfAbsent(p[0]-1, new HashSet<>());
            graph.putIfAbsent(p[1]-1, new HashSet<>());
            HashSet<Integer> t = graph.get(p[0]-1);
            t.add(p[1]-1);
            t = graph.get(p[1]-1);
            t.add(p[0]-1);
        }
        int[] colors = new int[N];
        for (int i=0; i<N; i++){
            if (colors[i]==0 && !dfs(i, 1, colors)) return false;
        }
        return true;
    }
    private boolean dfs(int i, int color, int[] colors){
        if (colors[i]==0){
            colors[i] = color;
            for (int j: graph.getOrDefault(i, new HashSet<>())){
                if (!dfs(j, -color, colors)) return false;
            }
            return true;
        }else return color==colors[i];
    }
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new HashMap<>();
        for (int[] p: dislikes){
            graph.putIfAbsent(p[0]-1, new HashSet<>());
            graph.putIfAbsent(p[1]-1, new HashSet<>());
            HashSet<Integer> t = graph.get(p[0]-1);
            t.add(p[1]-1);
            t = graph.get(p[1]-1);
            t.add(p[0]-1);
        }
        int[] colors = new int[N];
        for (int i=0; i<N; i++){
            if (colors[i]==0){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()){
                    i = queue.poll();
                    for (int j: graph.getOrDefault(i, new HashSet<>())){
                        if (colors[i]==colors[j]) return false;
                        if (colors[j]!=0) continue;
                        queue.offer(j);
                        colors[j] = -colors[i];
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
