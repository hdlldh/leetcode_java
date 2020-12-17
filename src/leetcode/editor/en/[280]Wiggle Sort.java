//Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3].... 
//
// Example: 
//
// 
//Input: nums = [3,5,2,1,6,4]
//Output: One possible answer is [3,5,1,6,2,4] 
// Related Topics Array Sort



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (n<=2) return;
        int i = 1;
        int j = 2;
        while (j<n){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i+=2;
            j+=2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
