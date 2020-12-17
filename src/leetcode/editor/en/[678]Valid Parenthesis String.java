//
//Given a string containing only three types of characters: '(', ')' and '*', wr
//ite a function to check whether this string is valid. We define the validity of 
//a string by these rules:
// 
// Any left parenthesis '(' must have a corresponding right parenthesis ')'. 
// Any right parenthesis ')' must have a corresponding left parenthesis '('. 
// Left parenthesis '(' must go before the corresponding right parenthesis ')'. 
//
// '*' could be treated as a single right parenthesis ')' or a single left paren
//thesis '(' or an empty string. 
// An empty string is also valid. 
// 
// 
//
// Example 1: 
// 
//Input: "()"
//Output: True
// 
// 
//
// Example 2: 
// 
//Input: "(*)"
//Output: True
// 
// 
//
// Example 3: 
// 
//Input: "(*))"
//Output: True
// 
// 
//
// Note: 
// 
// The string size will be in the range [1, 100]. 
// 
// Related Topics String




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int b=0;
        for (int i=0; i<n; i++){
            if (s.charAt(i)!=')') b++;
            else b--;
            if (b<0) return false;
        }
        b=0;
        for (int i=n-1; i>=0; i--){
            if (s.charAt(i)!='(') b++;
            else b--;
            if (b<0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
