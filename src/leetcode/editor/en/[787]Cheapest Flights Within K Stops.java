//There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w. 
//
// Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1. 
//
// 
//Example 1:
//Input: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//Output: 200
//Explanation: 
//The graph looks like this:
//
//
//The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture. 
//
// 
//Example 2:
//Input: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//Output: 500
//Explanation: 
//The graph looks like this:
//
//
//The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture. 
//
// Note: 
//
// 
// The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1. 
// The size of flights will be in range [0, n * (n - 1) / 2]. 
// The format of each flight will be (src, dst, price). 
// The price of each flight will be in the range [1, 10000]. 
// k is in the range of [0, n - 1]. 
// There will not be any duplicated flights or self cycles. 
// 
// Related Topics Dynamic Programming Heap Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i=0; i<flights.length; i++){
            HashMap<Integer, Integer> t = graph.getOrDefault(flights[i][0], new HashMap<>());
            t.put(flights[i][1], flights[i][2]);
            graph.put(flights[i][0], t);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int[] pair = new int[2];
        pair[0] = src;
        pair[1] = 0;
        queue.offer(pair);
        int ans = Integer.MAX_VALUE;
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                pair = queue.poll();
                int u = pair[0];
                int cost = pair[1];
                if (u==dst) ans = Math.min(ans, cost);
                if (!graph.containsKey(u)) continue;
                for (int v: graph.get(u).keySet()){
                    if (cost+graph.get(u).get(v)>= ans) continue;
                    pair = new int[2];
                    pair[0] = v;
                    pair[1] = cost + graph.get(u).get(v);
                    queue.offer(pair);
                }
            }
            steps++;
            if (steps-1>K) break;
        }
        if (ans<Integer.MAX_VALUE) return ans;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
