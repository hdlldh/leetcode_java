//On an NxN chessboard, a knight starts at the r-th row and c-th column and atte
//mpts to make exactly K moves. The rows and columns are 0 indexed, so the top-lef
//t square is (0, 0), and the bottom-right square is (N-1, N-1). 
//
// A chess knight has 8 possible moves it can make, as illustrated below. Each m
//ove is two squares in a cardinal direction, then one square in an orthogonal dir
//ection. 
//
// 
//
// 
//
// 
//
// Each time the knight is to move, it chooses one of eight possible moves unifo
//rmly at random (even if the piece would go off the chessboard) and moves there. 
//
//
// The knight continues moving until it has made exactly K moves or has moved of
//f the chessboard. Return the probability that the knight remains on the board af
//ter it has stopped moving. 
//
// 
//
// Example: 
//
// 
//Input: 3, 2, 0, 0
//Output: 0.0625
//Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight o
//n the board.
//From each of those positions, there are also two moves that will keep the knig
//ht on the board.
//The total probability the knight stays on the board is 0.0625.
// 
//
// 
//
// Note: 
//
// 
// N will be between 1 and 25. 
// K will be between 0 and 100. 
// The knight always initially starts on the board. 
// 
// Related Topics Dynamic Programming




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double [][] dp = new double[N][N];
        dp[r][c] = 1.0;
        int[][] dirs = {{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
        for (int k=0;k<K;k++){
            double[][] dp2 = new double[N][N];
            for (int i=0;i<N; i++){
                for (int j=0; j<N; j++){
                    for (int[] dir: dirs){
                        int ti = i+dir[0];
                        int tj = j+dir[1];
                        if (ti<0 || ti>=N || tj<0 || tj>=N) continue;
                        dp2[ti][tj] += dp[i][j];
                    }
                }
            }
            dp = dp2;
        }
        double count = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                count += dp[i][j];
            }
        }
        return count/Math.pow(8, K);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
