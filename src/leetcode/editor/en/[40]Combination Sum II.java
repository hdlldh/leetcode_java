//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target. 
//
// Each number in candidates may only be used once in the combination. 
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
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        int[] visited = new int[candidates.length];
        Arrays.fill(visited, 0);
        dfs(candidates, target, 0, new ArrayList<Integer>(), ans, visited);
        return ans;
    }
    private void dfs(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> ans, int[] visited){
        if (target<0) return;
        if (target==0){
            ArrayList<Integer> out1 = new ArrayList<>(out);
            ans.add(out1);
            return;
        }
        for (int i=start; i<candidates.length; i++){
            if (visited[i]==1) continue;
            if (i==0 || candidates[i]!=candidates[i-1] || visited[i-1]==1){
                out.add(candidates[i]);
                visited[i] = 1;
                dfs(candidates, target-candidates[i], i, out, ans, visited);
                out.remove(out.size()-1);
                visited[i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
