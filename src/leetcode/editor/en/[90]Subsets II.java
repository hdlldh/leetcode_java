//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: [1,2,2]
//Output:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
// 
// Related Topics Array Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        Arrays.fill(visited, 0);
        dfs(nums, 0, visited, new ArrayList<Integer>(), ans);
        return ans;
    }
    private void dfs(int[] nums, int start, int[] visited, List<Integer> out, List<List<Integer>> ans){
        if (start==nums.length){
            ans.add(new ArrayList<Integer>(out));
            return;
        }
        dfs(nums, start+1, visited, out, ans);
        if (start==0 || nums[start]!=nums[start-1] || visited[start-1]==1){
            out.add(nums[start]);
            visited[start]=1;
            dfs(nums, start+1, visited, out, ans);
            out.remove(out.size()-1);
            visited[start]=0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
