//We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever. 
//
// We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible. 
//
// 
//Example:
//Input: 
//routes = [[1, 2, 7], [3, 6, 7]]
//S = 1
//T = 6
//Output: 2
//Explanation: 
//The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
// 
//
// Note: 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 500. 
// 0 <= routes[i][j] < 10 ^ 6. 
// 
// Related Topics Breadth-first Search


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int bus=0; bus<routes.length; bus++){
            for (int stop: routes[bus]) {
                ArrayList<Integer> t = graph.getOrDefault(stop, new ArrayList<>());
                t.add(bus);
                graph.put(stop, t);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int[] visited = new int[routes.length];
        Arrays.fill(visited, 0);
        int buses = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            buses++;
            for (int i=0; i<size; i++){
                int stop = queue.poll();
                if (!graph.containsKey(stop)) continue;
                for (int bus: graph.get(stop)){
                    if (visited[bus] ==1)continue;
                    visited[bus] = 1;
                    for (int s: routes[bus]){
                        if (s==T) return buses;
                        queue.offer(s);
                    }
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
