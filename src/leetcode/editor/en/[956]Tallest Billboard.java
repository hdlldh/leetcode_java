//You are installing a billboard and want it to have the largest height. The bil
//lboard will have two steel supports, one on each side. Each steel support must b
//e an equal height. 
//
// You have a collection of rods which can be welded together. For example, if y
//ou have rods of lengths 1, 2, and 3, you can weld them together to make a suppor
//t of length 6. 
//
// Return the largest possible height of your billboard installation. If you can
//not support the billboard, return 0. 
//
// 
//
// Example 1: 
//
// 
//Input: [1,2,3,6]
//Output: 6
//Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same
// sum = 6.
// 
//
// 
// Example 2: 
//
// 
//Input: [1,2,3,4,5,6]
//Output: 10
//Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the sa
//me sum = 10.
// 
// 
//
// 
// Example 3: 
//
// 
//Input: [1,2]
//Output: 0
//Explanation: The billboard cannot be supported, so we return 0.
// 
// 
//
// 
//
// Note: 
//
// 
// 0 <= rods.length <= 20 
// 1 <= rods[i] <= 1000 
// The sum of rods is at most 5000. 
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tallestBillboard(int[] rods) {
        int s = 0;
        for (int h: rods) s+=h;
        int[] dp = new int[s+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int h: rods){
            int[] tmp = dp.clone();
            for (int i=0; i<=s; i++){
                if (tmp[i]<0) continue;
                if (i+h<=s) dp[i+h] =  Math.max(dp[i+h], tmp[i]);
                if (i>=h) dp[i-h] = Math.max(dp[i-h], tmp[i] + h);
                else dp[h-i] = Math.max(dp[h-i], tmp[i] + i);
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
