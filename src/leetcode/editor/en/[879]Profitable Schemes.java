//There are G people in a gang, and a list of various crimes they could commit. 
//
//
// The i-th crime generates a profit[i] and requires group[i] gang members to pa
//rticipate. 
//
// If a gang member participates in one crime, that member can't participate in 
//another crime. 
//
// Let's call a profitable scheme any subset of these crimes that generates at l
//east P profit, and the total number of gang members participating in that subset
// of crimes is at most G. 
//
// How many schemes can be chosen? Since the answer may be very large, return it
// modulo 10^9 + 7. 
//
// 
//
// Example 1: 
//
// 
//Input: G = 5, P = 3, group = [2,2], profit = [2,3]
//Output: 2
//Explanation: 
//To make a profit of at least 3, the gang could either commit crimes 0 and 1, o
//r just crime 1.
//In total, there are 2 schemes.
// 
//
// 
// Example 2: 
//
// 
//Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
//Output: 7
//Explanation: 
//To make a profit of at least 5, the gang could commit any crimes, as long as t
//hey commit one.
//There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
//
// 
//
// 
// 
//
// Note: 
//
// 
// 1 <= G <= 100 
// 0 <= P <= 100 
// 1 <= group[i] <= 100 
// 0 <= profit[i] <= 100 
// 1 <= group.length = profit.length <= 100 
// 
//
// 
// 
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int K = group.length;
        int kmod = 1000000007;
        int[][][] dp = new int[K+1][P+1][G+1];
        dp[0][0][0] = 1;
        int ans = 0;
        for (int k=1; k<=K; k++){
            int g = group[k-1];
            int p = profit[k-1];
            for (int i=0; i<=P; i++){
                for (int j=0; j<=G; j++){
                    dp[k][i][j] = dp[k-1][i][j];
                    if (g<=j){
                        dp[k][i][j] = (dp[k][i][j] + dp[k-1][Math.max(0, i-p)][j-g]) % kmod;
                    }
                    if (k==K && i==P) ans = (ans + dp[K][P][j]) %kmod;
                }

            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
