//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place. 
//
// Example 1: 
//
// 
//Input: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//Output: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// Example 2: 
//
// 
//Input: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//Output: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
//
// Follow up: 
//
// 
// A straight forward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
// Related Topics Array


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m==0) return;
        int n = matrix[0].length;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (rows.contains(i) || cols.contains(j)) matrix[i][j]=0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
