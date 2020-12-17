//A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B). 
// 
//
// The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0. 
//
// For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] . 
//
// The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour. 
//
// For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]. 
//
// Notes: 
//
// 
// The number of buildings in any input list is guaranteed to be in the range [0, 10000]. 
// The input list is already sorted in ascending order by the left x position Li. 
// The output list must be sorted by the x position. 
// There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...] 
// 
// Related Topics Divide and Conquer Heap Binary Indexed Tree Segment Tree Line Sweep


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[][] events = new int[2*n][3];
        for (int i=0; i<n; i++){
            events[2*i][0] = buildings[i][0];
            events[2*i][1] = -buildings[i][2];
            events[2*i][2] = i;
            events[2*i+1][0] = buildings[i][1];
            events[2*i+1][1] = buildings[i][2];
            events[2*i+1][2] = i;
        }
        Arrays.sort(events, Comparator.comparing((int[] x)->x[0]).thenComparing((int[] x)->x[1]));
        TreeSet<int[]> tree = new TreeSet<>(Comparator.comparing((int[]x)->x[1]).thenComparing((int[] x)->x[0]));
        List<List<Integer>> ans = new ArrayList<>();
        int pre = 0;
        for (int i=0; i<2*n; i++){
            int[] t = new int[2];
            t[0] = events[i][2];
            if (events[i][1]<0){
                t[1] = -events[i][1];
                tree.add(t);
            }else{
                t[1] = events[i][1];
                tree.remove(t);
            }
            int cur;
            if (!tree.isEmpty()) cur = tree.last()[1];
            else cur = 0;
            if (cur!=pre){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(events[i][0]);
                tmp.add(cur);
                ans.add(tmp);
                pre = cur;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
