//
//Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
// 
//
// Example 1:
// 
//Input:
//s = "aaabb", k = 3
//
//Output:
//3
//
//The longest substring is "aaa", as 'a' is repeated 3 times.
// 
// 
//
// Example 2:
// 
//Input:
//s = "ababbc", k = 2
//
//Output:
//5
//
//The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
// 
//


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        HashSet<Character> splitSet = new HashSet<>();
        for (char ch: map.keySet())
            if (map.get(ch)<k) splitSet.add(ch);
        if (splitSet.size()==0) return n;
        int ans = 0;
        int i = 0;
        int j = 0;
        while (j<n){
            char ch = s.charAt(j);
            if (splitSet.contains(ch)){
                if (j>i) ans = Math.max(ans, longestSubstring(s.substring(i,j), k));
                i = j+1;
            }
            j++;
        }
        if (j>i) ans = Math.max(ans, longestSubstring(s.substring(i,j), k));
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
