//There are N network nodes, labelled 1 to N. 
//
// Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target. 
//
// Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1. 
//
// 
//
// Example 1: 
//
// 
//
// 
//Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//Output: 2
// 
//
// 
//
// Note: 
//
// 
// N will be in the range [1, 100]. 
// K will be in the range [1, N]. 
// The length of times will be in the range [1, 6000]. 
// All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100. 
// 
// Related Topics Heap Depth-first Search Breadth-first Search Graph


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i=0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            HashMap<Integer, Integer> t = graph.getOrDefault(u, new HashMap<>());
            t.put(v, w);
            graph.put(u, t);
        }
        HashMap<Integer, Integer> dist = new HashMap<>();
        int maxD = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)->x[0]));
        int[] pair = new int[2];
        pair[0] = 0;
        pair[1] = K;
        pq.offer(pair);
        while (!pq.isEmpty()){
            pair = pq.poll();
            int u = pair[1];
            int d = pair[0];
            if (dist.containsKey(u)) continue;
            dist.put(u, d);
            maxD = Math.max(maxD, d);
            if (!graph.containsKey(u)) continue;
            for (int v: graph.get(u).keySet()){
                if (dist.containsKey(v)) continue;
                pair = new int[2];
                pair[1] = v;
                pair[0] = d + graph.get(u).get(v);
                pq.offer(pair);
            }
        }
        if (dist.size()==N) return maxD;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
