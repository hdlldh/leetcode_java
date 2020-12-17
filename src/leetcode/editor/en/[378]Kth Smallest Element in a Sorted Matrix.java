//Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix. 
//
// 
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
// 
//
// Example:
// 
//matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//return 13.
// 
// 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ n2. Related Topics Binary Search Heap



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int low = matrix[0][0];
        int high = matrix[m-1][m-1];
        while (low<=high){
            int mid = low + (high-low)/2;
            int cnt = count(matrix, mid);
            if (cnt>=k) high = mid -1;
            else low = mid+1;
        }
        return low;
    }
    private int count(int[][] matrix, int target){
        int m = matrix.length;
        int row = 0;
        int col = m-1;
        int cnt = 0;
        while (row<m && col>=0){
            if (matrix[row][col]<=target){
                cnt += col+1;
                row++;
            }else{
                col--;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
