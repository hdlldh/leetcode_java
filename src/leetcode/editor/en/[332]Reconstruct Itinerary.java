//Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK. 
//
// Note: 
//
// 
// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. 
// All airports are represented by three capital letters (IATA code). 
// You may assume all tickets form at least one valid itinerary. 
// 
//
// Example 1: 
//
// 
//Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// Example 2: 
//
// 
//Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//             But it is larger in lexical order.
// 
// Related Topics Depth-first Search Graph


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (int i=0; i<tickets.size(); i++){
            String start = tickets.get(i).get(0);
            String end = tickets.get(i).get(1);
            if (!map.containsKey(start)) map.put(start, new PriorityQueue<>());
            map.get(start).add(end);
        }
        dfs("JFK");
        return ans;
    }

    private void dfs(String s){
        PriorityQueue<String> q = map.get(s);
        while (q!=null && !q.isEmpty()) dfs(q.poll());
        ans.addFirst(s);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
