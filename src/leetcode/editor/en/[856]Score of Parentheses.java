//Given a balanced parentheses string S, compute the score of the string based o
//n the following rule: 
//
// 
// () has score 1 
// AB has score A + B, where A and B are balanced parentheses strings. 
// (A) has score 2 * A, where A is a balanced parentheses string. 
// 
//
// 
//
// 
// Example 1: 
//
// 
//Input: "()"
//Output: 1
// 
//
// 
// Example 2: 
//
// 
//Input: "(())"
//Output: 2
// 
//
// 
// Example 3: 
//
// 
//Input: "()()"
//Output: 2
// 
//
// 
// Example 4: 
//
// 
//Input: "(()(()))"
//Output: 6
// 
//
// 
//
// Note: 
//
// 
// S is a balanced parentheses string, containing only ( and ). 
// 2 <= S.length <= 50 
// 
// 
// 
// 
// 
// Related Topics String Stack




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfParentheses(String S) {
        int n = S.length();
        if (n==0) return 0;
        return scores(S, 0, S.length()-1);
    }
    private int scores(String S, int l, int r){
        if (r-l==1) return 1;
        int b= 0;
        for (int i=l; i<r; i++){
            if (S.charAt(i)=='(') b++;
            else b--;
            if (b==0) return scores(S, l, i) + scores(S, i+1, r);
        }
        return scores(S, l+1, r-1)*2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
