//Let's play the minesweeper game (Wikipedia, online game)! 
//
// You are given a 2D char matrix representing the game board. 'M' represents an
// unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a re
//vealed blank square that has no adjacent (above, below, left, right, and all 4 d
//iagonals) mines, digit ('1' to '8') represents how many mines are adjacent to th
//is revealed square, and finally 'X' represents a revealed mine. 
//
// Now given the next click position (row and column indices) among all the unre
//vealed squares ('M' or 'E'), return the board after revealing this position acco
//rding to the following rules: 
//
// 
// If a mine ('M') is revealed, then the game is over - change it to 'X'. 
// If an empty square ('E') with no adjacent mines is revealed, then change it t
//o revealed blank ('B') and all of its adjacent unrevealed squares should be reve
//aled recursively. 
// If an empty square ('E') with at least one adjacent mine is revealed, then ch
//ange it to a digit ('1' to '8') representing the number of adjacent mines. 
// Return the board when no more squares will be revealed. 
// 
//
// 
//
// Example 1: 
//
// 
//Input: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//Output: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
// 
//
// Example 2: 
//
// 
//Input: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//Output: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Explanation:
//
// 
//
// 
//
// Note: 
//
// 
// The range of the input matrix's height and width is [1,50]. 
// The click position will only be an unrevealed square ('M' or 'E'), which also
// means the input board contains at least one clickable square. 
// The input board won't be a stage when game is over (some mines have been reve
//aled). 
// For simplicity, not mentioned rules should be ignored in this problem. For ex
//ample, you don't need to reveal all the unrevealed mines when the game is over, 
//consider any cases that you will win the game or flag any squares. 
// 
// Related Topics Depth-first Search Breadth-first Search




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m=board.length;
        int n=board[0].length;
        int x = click[0];
        int y = click[1];
        if (board[x][y]=='M') board[x][y] = 'X';
        else{
            int cnt = 0;
            for (int i=-1;i<=1;i++){
                for (int j=-1;j<=1;j++){
                    if (i==0 && j==0) continue;
                    int tx = x+i;
                    int ty = y+j;
                    if (tx<0 || tx>=m || ty<0 || ty>=n) continue;
                    if (board[tx][ty]=='M') cnt++;
                }
            }
            if (cnt>0) board[x][y] = (char) ('0'+cnt);
            else{
                board[x][y] = 'B';
                for (int i=-1;i<=1;i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        int tx = x + i;
                        int ty = y + j;
                        if (tx < 0 || tx >= m || ty < 0 || ty >= n) continue;
                        if (board[tx][ty] == 'E') updateBoard(board, new int[]{tx, ty});
                    }
                }
            }
        }
        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
