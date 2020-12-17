//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
// Related Topics Array Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int[] max_prod = new int[n];
        int[] min_prod = new int[n];
        max_prod[0] = nums[0];
        min_prod[0] = nums[0];
        for (int i=1; i<n; i++){
            if (nums[i]>=0){
                max_prod[i] = Math.max(max_prod[i-1]*nums[i], nums[i]);
                min_prod[i] = Math.min(min_prod[i-1]*nums[i], nums[i]);
            }
            else{
                max_prod[i] = Math.max(min_prod[i-1]*nums[i], nums[i]);
                min_prod[i] = Math.min(max_prod[i-1]*nums[i], nums[i]);
            }
            ans = Math.max(ans, max_prod[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
