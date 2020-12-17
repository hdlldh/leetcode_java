//Given a string, find the length of the longest substring T that contains at most k distinct characters. 
//
// Example 1: 
//
// 
// 
//Input: s = "eceba", k = 2
//Output: 3
//Explanation: T is "ece" which its length is 3. 
//
// 
// Example 2: 
//
// 
//Input: s = "aa", k = 1
//Output: 2
//Explanation: T is "aa" which its length is 2.
// 
// 
// Related Topics Hash Table String Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j<n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            j++;
            while (map.size()>k){
                ch = s.charAt(i);
                int cnt = map.get(ch) - 1;
                if (cnt == 0) map.remove(ch);
                else map.put(ch, cnt);
                i++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
