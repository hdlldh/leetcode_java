//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2. 
//
// Example 1: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//Output: false
// 
// Related Topics String Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n+m!=s3.length()) return false;
        boolean[][] dp = new boolean[n+1][m+1];
        for (int i=0; i<=n; i++){
            for (int j=0; j<=m; j++){
                if (i==0 && j==0) dp[i][j] = true;
                else if (i==0) dp[i][j] = dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
                else if (j==0) dp[i][j] = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1);
                else dp[i][j] = dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1) || dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1);
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
