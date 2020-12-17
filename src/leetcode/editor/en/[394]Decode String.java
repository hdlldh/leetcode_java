//Given an encoded string, return its decoded string. 
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer. 
//
// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc. 
//
// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4]. 
//
// Examples: 
//
// 
//s = "3[a]2[bc]", return "aaabcbc".
//s = "3[a2[c]]", return "accaccacc".
//s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
// 
//
// 
// Related Topics Stack Depth-first Search

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();
        str_stack.add("");
        int num = 0;
        for (Character ch: s.toCharArray()){
            if (ch>='0' && ch<='9') {
                num = num*10 + (ch-'0');
            }else if (ch=='['){
                num_stack.add(num);
                num = 0;
                str_stack.add("");
            }else if (ch==']'){
                String str = str_stack.pop();
                int cnt = num_stack.pop();
                String t = str_stack.pop();
                while (cnt>0) {
                    t += str;
                    cnt--;
                }
                str_stack.add(t);
            }else{
                String t = str_stack.pop();
                t += ch;
                str_stack.add(t);
            }
        }
        return str_stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
