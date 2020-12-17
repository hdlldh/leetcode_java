//Given a list of non-negative numbers and a target integer k, write a function 
//to check if the array has a continuous subarray of size at least 2 that sums up 
//to a multiple of k, that is, sums up to n*k where n is also an integer. 
//
// 
//
// Example 1: 
//
// 
//Input: [23, 2, 4, 6, 7],  k=6
//Output: True
//Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 
//6.
// 
//
// Example 2: 
//
// 
//Input: [23, 2, 6, 4, 7],  k=6
//Output: True
//Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and 
//sums up to 42.
// 
//
// 
//
// Note: 
//
// 
// The length of the array won't exceed 10,000. 
// You may assume the sum of all the numbers is in the range of a signed 32-bit 
//integer. 
// 
// Related Topics Math Dynamic Programming




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k==0){
            int cnt = 0;
            for (int num: nums){
                if (num==0) {
                    cnt++;
                    if (cnt>=2) return true;
                }else cnt = 0;
            }
            return false;
        }
        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(0, -1);
        int psum = 0;
        for (int i=0; i<nums.length; i++){
            psum += nums[i];
            int r = psum % k;
            if (mem.containsKey(r) && i-mem.get(r)>=2) return true;
            if (!mem.containsKey(r)) mem.put(r, i);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
