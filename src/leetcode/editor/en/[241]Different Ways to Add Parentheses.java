//Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *. 
//
// Example 1: 
//
// 
//Input: "2-1-1"
//Output: [0, 2]
//Explanation: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// Example 2: 
//
// 
//Input: "2*3-4*5"
//Output: [-34, -14, -10, -10, 10]
//Explanation: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// Related Topics Divide and Conquer

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, ArrayList<Integer>> mem = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length()==0) return new ArrayList<Integer>();
        if (mem.containsKey(input)) return mem.get(input);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=1; i<input.length(); i++){
            if (input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int ln: left){
                    for (int rn: right){
                        if (input.charAt(i)=='+') ans.add(ln + rn);
                        else if (input.charAt(i)=='-') ans.add(ln - rn);
                        else ans.add(ln*rn);
                    }
                }
            }
        }
        if (ans.size()==0) ans.add(Integer.parseInt(input));
        mem.put(input, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
