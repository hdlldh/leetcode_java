//Given a sorted array A of unique numbers, find the K-th missing number startin
//g from the leftmost number of the array. 
//
// 
//
// Example 1: 
//
// 
//Input: A = [4,7,9,10], K = 1
//Output: 5
//Explanation: 
//The first missing number is 5.
// 
//
// Example 2: 
//
// 
//Input: A = [4,7,9,10], K = 3
//Output: 8
//Explanation: 
//The missing numbers are [5,6,8,...], hence the third missing number is 8.
// 
//
// Example 3: 
//
// 
//Input: A = [1,2,4], K = 3
//Output: 6
//Explanation: 
//The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length <= 50000 
// 1 <= A[i] <= 1e7 
// 1 <= K <= 1e8 
// Related Topics Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if (missing(nums, mid)>=k) high = mid -1;
            else low = mid+1;
        }
        return nums[high] + k - missing(nums, high);
    }
    private int missing(int[] nums, int idx){
        return nums[idx]-nums[0]-idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
