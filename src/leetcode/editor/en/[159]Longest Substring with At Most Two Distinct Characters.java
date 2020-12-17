//Given a string s , find the length of the longest substring t that contains at
// most 2 distinct characters. 
//
// Example 1: 
//
// 
//Input: "eceba"
//Output: 3
//Explanation: t is "ece" which its length is 3.
// 
//
// Example 2: 
//
// 
//Input: "ccaabbb"
//Output: 5
//Explanation: t is "aabbb" which its length is 5.
// 
// Related Topics Hash Table Two Pointers String Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int j = 0;
        int ans = 0;
        for (int i=0; i<s.length(); i++){
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0)+1);
            while (hmap.size()>2){
                hmap.put(s.charAt(j), hmap.get(s.charAt(j))-1);
                if (hmap.get(s.charAt(j))==0) hmap.remove(s.charAt(j));
                j++;
            }
            ans = Math.max(ans, i-j+1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
