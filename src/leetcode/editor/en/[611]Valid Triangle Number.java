//Given an array consists of non-negative integers, your task is to count the nu
//mber of triplets chosen from the array that can make triangles if we take them a
//s side lengths of a triangle.
//
// Example 1: 
// 
//Input: [2,2,3,4]
//Output: 3
//Explanation:
//Valid combinations are: 
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
// 
// 
//
// Note: 
// 
// The length of the given array won't exceed 1000. 
// The integers in the given array are in the range of [0, 1000]. 
// 
// 
// Related Topics Array




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        if (n<3) return ans;
        Arrays.sort(nums);
        for (int a=0; a<n-2; a++){
            if (nums[a]==0) continue;
            int c = a+2;
            for (int b = a+1; b<n-1; b++){
                while (c<n && nums[c]-nums[b]<nums[a]) c++;
                ans += c-b-1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
