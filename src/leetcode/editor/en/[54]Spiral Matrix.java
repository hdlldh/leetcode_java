//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m==0) return new ArrayList<>();
        int n = matrix[0].length;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;
        List<Integer> ans = new ArrayList<>();
        while (true){
            for (int j=left; j<=right; j++) ans.add(matrix[top][j]);
            top++;
            if (top>bottom) break;
            for (int i=top; i<=bottom; i++) ans.add(matrix[i][right]);
            right--;
            if (left>right) break;
            for (int j=right; j>=left; j--) ans.add(matrix[bottom][j]);
            bottom--;
            if (top>bottom) break;
            for (int i=bottom; i>=top; i--) ans.add(matrix[i][left]);
            left++;
            if (left>right) break;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
