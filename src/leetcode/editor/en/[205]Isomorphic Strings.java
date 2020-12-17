//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings are isomorphic if the characters in s can be replaced to get t. 
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself. 
//
// Example 1: 
//
// 
//Input: s = "egg", t = "add"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "foo", t = "bar"
//Output: false 
//
// Example 3: 
//
// 
//Input: s = "paper", t = "title"
//Output: true 
//
// Note: 
//You may assume both s and t have the same length. 
// Related Topics Hash Table


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m!=n) return false;
        HashMap<Character, Character> s2t = new HashMap<>();
        HashMap<Character, Character> t2s = new HashMap<>();
        for (int i=0; i<m; i++){
            if (!s2t.containsKey(s.charAt(i))) s2t.put(s.charAt(i), t.charAt(i));
            if (!t2s.containsKey(t.charAt(i))) t2s.put(t.charAt(i), s.charAt(i));
            if (s2t.get(s.charAt(i))!=t.charAt(i) || t2s.get(t.charAt(i))!=s.charAt(i)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
