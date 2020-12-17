//Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points. 
//
// Example 1: 
//
// 
//Input: [[1,1],[-1,1]]
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: [[1,1],[-1,-1]]
//Output: false 
// 
//
// Follow up: 
//Could you do better than O(n2) ? Related Topics Hash Table Math



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public boolean isReflected(int[][] points) {
        int n = points.length;
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i=0; i<n; i++){
            xmin = Math.min(xmin, points[i][0]);
            xmax = Math.max(xmax, points[i][0]);
            ArrayList<Integer> t = new ArrayList<>();
            t.add(points[i][0]);
            t.add(points[i][1]);
            set.add(t);
        }
        for (int i=0; i<n; i++) {
            int xr = xmin+xmax-points[i][0];
            ArrayList<Integer> t = new ArrayList<>();
            t.add(xr);
            t.add(points[i][1]);
            if (!set.contains(t)) return false;
        }
        return true;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
