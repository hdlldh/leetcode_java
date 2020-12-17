//Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one. 
//
// Note: 
//
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
//
// Example 1: 
//
// 
//Input: [2,2,3,2]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [0,1,0,1,0,1,99]
//Output: 99 
// Related Topics Bit Manipulation



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int a =0;
        int b =0;
        for (int num: nums){
            int a1 = num & ~a & b | ~num & a & ~b;
            int b1 = num & ~a & ~b | ~num & ~a & b;
            a = a1;
            b = b1;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
