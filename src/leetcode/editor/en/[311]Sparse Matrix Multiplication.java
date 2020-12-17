//Given two sparse matrices A and B, return the result of AB. 
//
// You may assume that A's column number is equal to B's row number. 
//
// Example: 
//
// 
//Input:
//
//A = [
//  [ 1, 0, 0],
//  [-1, 0, 3]
//]
//
//B = [
//  [ 7, 0, 0 ],
//  [ 0, 0, 0 ],
//  [ 0, 0, 1 ]
//]
//
//Output:
//
//     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                  | 0 0 1 |
// 
// Related Topics Hash Table


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int k = A[0].length;
        int n = B[0].length;
        int[][] ans = new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(ans[i], 0);
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                for (int l=0; l<k; l++){
                    if (A[i][l]!=0 && B[l][j]!=0) ans[i][j] += A[i][l]*B[l][j];
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
