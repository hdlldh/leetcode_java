//Given a string S, check if the letters can be rearranged so that two character
//s that are adjacent to each other are not the same. 
//
// If possible, output any possible result. If not possible, return the empty st
//ring. 
//
// Example 1: 
//
// 
//Input: S = "aab"
//Output: "aba"
// 
//
// Example 2: 
//
// 
//Input: S = "aaab"
//Output: ""
// 
//
// Note: 
//
// 
// S will consist of lowercase letters and have length in range [1, 500]. 
// 
//
// 
// Related Topics String Heap Greedy Sort


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = S.length();
        for (char ch: S.toCharArray()) count.put(ch-'a', count.getOrDefault(ch-'a', 0)+1);
        for (int v: count.values()){
            if (v> (n+1)/2) return new String();
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)->-x[0]));
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        while (pq.size()>1){
            int[] p1 = pq.poll();
            int[] p2 = pq.poll();
            ans.append((char) ('a' +p1[1]));
            p1[0] -= 1;
            if (p1[0]!=0) pq.offer(p1);
            ans.append((char) ('a' +p2[1]));
            p2[0] -= 1;
            if (p2[0]!=0) pq.offer(p2);
        }
        if (!pq.isEmpty()){
            int[] p1 = pq.poll();
            ans.append((char) ('a' +p1[1]));
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
