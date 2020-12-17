//Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0. 
//
// Example: 
//Given a / b = 2.0, b / c = 3.0. 
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
//return [6.0, 0.5, -1.0, 1.0, -1.0 ]. 
//
// The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>. 
//
// According to the example above: 
//
// 
//equations = [ ["a", "b"], ["b", "c"] ],
//values = [2.0, 3.0],
//queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
//
// 
//
// The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction. 
// Related Topics Union Find Graph


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, HashMap<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        for (int i=0; i<equations.size(); i++){
            String p = equations.get(i).get(0);
            String q = equations.get(i).get(1);
            HashMap<String, Double> t = graph.getOrDefault(p, new HashMap<>());
            t.put(q, values[i]);
            graph.put(p, t);
            t = graph.getOrDefault(q, new HashMap<>());
            t.put(p, 1.0/values[i]);
            graph.put(q, t);
        }
        ArrayList<Double> ans = new ArrayList<>();
        for (int i= 0; i< queries.size(); i++){
            String p = queries.get(i).get(0);
            String q = queries.get(i).get(1);
            if (!graph.containsKey(p) || ! graph.containsKey(q)) ans.add(-1.0);
            else if (p.equals(q)) ans.add(1.0);
            else ans.add(bfs(p, q));
        }
        double[] ans1 = new double[ans.size()];
        for (int i=0; i<ans.size(); i++) ans1[i] = ans.get(i);
        return ans1;
    }
    private double bfs(String p, String q){
        LinkedList<String> kqueue = new LinkedList<>();
        kqueue.offer(p);
        LinkedList<Double> vqueue = new LinkedList<>();
        vqueue.offer(1.0);
        HashSet<String> visited = new HashSet<>();
        visited.add(p);
        while (!kqueue.isEmpty()){
            p = kqueue.poll();
            double v = vqueue.poll();
            if (!graph.containsKey(p)) continue;
            for (String k: graph.get(p).keySet()){
                if (visited.contains(k)) continue;
                if (k.equals(q)) return v*graph.get(p).get(k);
                kqueue.offer(k);
                vqueue.offer(v*graph.get(p).get(k));
                visited.add(k);
            }
        }
        return -1.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
