//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring. 
//
// Example 1: 
//
// 
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
// 
//
// Example 2: 
//
// 
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"
// 
// Related Topics String Dynamic Programming


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ans = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(') stack.add(i);
            else{
                stack.pop();
                if (!stack.isEmpty()){
                    ans = Math.max(ans, i-stack.peek());
                }else stack.add(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
