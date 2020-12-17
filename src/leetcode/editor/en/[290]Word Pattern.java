//Given a pattern and a string str, find if str follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str. 
//
// Example 1: 
//
// 
//Input: pattern = "abba", str = "dog cat cat dog"
//Output: true 
//
// Example 2: 
//
// 
//Input:pattern = "abba", str = "dog cat cat fish"
//Output: false 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", str = "dog cat cat dog"
//Output: false 
//
// Example 4: 
//
// 
//Input: pattern = "abba", str = "dog dog dog dog"
//Output: false 
//
// Notes: 
//You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space. 
// Related Topics Hash Table


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern2(String pattern, String str) {
        String[] strList = str.split(" ");
        HashMap<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();
        if (pattern.length()!= strList.length) return false;
        for (int i=0; i<pattern.length();i++){
            if (!p2s.containsKey(pattern.charAt(i))) p2s.put(pattern.charAt(i), strList[i]);
            if (!s2p.containsKey(strList[i])) s2p.put(strList[i], pattern.charAt(i));
            if (!p2s.get(pattern.charAt(i)).equals(strList[i]) || s2p.get(strList[i])!=pattern.charAt(i)) return false;
        }
        return true;
    }

    public boolean wordPattern(String pattern, String str) {
        String[] strList = str.split(" ");
        HashMap<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();
        if (pattern.length()!= strList.length) return false;
        for (int i=0; i<pattern.length();i++){
            if (!p2s.containsKey(pattern.charAt(i)) && !s2p.containsKey(strList[i])){
                p2s.put(pattern.charAt(i), strList[i]);
                s2p.put(strList[i], pattern.charAt(i));
            }else if(p2s.containsKey(pattern.charAt(i)) && s2p.containsKey(strList[i])){
                if (!p2s.get(pattern.charAt(i)).equals(strList[i]) || s2p.get(strList[i])!=pattern.charAt(i)) return false;
            }else return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
