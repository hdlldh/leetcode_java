//Given a string s, partition s such that every substring of the partition is a palindrome. 
//
// Return the minimum cuts needed for a palindrome partitioning of s. 
//
// Example: 
//
// 
//Input: "aab"
//Output: 1
//Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
// 
// Related Topics Dynamic Programming



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        boolean[][] mem = findPalindrome(s);
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0; i<s.length(); i++){
            if (mem[0][i]){
                dp[i] =1;
                continue;
            }
            for (int j=0; j<i; j++){
                if (mem[j+1][i]){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[s.length()-1]-1;
    }
    private boolean[][] findPalindrome(String s){
        boolean[][] ans = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) Arrays.fill(ans[i], false);
        for (int i=0; i<s.length(); i++){
            int left = i;
            int right = i;
            while (left>=0 && right<s.length()){
                if (s.charAt(left)==s.charAt(right)) ans[left][right]=true;
                else break;
                left--;
                right++;
            }
        }
        for (int i=1; i<s.length(); i++){
            int left = i-1;
            int right = i;
            while (left>=0 && right<s.length()){
                if (s.charAt(left)==s.charAt(right)) ans[left][right]=true;
                else break;
                left--;
                right++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
