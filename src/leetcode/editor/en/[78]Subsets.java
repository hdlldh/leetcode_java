//Given a set of distinct integers, nums, return all possible subsets (the power set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    private void dfs(int[] nums, int start, List<Integer> out, List<List<Integer>> ans){
        if (start==nums.length){
            ans.add(new ArrayList<Integer>(out));
            return;
        }
        out.add(nums[start]);
        dfs(nums, start+1, out, ans);
        out.remove(out.size()-1);
        dfs(nums, start+1, out, ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
