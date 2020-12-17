//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid. 
// 
//
// Empty cells are indicated by the character '.'. 
//
// 
//A sudoku puzzle... 
//
// 
//...and its solution numbers marked in red. 
//
// Note: 
//
// 
// The given board contain only digits 1-9 and the character '.'. 
// You may assume that the given Sudoku puzzle will have a single unique solution. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table Backtracking


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, HashSet<Character>> rows;
    HashMap<Integer, HashSet<Character>> cols;
    HashMap<Integer, HashSet<Character>> grids;
    public void solveSudoku(char[][] board) {
        rows = new HashMap<>();
        cols = new HashMap<>();
        grids = new HashMap<>();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j]!='.'){
                    HashSet<Character> t;
                    t = rows.getOrDefault(i, new HashSet<>());
                    t.add(board[i][j]);
                    rows.put(i,t);
                    t = cols.getOrDefault(j, new HashSet<>());
                    t.add(board[i][j]);
                    cols.put(j,t);
                    t = grids.getOrDefault(i/3*3+j/3, new HashSet<>());
                    t.add(board[i][j]);
                    grids.put(i/3*3+j/3,t);
                }
            }
        }
        dfs(board, 0, 0);
    }
    private boolean isValid(char num, int i, int j){
        HashSet<Character> t;
        t = rows.getOrDefault(i, new HashSet<>());
        if (t.contains(num)) return false;
        t = cols.getOrDefault(j, new HashSet<>());
        if (t.contains(num)) return false;
        t = grids.getOrDefault(i/3*3+j/3, new HashSet<>());
        if (t.contains(num)) return false;
        return true;
    }
    private boolean dfs(char[][] board, int i, int j){
        if (i==9) return true;
        if (j==9) return dfs(board,i+1,0);
        if (board[i][j]=='.'){
            for (int n=1; n<10; n++) {
                char tmp = (char) ('0' + n);
                if (isValid(tmp, i, j)) {
                    board[i][j] = tmp;
                    HashSet<Character> t;
                    t = rows.getOrDefault(i, new HashSet<>());
                    t.add(tmp);
                    rows.put(i, t);
                    t = cols.getOrDefault(j, new HashSet<>());
                    t.add(tmp);
                    cols.put(j, t);
                    t = grids.getOrDefault(i / 3 * 3 + j / 3, new HashSet<>());
                    t.add(tmp);
                    grids.put(i / 3 * 3 + j / 3, t);
                    if (dfs(board, i, j + 1)) return true;
                    board[i][j] ='.';
                    t = rows.get(i);
                    t.remove(tmp);
                    rows.put(i, t);
                    t = cols.get(j);
                    t.remove(tmp);
                    cols.put(j, t);
                    t = grids.get(i / 3 * 3 + j / 3);
                    t.remove(tmp);
                    grids.put(i / 3 * 3 + j / 3, t);
                }
            }
            return false;
        }else{
            return dfs(board, i, j+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
