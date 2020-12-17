//
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans =  new ArrayList<>();
        dfs(n, 0, "", ans);
        return ans;
    }
    private void dfs(int n, int count, String out, List<String> ans){
        if (count<0 || count>n || out.length()>2*n) return;
        if (out.length()==2*n && count==0){
            ans.add(out);
            return;
        }
        dfs(n, count+1, out+"(", ans);
        dfs(n, count-1, out+")", ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
