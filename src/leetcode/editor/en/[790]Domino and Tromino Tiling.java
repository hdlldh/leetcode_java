//We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. Thes
//e shapes may be rotated. 
//
// 
//XX  <- domino
//
//XX  <- "L" tromino
//X
// 
//
// Given N, how many ways are there to tile a 2 x N board? Return your answer mo
//dulo 10^9 + 7. 
//
// (In a tiling, every square must be covered by a tile. Two tilings are differe
//nt if and only if there are two 4-directionally adjacent cells on the board such
// that exactly one of the tilings has both squares occupied by a tile.) 
//
//
// 
//Example:
//Input: 3
//Output: 5
//Explanation: 
//The five different ways are listed below, different letters indicates differen
//t tiles:
//XYZ XXZ XYY XXY XYY
//XYZ YYZ XZZ XYY XXY 
//
// Note: 
//
// 
// N will be in range [1, 1000]. 
// 
//
// 
// Related Topics Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTilings(int N) {
        if (N==1) return 1;
        int kmod = 1000000007;
        long[] dp0 = new long[N+1];
        long[] dp1 = new long[N+1];
        long[] dp2 = new long[N+1];
        dp0[0] = 1;
        dp0[1] = 1;
        for (int i=2; i<=N; i++){
            dp0[i] = (dp0[i-1] + dp1[i-1] + dp2[i-1]+ dp0[i-2]) % kmod;
            dp1[i] = (dp2[i-1]+ dp0[i-2]) % kmod;
            dp2[i] = (dp1[i-1]+ dp0[i-2]) % kmod;
        }
        return (int) dp0[N];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
