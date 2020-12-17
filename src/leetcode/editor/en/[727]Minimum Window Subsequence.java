//Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W. 
//
// If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index. 
//
// Example 1: 
//
// 
//Input: 
//S = "abcdebdde", T = "bde"
//Output: "bcde"
//Explanation: 
//"bcde" is the answer because it occurs before "bdde" which has the same length.
//"deb" is not a smaller window because the elements of T in the window must occur in order.
// 
//
// 
//
// Note: 
//
// 
// All the strings in the input will only contain lowercase letters. 
// The length of S will be in the range [1, 20000]. 
// The length of T will be in the range [1, 100]. 
// 
//
// Related Topics Dynamic Programming Sliding Window



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String S, String T) {
        int m = S.length();
        int n = T.length();
        String ans = "";
        if (m<n) return ans;
        int size = Integer.MAX_VALUE;
        int[][] f= new int[n+1][m+1];
        for (int i = 0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (j==0) f[j][i] = i;
                else if(i==0) f[j][i] = -1;
                else f[j][i]=(S.charAt(i-1)==T.charAt(j-1))?f[j-1][i-1]:f[j][i-1];
                }
            if (f[n][i]!=-1 && i-f[n][i]<size){
                size = i-f[n][i];
                ans = S.substring(f[n][i],i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
