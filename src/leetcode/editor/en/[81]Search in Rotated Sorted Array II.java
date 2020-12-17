//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
//
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]). 
//
// You are given a target value to search. If found in the array return true, otherwise return false. 
//
// Example 1: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false 
//
// Follow up: 
//
// 
// This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates. 
// Would this affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n==0) return false;
        int loc = findMin(nums);
        if (target<= nums[n-1]) return biSearch(nums, loc, n-1, target);
        else return biSearch(nums, 0, loc-1, target);
        
    }

    private int findMin(int[] nums){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while (low<high && nums[low]==nums[high]) low++;
        while (low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]<=nums[n-1]) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private boolean biSearch(int[] nums, int start, int end, int target){
        int low = start;
        int high = end;
        while (low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]>target) high = mid-1;
            else if (nums[mid]<target) low = mid + 1;
            else return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
