//Given an array of non-negative integers, you are initially positioned at the first index of the array. 
//
// Each element in the array represents your maximum jump length at that position. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics Array Greedy



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n==1) return 0;
        int cur = 0;
        int ans = 0;
        int last = 0;
        for (int i=0; i<n-1; i++){
            cur = Math.max(cur, i+nums[i]);
            if (i==last){
                last = cur;
                ans++;
                if (cur>=n-1) break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
