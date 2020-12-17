//Given the coordinates of four points in 2D space, return whether the four poin
//ts could construct a square. 
//
// The coordinate (x,y) of a point is represented by an integer array with two i
//ntegers. 
//
// Example: 
//
// 
//Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//Output: True
// 
//
// 
//
// Note: 
//
// 
// All the input integers are in the range [-10000, 10000]. 
// A valid square has four equal sides with positive length and four equal angle
//s (90-degree angles). 
// Input points have no order. 
// 
//
// 
// Related Topics Math


import sun.font.TrueTypeFont;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[4][2];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        int[] d = new int[6];
        int k=0;
        for (int i=0;i<4;i++){
            for (int j=i+1; j<4;j++){
                d[k++] = distance(points[i], points[j]);
            }
        }
        Arrays.sort(d);
        if (d[0]!=0 && d[0]==d[1] && d[1]==d[2] && d[2]==d[3] && d[4]==d[5]) return true;
        return false;

    }
    private int distance(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
