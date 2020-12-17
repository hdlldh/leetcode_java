//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target. 
//
// Note: 
//
// The solution set must not contain duplicate quadruplets. 
//
// Example: 
//
// 
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics Array Hash Table Two Pointers



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i<n){
            if (i>0 && nums[i]==nums[i-1]){
                i++;
                continue;
            }
            int j = i+1;
            while (j<n){
                if (j>i+1 && nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                int k = j+1;
                int l = n-1;
                while (k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum==target){
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        ans.add(t);
                        k++;
                        while (k<l && nums[k]==nums[k-1]) k++;
                    }
                    else if (sum>target) l--;
                    else k++;
                }
                j++;
            }
            i++;
        }
        return ans;

        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
