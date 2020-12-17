//Given an array, rotate the array to the right by k steps, where k is non-negative. 
//
// Example 1: 
//
// 
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: [-1,-100,3,99] and k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// Note: 
//
// 
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0,n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
        
    }
    private void reverse(int[] nums, int start, int end){
        int left = start;
        int right = end;
        while (left<right){
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
