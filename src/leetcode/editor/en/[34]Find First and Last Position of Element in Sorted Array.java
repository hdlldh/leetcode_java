//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
// Related Topics Array Binary Search



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]>=target) high = mid-1;
            else low = mid+1;
        }
        if (low<n && nums[low]==target) ans[0] = low;

        low = 0;
        high = n-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]>target) high = mid-1;
            else low = mid+1;
        }
        if (high>=0 && nums[high]==target) ans[1] = high;

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
