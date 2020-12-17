//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int left = -1;
        for (int i=n-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                left = i;
                break;
            }
        }
        if (left == -1){
            Arrays.sort(nums);
            return;
        }
        int right = n-1;
        for (int i=n-1; i>left; i--){
            if (nums[i] > nums[left]){
                right = i;
                break;
            }
        }
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
        left++;
        right = n-1;
        while (left<right){
            t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
