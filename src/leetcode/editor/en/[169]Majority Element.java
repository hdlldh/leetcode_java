//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always exist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;
        for (int num: nums){
            if (count==0){
                ans = num;
                count++;
            }else{
                if (num==ans) count++;
                else count--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
