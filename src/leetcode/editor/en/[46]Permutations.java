//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        List<List<Integer>>  ans = new ArrayList<>();
        dfs(nums, new ArrayList<Integer>(), ans, visited);
        return ans;
    }
    private void dfs(int[] nums, List<Integer> sol, List<List<Integer>> ans, int[] visited){
        if (sol.size()==nums.length){
            ans.add(sol);
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i]==1) continue;
            visited[i] = 1;
            ArrayList<Integer> sol1 = new ArrayList<>(sol);
            sol1.add(nums[i]);
            dfs(nums, sol1, ans, visited);
            visited[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
