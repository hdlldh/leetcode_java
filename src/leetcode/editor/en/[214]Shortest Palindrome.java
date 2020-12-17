//Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation. 
//
// Example 1: 
//
// 
//Input: "aacecaaa"
//Output: "aaacecaaa"
// 
//
// Example 2: 
//
// 
//Input: "abcd"
//Output: "dcbabcd" Related Topics String



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestPalindrome(String s) {
        String revS = new StringBuilder(s).reverse().toString();
        int n = s.length();
        for (int i=0; i<n; i++){
            if (s.substring(0,n-i).equals(revS.substring(i))) return revS.substring(0,i)+s;
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
