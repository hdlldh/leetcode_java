//Given a collection of numbers that might contain duplicates, return all possible unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int[] visited = new int[n];
        Arrays.fill(visited, 0);
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), ans, visited);
        return ans;
    }
    private void dfs(int[] nums, List<Integer> sol, List<List<Integer>> ans, int[] visited){
        if (sol.size()==nums.length){
            ans.add(sol);
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (visited[i]==1) continue;
            if (i==0 || nums[i]!=nums[i-1] || visited[i-1]==1){
                visited[i] = 1;
                List<Integer> sol1 = new ArrayList<>(sol);
                sol1.add(nums[i]);
                dfs(nums, sol1, ans, visited);
                visited[i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
