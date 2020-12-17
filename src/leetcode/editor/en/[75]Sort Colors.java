//Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue. 
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively. 
//
// Note: You are not suppose to use the library's sort function for this problem. 
//
// Example: 
//
// 
//Input: [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2] 
//
// Follow up: 
//
// 
// A rather straight forward solution is a two-pass algorithm using counting sort. 
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's. 
// Could you come up with a one-pass algorithm using only constant space? 
// 
// Related Topics Array Two Pointers Sort



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        partition(nums, 0, nums.length-1, 0, 2);
    }
    private void partition(int[] nums, int start, int end, int startColor, int endColor){
        if (start>=end) return;
        if (startColor>=endColor) return;
        int midColor = startColor + (endColor-startColor)/2;
        int left = start;
        int right = end;
        while (left<=right){
            while (left<=right && nums[left]<=midColor) left++;
            while (left<=right && nums[right]>midColor) right--;
            if (left<=right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right--;
            }
        }
        partition(nums, start, right, startColor, midColor);
        partition(nums, left, end, midColor+1, endColor);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
