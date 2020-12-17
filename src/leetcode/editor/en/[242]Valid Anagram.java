//Given two strings s and t , write a function to determine if t is an anagram of s. 
//
// Example 1: 
//
// 
//Input: s = "anagram", t = "nagaram"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "rat", t = "car"
//Output: false
// 
//
// Note: 
//You may assume the string contains only lowercase alphabets. 
//
// Follow up: 
//What if the inputs contain unicode characters? How would you adapt your solution to such case? 
// Related Topics Hash Table Sort


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m!=n) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0; i<m; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        }
        for (int cnt: map.values()){
            if (cnt!=0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
