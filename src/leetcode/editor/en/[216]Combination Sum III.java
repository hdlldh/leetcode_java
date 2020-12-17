//
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers. 
//
// Note: 
//
// 
// All numbers will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
// 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics Array Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<Integer>(), ans);
        return ans;
    }
    private void dfs(int k, int n, int start, List<Integer> out, List<List<Integer>> ans){
        if (k==0){
            if (n==0){
                ArrayList<Integer> out1 = new ArrayList<>(out);
                ans.add(out1);
            }
            return;
        }
        for (int i=start; i<=9; i++){
            if (i>n) break;
            out.add(i);
            dfs(k-1, n-i, i+1, out, ans);
            out.remove(out.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
