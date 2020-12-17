//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. 
//
// Example: 
// 
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
// 
// 
//
// Note: 
// 
// You may assume that the array does not change. 
// There are many calls to sumRange function. 
// 
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] data;
    public NumArray(int[] nums) {
        data = new int[nums.length+1];
        data[0]=0;
        for (int i=0; i<nums.length; i++){
            data[i+1] = data[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return data[j+1]-data[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)
