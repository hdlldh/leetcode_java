//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;
        int[][] ans = new int[n][n];
        while (true) {
            for (int j = left; j <= right; j++) ans[top][j] = num++;
            top++;
            if (top > bottom) break;
            for (int i = top; i <= bottom; i++) ans[i][right] = num++;
            right--;
            if (left > right) break;
            for (int j = right; j >= left; j--) ans[bottom][j] = num++;
            bottom--;
            if (top > bottom) break;
            for (int i = bottom; i >= top; i--) ans[i][left] = num++;
            left++;
            if (left > right) break;
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
