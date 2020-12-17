//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics Array Two Pointers



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (i<n){
            if (i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int j = i+1;
            int k = n-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==0){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    ans.add(t);
                    j++;
                    while (j<k && nums[j]==nums[j-1]) j++;
                }
                else if (sum>0) k--;
                else j++;
            }
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
