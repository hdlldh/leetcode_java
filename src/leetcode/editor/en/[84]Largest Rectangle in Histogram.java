//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] heights2 = new int[heights.length+1];
        for (int i=0; i<heights.length; i++) heights2[i] = heights[i];
        heights2[heights.length] = 0;
        int ans =0;
        for (int i=0; i<heights2.length; i++){
            while (!stack.isEmpty() && heights2[i]<=heights2[stack.peek()]){
                int cur = stack.pop();
                if (stack.isEmpty()) ans = Math.max(ans, i*heights2[cur]);
                else ans = Math.max(ans, (i-stack.peek()-1)*heights2[cur]);
            }
            stack.add(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
