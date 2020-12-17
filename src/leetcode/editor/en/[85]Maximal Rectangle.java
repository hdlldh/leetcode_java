//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area. 
//
// Example: 
//
// 
//Input:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//Output: 6
// 
// Related Topics Array Hash Table Dynamic Programming Stack


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n+1];
        int ans =0;
        Arrays.fill(heights, 0);
        for (int i=0;i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j]=='0') heights[j] =0;
                else heights[j]++;
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }
    private int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        for (int i=0; i<heights.length; i++){
            while (!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                int cur = stack.pop();
                if (stack.isEmpty()) ans = Math.max(ans, i*heights[cur]);
                else ans = Math.max(ans, (i-stack.peek()-1)*heights[cur]);
            }
            stack.add(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
