//Shuffle a set of numbers without duplicates.
// 
//
// Example:
// 
//// Init an array with set 1, 2, and 3.
//int[] nums = {1,2,3};
//Solution solution = new Solution(nums);
//
//// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
//solution.shuffle();
//
//// Resets the array back to its original configuration [1,2,3].
//solution.reset();
//
//// Returns the random shuffling of array [1,2,3].
//solution.shuffle();
// 
//


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums;
    int size;
    Random r;
    public Solution(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = new int[this.size];
        for (int i=0; i<size; i++) ans[i] = nums[i];
        for (int i=size-1; i>=1; i--){
            int j = r.nextInt(i+1);
            if (i!=j){
                int t = ans[i];
                ans[i] = ans[j];
                ans[j] = t;
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)
