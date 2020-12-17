//Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character. 
//
// 
// Example 1: 
//
// 
//Input: S = "ab#c", T = "ad#c"
//Output: true
//Explanation: Both S and T become "ac".
// 
//
// 
// Example 2: 
//
// 
//Input: S = "ab##", T = "c#d#"
//Output: true
//Explanation: Both S and T become "".
// 
//
// 
// Example 3: 
//
// 
//Input: S = "a##c", T = "#a#c"
//Output: true
//Explanation: Both S and T become "c".
// 
//
// 
// Example 4: 
//
// 
//Input: S = "a#c", T = "b"
//Output: false
//Explanation: S becomes "c" while T becomes "b".
// 
//
// Note: 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S and T only contain lowercase letters and '#' characters. 
// 
//
// Follow up: 
//
// 
// Can you solve it in O(N) time and O(1) space? 
// 
// 
// 
// 
// 
// Related Topics Two Pointers Stack



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public boolean backspaceCompare(String S, String T) {
        String s = backspace(S);
        String t = backspace(T);
        return s.equals(t);
        
    }

    private String backspace(String S){
        ArrayList<Character> ans = new ArrayList<>();
        for (char ch: S.toCharArray()){
            if (ch!='#'){
                ans.add(ch);
            }
            else if (ans.size() > 0){
                ans.remove(ans.size()-1);
            }
        }
        StringBuilder rst = new StringBuilder();
        for (char ch: ans){
            rst.append(ch);
        }
        return rst.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
