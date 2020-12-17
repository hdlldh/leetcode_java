//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of times. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    private void dfs(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> ans){
        if (target<0) return;
        if (target==0){
            ArrayList<Integer> out1 = new ArrayList<>(out);
            ans.add(out1);
            return;
        }
        for (int i=start; i<candidates.length; i++){
            if (candidates[i]>target) break;
            out.add(candidates[i]);
            dfs(candidates, target-candidates[i], i, out, ans);
            out.remove(out.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
