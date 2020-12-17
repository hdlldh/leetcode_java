//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string. 
//
// 
//
// Example 1: 
//
// 
//Input: s1 = "ab" s2 = "eidbaooo"
//Output: True
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input:s1= "ab" s2 = "eidboaoo"
//Output: False
// 
//
// 
//
// Note: 
//
// 
// The input strings only contain lower case letters. 
// The length of both given strings is in range [1, 10,000]. 
// 
// Related Topics Two Pointers Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m>n) return false;
        HashMap<Character, Integer> ref = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<m; i++){
            char ch = s1.charAt(i);
            ref.put(ch, ref.getOrDefault(ch, 0)+1);
            ch = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        if (map.equals(ref)) return true;
        for (int i=m; i<n; i++){
            char ch = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            ch = s2.charAt(i-m);
            int cnt = map.get(ch);
            if (cnt==1) map.remove(ch);
            else map.put(ch, cnt-1);
            if (map.equals(ref)) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
