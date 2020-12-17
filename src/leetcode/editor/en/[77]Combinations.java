//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k,1, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(int n, int k, int start, List<Integer> out, List<List<Integer>> ans){
        if (out.size()==k){
            List<Integer> out1 = new ArrayList<>(out);
            ans.add(out1);
            return;
        }
        for (int i=start; i<=n; i++){
            out.add(i);
            dfs(n, k, i+1, out, ans);
            out.remove(out.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
