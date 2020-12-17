//Given a list of phrases, generate a list of Before and After puzzles. 
//
// A phrase is a string that consists of lowercase English letters and spaces only. No space appears in the start or the end of a phrase. There are no consecutive spaces in a phrase. 
//
// Before and After puzzles are phrases that are formed by merging two phrases where the last word of the first phrase is the same as the first word of the second phrase. 
//
// Return the Before and After puzzles that can be formed by every two phrases phrases[i] and phrases[j] where i != j. Note that the order of matching two phrases matters, we want to consider both orders. 
//
// You should return a list of distinct strings sorted lexicographically. 
//
// 
// Example 1: 
//
// 
//Input: phrases = ["writing code","code rocks"]
//Output: ["writing code rocks"]
// 
//
// Example 2: 
//
// 
//Input: phrases = ["mission statement",
//                  "a quick bite to eat",
//                  "a chip off the old block",
//                  "chocolate bar",
//                  "mission impossible",
//                  "a man on a mission",
//                  "block party",
//                  "eat my words",
//                  "bar of soap"]
//Output: ["a chip off the old block party",
//         "a man on a mission impossible",
//         "a man on a mission statement",
//         "a quick bite to eat my words",
//         "chocolate bar of soap"]
// 
//
// Example 3: 
//
// 
//Input: phrases = ["a","b","a"]
//Output: ["a"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= phrases.length <= 100 
// 1 <= phrases[i].length <= 100 
// 
// Related Topics String


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        HashMap<String, HashSet<String>> heads = new HashMap<>();
        HashMap<String, HashSet<String>> tails = new HashMap<>();
        TreeSet<String> ans = new TreeSet<>();
        for (int i=0; i<phrases.length; i++){
            String[] words = phrases[i].split(" ");
            String head = words[0];
            String tail = words[words.length-1];
            if (heads.containsKey(tail)){
                for (String a: heads.get(tail)){
                    ans.add(phrases[i]+a);
                }
            }
            if (tails.containsKey(head)) {
                for (String a : tails.get(head)) {
                    ans.add(a + phrases[i].substring(head.length()));
                }
            }
            HashSet<String> t;
            t = heads.getOrDefault(head, new HashSet<>());
            t.add(phrases[i].substring(head.length()));
            heads.put(head, t);
            t = tails.getOrDefault(tail, new HashSet<>());
            t.add(phrases[i]);
            tails.put(tail, t);
        }
        List<String> ans1 = new ArrayList<>(ans);
        return ans1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
