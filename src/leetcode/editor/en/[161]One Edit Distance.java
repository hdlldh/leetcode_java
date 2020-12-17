//Given two strings s and t, determine if they are both one edit distance apart. 
//
// Note: 
//
// There are 3 possiblities to satisify one edit distance apart: 
//
// 
// Insert a character into s to get t 
// Delete a character from s to get t 
// Replace a character of s to get t 
// 
//
// Example 1: 
//
// 
//Input: s = "ab", t = "acb"
//Output: true
//Explanation: We can insert 'c' into s to get t.
// 
//
// Example 2: 
//
// 
//Input: s = "cab", t = "ad"
//Output: false
//Explanation: We cannot get t from s by only one step. 
//
// Example 3: 
//
// 
//Input: s = "1203", t = "1213"
//Output: true
//Explanation: We can replace '0' with '1' to get t. 
// Related Topics String



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m-n)>1) return false;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i<m && j<n){
            if (s.charAt(i)!=t.charAt(j)){
                count++;
                if (count>1) return false;
                if (m>n) i++;
                else if (m<n) j++;
                else{
                    i++;
                    j++;
                }
            }
            else{
                i++;
                j++;
            }
        }
        if (i<m || j<n){
            count++;
        }
        return count==1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
