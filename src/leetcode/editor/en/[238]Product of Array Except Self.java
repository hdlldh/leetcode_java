//Given an array nums of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]. 
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];

        int i = 1;
        l2r[0] = 1;
        while (i<n){
            l2r[i] = l2r[i-1] * nums[i-1];
            i++;
        }

        i = n-2;
        r2l[n-1] = 1;
        while (i>=0){
            r2l[i] = r2l[i+1] * nums[i+1];
            i--;
        }

        for (i=0; i<n; i++){
            l2r[i] = l2r[i] * r2l[i];
        }

        return l2r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
