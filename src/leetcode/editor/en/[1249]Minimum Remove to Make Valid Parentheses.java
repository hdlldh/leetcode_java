//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any
// positions ) so that the resulting parentheses string is valid and return any va
//lid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid stri
//ngs, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// Example 4: 
//
// 
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// s[i] is one of '(' , ')' and lowercase English letters. 
// Related Topics String Stack


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> toRemove = new HashSet<>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='(') stack.push(i);
            else if(s.charAt(i)==')'){
                if (!stack.isEmpty()) stack.pop();
                else toRemove.add(i);
            }
        }
        while (!stack.isEmpty()) toRemove.add(stack.pop());
        StringBuilder ans = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (toRemove.contains(i)) continue;
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
