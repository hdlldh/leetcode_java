//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences. 
//
// Note: 
//
// 
// The same word in the dictionary may be reused multiple times in the segmentation. 
// You may assume the dictionary does not contain duplicate words. 
// 
//
// Example 1: 
//
// 
//Input:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//Output:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// Example 2: 
//
// 
//Input:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//Output:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//Explanation: Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output:
//[] 
// Related Topics Dynamic Programming Backtracking


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> mem = new HashMap<>();
        dfs(s, wordDict, mem);
        return mem.get(s);
    }
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> mem){
        if (mem.containsKey(s)) return mem.get(s);
        List<String> ans = new ArrayList<>();
        if (s.isEmpty()){
            ans.add("");
            return ans;
        }
        for (String word: wordDict){
            if (word.length()<=s.length() && word.equals(s.substring(0,word.length()))){
                List<String> rem = dfs(s.substring(word.length()), wordDict, mem);
                for (String r: rem){
                    if (r.isEmpty()) ans.add(word);
                    else ans.add(word+" "+r);
                }
            }
        }
        mem.put(s, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
