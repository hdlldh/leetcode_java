//Given a pattern and a string str, find if str follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str. 
//
// Example 1: 
//
// 
//Input: pattern = "abab", str = "redblueredblue"
//Output: true 
//
// Example 2: 
//
// 
//Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
//Output: true 
//
// Example 3: 
//
// 
//Input: pattern = "aabb", str = "xyzabcxzyabc"
//Output: false
// 
//
// Notes: 
//You may assume both pattern and str contains only lowercase letters. 
// Related Topics Backtracking


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();
        return dfs(pattern, str, p2s, s2p);
    }
    private boolean dfs(String pattern, String str, HashMap<Character, String> p2s, HashMap<String, Character> s2p){
        if (pattern.isEmpty() && str.isEmpty()) return true;
        if (pattern.isEmpty() || str.isEmpty()) return false;
        char p = pattern.charAt(0);
        for (int i=1; i<=str.length(); i++){
            String s = str.substring(0,i);
            if (p2s.containsKey(p) && s2p.containsKey(s)){
                if (!p2s.get(p).equals(s) || s2p.get(s)!=p) continue;
                if (dfs(pattern.substring(1), str.substring(i), p2s, s2p)) return true;
            }else if (!p2s.containsKey(p) && !s2p.containsKey(s)){
                p2s.put(p, s);
                s2p.put(s, p);
                if (dfs(pattern.substring(1), str.substring(i), p2s, s2p)) return true;
                p2s.remove(p);
                s2p.remove(s);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
