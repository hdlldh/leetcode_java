//Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
// 
// 
// 
// Related Topics Sort Ordered Map


import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<=0 || t<0 || nums.length<=1) return false;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        for (int i=1; i<nums.length; i++){
            int num = nums[i];
            if (set.floor(num)!=null && num <= set.floor(num)+t || set.ceiling(num)!=null && num >= set.ceiling(num)-t){
                return true;
            }
            if (set.size()>=k) set.remove(nums[i-k]);
            set.add(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
