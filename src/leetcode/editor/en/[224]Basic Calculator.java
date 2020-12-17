//Implement a basic calculator to evaluate a simple expression string. 
//
// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces . 
//
// Example 1: 
//
// 
//Input: "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: " 2-1 + 2 "
//Output: 3 
//
// Example 3: 
//
// 
//Input: "(1+(4+5+2)-3)+(6+8)"
//Output: 23 
//Note:
//
// 
// You may assume that the given expression is always valid. 
// Do not use the eval built-in library function. 
// 
// Related Topics Math Stack



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int num = 0;
        int sgn = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (char ch: s.toCharArray()){
            if (ch>='0' && ch<='9'){
                num = num*10+ ch -'0';
            }else if(ch=='+' || ch=='-'){
                res += sgn*num;
                num = 0;
                sgn = (ch=='+')?1:-1;
            }else if (ch=='('){
                stack.add(res);
                stack.add(sgn);
                res = 0;
                sgn = 1;
            }else if (ch==')'){
                res += sgn*num;
                num = 0;
                res = res * stack.pop();
                res = res + stack.pop();
            }
        }
        res += sgn*num;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
