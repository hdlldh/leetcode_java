//Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements ap
//pear twice and others appear once. 
//
// Find all the elements that appear twice in this array. 
//
// Could you do it without extra space and in O(n) runtime? 
// 
// Example: 
// 
//Input:
//[4,3,2,7,8,2,3,1]
//
//Output:
//[2,3]
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        while (i<n){
            if (nums[i] != nums[nums[i]-1]){
                int j = nums[i] - 1;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                continue;
            }
            i++;
        }
        for (i=0; i<nums.length; i++){
            if (nums[i]!=i+1) ans.add(nums[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
