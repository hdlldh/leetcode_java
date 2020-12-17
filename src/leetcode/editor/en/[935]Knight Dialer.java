//A chess knight can move as indicated in the chess diagram below: 
//
// . 
//
// 
//
// This time, we place our chess knight on any numbered key of a phone pad (indi
//cated above), and the knight makes N-1 hops. Each hop must be from one key to an
//other numbered key. 
//
// Each time it lands on a key (including the initial placement of the knight), 
//it presses the number of that key, pressing N digits total. 
//
// How many distinct numbers can you dial in this manner? 
//
// Since the answer may be large, output the answer modulo 10^9 + 7. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: 1
//Output: 10
// 
//
// 
// Example 2: 
//
// 
//Input: 2
//Output: 20
// 
//
// 
// Example 3: 
//
// 
//Input: 3
//Output: 46
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 5000 
// 
// 
// 
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int knightDialer(int N) {
        int kmod = 1000000007;
        int[][] dp = new int[4][3];
        for (int i=0; i<4; i++) Arrays.fill(dp[i], 1);
        dp[3][0] = 0;
        dp[3][2] = 0;
        int[][] dirs = {{-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{-1,2},{1,-2},{1,2}};
        for (int n=0; n<N-1; n++){
            int[][] tmp = new int[4][3];
            for (int i=0; i<4; i++){
                for (int j=0; j<3; j++){
                    for (int k=0; k<8; k++){
                        int ti = i + dirs[k][0];
                        int tj = j + dirs[k][1];
                        if (ti<0 || ti>=4 || tj<0 || tj>=3) continue;
                        tmp[ti][tj] = (tmp[ti][tj] + dp[i][j]) % kmod;
                    }
                }
            }
            dp = tmp;
            dp[3][0] = 0;
            dp[3][2] = 0;
        }
        int ans = 0;
        for (int i=0; i<4; i++){
            for (int j=0; j<3; j++){
                ans = (ans + dp[i][j]) % kmod;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
