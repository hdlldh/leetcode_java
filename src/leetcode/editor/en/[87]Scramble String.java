//Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively. 
//
// Below is one possible representation of s1 = "great": 
//
// 
//    great
//   /    \
//  gr    eat
// / \    /  \
//g   r  e   at
//           / \
//          a   t
// 
//
// To scramble the string, we may choose any non-leaf node and swap its two children. 
//
// For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat". 
//
// 
//    rgeat
//   /    \
//  rg    eat
// / \    /  \
//r   g  e   at
//           / \
//          a   t
// 
//
// We say that "rgeat" is a scrambled string of "great". 
//
// Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae". 
//
// 
//    rgtae
//   /    \
//  rg    tae
// / \    /  \
//r   g  ta  e
//       / \
//      t   a
// 
//
// We say that "rgtae" is a scrambled string of "great". 
//
// Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. 
//
// Example 1: 
//
// 
//Input: s1 = "great", s2 = "rgeat"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s1 = "abcde", s2 = "caebd"
//Output: false 
// Related Topics String Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        char[] ss1 = s1.toCharArray();
        Arrays.sort(ss1);
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss2);
        if (!new String(ss1).equals(new String(ss2))) return false;
        int n = s1.length();
        String s11;
        String s12;
        String s21;
        String s22;
        for (int i = 1; i < n; i++) {
            s11 = s1.substring(0, i);
            s12 = s1.substring(i);
            s21 = s2.substring(0, i);
            s22 = s2.substring(i);
            if (isScramble(s11,s21) && isScramble(s12, s22)) return true;
            s21 = s2.substring(n - i);
            s22 = s2.substring(0,n - i);
            if (isScramble(s11,s21) && isScramble(s12, s22)) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
