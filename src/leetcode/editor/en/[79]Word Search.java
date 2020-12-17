//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
// Related Topics Array Backtracking



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m==0) return false;
        int n = board[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (board[i][j]!=word.charAt(0)) continue;
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int k){
        int m=board.length;
        int n = board[0].length;
        if (i<0 || i>=m || j<0 || j>=n) return false;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        if (board[i][j]==word.charAt(k)){
            if (k==word.length()-1) return true;
            char tmp = board[i][j];
            board[i][j] = '#';
            for (int d=0; d<4; d++){
                if (dfs(board, i+dx[d], j+dy[d], word, k+1)) return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
