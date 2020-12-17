//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region. 
//
// Example: 
//
// 
//X X X X
//X O O X
//X X O X
//X O X X
// 
//
// After running your function, the board should be: 
//
// 
//X X X X
//X X X X
//X X X X
//X O X X
// 
//
// Explanation: 
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically. 
// Related Topics Depth-first Search Breadth-first Search Union Find



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m==0) return;
        int n = board[0].length;
        for (int i=0; i<m; i++){
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for (int j=0; j<n; j++){
            dfs(board,0,j);
            dfs(board, m-1, j);
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]=='D') board[i][j]='O';
                else if (board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        if (i<0 || i>=m || j<0 || j>=n || board[i][j]!='O') return;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        board[i][j] = 'D';
        for (int k=0; k<4; k++) dfs(board, i+dx[k], j+dy[k]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
