//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution. 
//
// Example: 
//
// 
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
// Related Topics Array Two Pointers



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int ans = Integer.MAX_VALUE;
        while (i<n){
            if (i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int j = i+1;
            int k = n-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==target) return target;
                else if (sum>target){
                    if (ans==Integer.MAX_VALUE || sum-target<Math.abs(ans-target)) ans = sum;
                    k--;
                }else{
                    if (ans==Integer.MAX_VALUE || target-sum<Math.abs(ans-target)) ans = sum;
                    j++;
                }
            }
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
