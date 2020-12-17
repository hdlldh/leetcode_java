//Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k. 
//
// Example: 
//
// 
//Input: matrix = [[1,0,1],[0,-2,3]], k = 2
//Output: 2 
//Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
//             and 2 is the max number no larger than k (k = 2). 
//
// Note: 
//
// 
// The rectangle inside the matrix must have an area > 0. 
// What if the number of rows is much larger than the number of columns? 
// Related Topics Binary Search Dynamic Programming Queue

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowLarger= (m>n)? true:false;
        int ans = Integer.MIN_VALUE;
        if (rowLarger){
            int t = m;
            m = n;
            n = t;
        }
        for (int i=0; i<m; i++){
            int[] arr = new int[n];
            Arrays.fill(arr, 0);
            for (int j = i; j>=0; j--){
                for (int l=0; l<n; l++){
                    if (rowLarger) arr[l] += matrix[l][j];
                    else arr[l] += matrix[j][l];
                }
                ans = Math.max(ans, maxSumSubarray(arr, k));
            }
        }
        return ans;
    }
    private int maxSumSubarray(int[] array, int k){
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int sum = 0;
        for (int num: array){
            sum += num;
            if (set.ceiling(sum-k)!=null) ans = Math.max(ans, sum-set.ceiling(sum-k));
            set.add(sum);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
