//Given several boxes with different colors represented by different positive nu
//mbers. 
//You may experience several rounds to remove boxes until there is no box left. 
//Each time you can choose some continuous boxes with the same color (composed of 
//k boxes, k >= 1), remove them and get k*k points. 
//Find the maximum points you can get.
// 
//
// Example 1: 
//Input: 
// 
//[1, 3, 2, 2, 2, 3, 4, 3, 1]
// 
//Output:
// 
//23
// 
//Explanation: 
// 
//[1, 3, 2, 2, 2, 3, 4, 3, 1] 
//----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
//----> [1, 3, 3, 3, 1] (1*1=1 points) 
//----> [1, 1] (3*3=9 points) 
//----> [] (2*2=4 points)
// 
// 
//
// Note:
//The number of boxes n would not exceed 100.
// 
// Related Topics Dynamic Programming Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][][] mem;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        mem = new int[n][n][n];
        return helper(boxes, 0, n-1, 0);
    }

    private int helper(int[] boxes, int l, int r, int k){
        if (l>r) return 0;
        if (mem[l][r][k]>0) return mem[l][r][k];
        mem[l][r][k] = helper(boxes, l, r-1, 0) + (k+1)*(k+1);
        for (int i=l; i<r; i++){
            if (boxes[i]==boxes[r]) {
                mem[l][r][k] = Math.max(mem[l][r][k], helper(boxes, l, i, k+1) + helper(boxes, i+1, r-1, 0));
            }
        }
        return mem[l][r][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
