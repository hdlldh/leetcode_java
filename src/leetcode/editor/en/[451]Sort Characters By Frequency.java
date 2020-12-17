//Given a string, sort it in decreasing order based on the frequency of characters. 
//
// Example 1:
// 
//Input:
//"tree"
//
//Output:
//"eert"
//
//Explanation:
//'e' appears twice while 'r' and 't' both appear once.
//So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// 
// 
//
// Example 2:
// 
//Input:
//"cccaaa"
//
//Output:
//"cccaaa"
//
//Explanation:
//Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
//Note that "cacaca" is incorrect, as the same characters must be together.
// 
// 
//
// Example 3:
// 
//Input:
//"Aabb"
//
//Output:
//"bbAa"
//
//Explanation:
//"bbaA" is also a valid answer, but "Aabb" is incorrect.
//Note that 'A' and 'a' are treated as two different characters.
// 
// Related Topics Hash Table Heap


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Pair{
    Pair(char key, int val){
        this.key = key;
        this.val = val;
    }
    char key;
    int val;
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char ch: s.toCharArray()) counter.put(ch, counter.getOrDefault(ch, 0)+1);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing((Pair p)->-p.val));
        for (Map.Entry<Character, Integer> m: counter.entrySet()){
            Pair p = new Pair(m.getKey(), m.getValue());
            pq.offer(p);
        }
        String ans = "";
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            char[] t = new char[p.val];
            Arrays.fill(t, p.key);
            ans += new String(t);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
