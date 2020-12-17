//Write a function to find the longest common prefix string amongst an array of strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n==0) return "";
        if (n==1) return strs[0];
        for (int j=0; j<strs[0].length(); j++){
            for (int i=1; i<n; i++){
                if (j==strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)){
                    return strs[0].substring(0,j);
                }
            }
        }
        return strs[0];
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
