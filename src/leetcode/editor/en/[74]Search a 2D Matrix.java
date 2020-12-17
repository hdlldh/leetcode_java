//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previous row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics Array Binary Search



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            int i = mid/n;
            int j = mid%n;
            if (matrix[i][j]==target) return true;
            else if (matrix[i][j]>target) high = mid -1;
            else low = mid+1;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
