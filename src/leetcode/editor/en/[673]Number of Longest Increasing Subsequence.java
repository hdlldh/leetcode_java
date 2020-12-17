//
//Given an unsorted array of integers, find the number of longest increasing subsequence.
// 
//
// Example 1: 
// 
//Input: [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
// 
// 
//
// Example 2: 
// 
//Input: [2,2,2,2,2]
//Output: 5
//Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
// 
// 
//
// Note:
//Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        int[] len = new int[n];
        Arrays.fill(len, 1);
        int maxLen = 1;
        int ans = 0;
        for (int i=1; i<n; i++){
            for (int j=0; j<i; j++){
                if (nums[i]<=nums[j]) continue;
                if (len[i] == len[j]+1) cnt[i] += cnt[j];
                else if (len[i]< len[j]+1){
                    cnt[i] = cnt[j];
                    len[i] = len[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        for (int i=0; i<n; i++){
            if (len[i]==maxLen) ans+=cnt[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
