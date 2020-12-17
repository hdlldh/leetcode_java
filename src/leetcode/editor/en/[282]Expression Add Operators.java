//Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value. 
//
// Example 1: 
//
// 
//Input: num = "123", target = 6
//Output: ["1+2+3", "1*2*3"] 
// 
//
// Example 2: 
//
// 
//Input: num = "232", target = 8
//Output: ["2*3+2", "2+3*2"] 
//
// Example 3: 
//
// 
//Input: num = "105", target = 5
//Output: ["1*0+5","10-5"] 
//
// Example 4: 
//
// 
//Input: num = "00", target = 0
//Output: ["0+0", "0-0", "0*0"]
// 
//
// Example 5: 
//
// 
//Input: num = "3456237490", target = 9191
//Output: []
// 
// Related Topics Divide and Conquer



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", ans);
        return ans;
    }
    private void dfs(String num, int target, int start, long prev, long cur, String out, List<String> ans){
        if (start>=num.length()){
            if (cur==target) ans.add(out);
            return;
        }
        for (int i=start+1; i<=num.length(); i++){
            String curStr = num.substring(start, i);
            if (curStr.length()>1 && curStr.charAt(0)=='0') return;
            long curNum = Long.valueOf(curStr);
            if (out.isEmpty()) dfs(num, target, i, curNum, curNum, out+curStr, ans);
            else{
                dfs(num, target, i, curNum, cur + curNum, out+"+"+curStr, ans);
                dfs(num, target, i, -curNum, cur - curNum, out+"-"+curStr, ans);
                dfs(num, target, i, prev*curNum, cur -prev+prev*curNum, out+"*"+curStr, ans);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
