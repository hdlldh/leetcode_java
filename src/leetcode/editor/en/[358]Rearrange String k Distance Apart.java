//Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other. 
//
// All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "". 
//
// Example 1: 
//
// 
// 
//Input: s = "aabbcc", k = 3
//Output: "abcabc" 
//Explanation: The same letters are at least distance 3 from each other.
// 
//
// 
// Example 2: 
//
// 
//Input: s = "aaabc", k = 3
//Output: "" 
//Explanation: It is not possible to rearrange the string.
// 
//
// 
// Example 3: 
//
// 
//Input: s = "aaadbbcc", k = 2
//Output: "abacabcd"
//Explanation: The same letters are at least distance 2 from each other.
// 
// 
// 
// Related Topics Hash Table Heap Greedy


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Pair{
    char ch;
    int cnt;
    Pair(char ch, int cnt){
        this.ch=ch;
        this.cnt = cnt;
    }
}
class Solution {
    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char ch: s.toCharArray()) counter.put(ch, counter.getOrDefault(ch,0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing((Pair x)-> -x.cnt));
        for (char ch: counter.keySet()) pq.offer(new Pair(ch, counter.get(ch)));
        Queue<Pair> buffer = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            ans.append(p.ch);
            p.cnt -= 1;
            buffer.add(p);
            if (buffer.size()>=k){
                Pair q = buffer.poll();
                if (q.cnt!=0) pq.offer(q);
            }
        }
        if (ans.length()!=s.length()) return "";
        return ans.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
