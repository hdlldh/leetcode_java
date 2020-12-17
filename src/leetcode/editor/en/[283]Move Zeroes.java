//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
// Related Topics Array Two Pointers



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = -1;
        int j = 0;
        while (j<n){
            if (nums[j]!=0){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        i++;
        while (i<n){
            nums[i] = 0;
            i++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
