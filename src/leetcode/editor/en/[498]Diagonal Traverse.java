//Given a matrix of M x N elements (M rows, N columns), return all elements of t
//he matrix in diagonal order as shown in the below image. 
//
// 
//
// Example: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//Output:  [1,2,4,7,5,3,6,8,9]
//
//Explanation:
//
// 
//
// 
//
// Note: 
//
// The total number of elements of the given matrix will not exceed 10,000. 
//



import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m=matrix.length;
        if (m==0) return new int[0];
        int n= matrix[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int dir = 1;
        for (int k=0; k<n; k++){
            ArrayList<Integer> t = new ArrayList<>();
            int i = 0;
            int j = k;
            while (i>=0 && i<m && j>=0 && j<n){
                t.add(matrix[i][j]);
                i++;
                j--;
            }
            if (dir==1) Collections.reverse(t);
            ans.addAll(t);
            dir = -dir;
        }
        for (int k=1; k<m; k++){
            ArrayList<Integer> t = new ArrayList<>();
            int i = k;
            int j = n-1;
            while (i>=0 && i<m && j>=0 && j<n) {
                t.add(matrix[i][j]);
                i++;
                j--;
            }
            if (dir==1) Collections.reverse(t);
            ans.addAll(t);
            dir = -dir;
        }
        int[] ans1 = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) ans1[i] = ans.get(i);
        return ans1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
