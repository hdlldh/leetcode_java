//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, k-1, 0, nums.length-1);
    }
    private int partition(int[] nums, int k, int start, int end) {
        if (start>=end) return nums[k];
        int left = start;
        int right = end;
        int pivot = nums[start+(end-start)/2];
        while (left <= right){
            while (left<=right && nums[left]> pivot) left++;
            while (left<=right && nums[right]<pivot) right--;
            if (left<=right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right--;
            }
        }
        if (k>=left) return partition(nums, k, left, end);
        if (k<=right) return partition(nums, k, start, right);
        return nums[k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
