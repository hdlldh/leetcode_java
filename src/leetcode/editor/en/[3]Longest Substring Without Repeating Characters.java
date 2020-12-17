//Given a string, find the length of the longest substring without repeating characters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
// 
// 
// 
// 
// Related Topics Hash Table Two Pointers String Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = -1;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch)>left) left = map.get(ch);
            ans = Math.max(ans, i-left);
            map.put(ch, i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
