//Given N axis-aligned rectangles where N > 0, determine if they all together fo
//rm an exact cover of a rectangular region. 
//
// Each rectangle is represented as a bottom-left point and a top-right point. F
//or example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-lef
//t point is (1, 1) and top-right point is (2, 2)). 
//
// 
//
// Example 1: 
//
// 
//rectangles = [
//  [1,1,3,3],
//  [3,1,4,2],
//  [3,2,4,4],
//  [1,3,2,4],
//  [2,3,3,4]
//]
//
//Return true. All 5 rectangles together form an exact cover of a rectangular re
//gion.
// 
//
// 
//
// 
//
// 
//
// Example 2: 
//
// 
//rectangles = [
//  [1,1,2,3],
//  [1,3,2,4],
//  [3,1,4,2],
//  [3,2,4,4]
//]
//
//Return false. Because there is a gap between the two rectangular regions.
// 
//
// 
//
// 
//
// 
//
// Example 3: 
//
// 
//rectangles = [
//  [1,1,3,3],
//  [3,1,4,2],
//  [1,3,2,4],
//  [3,2,4,4]
//]
//
//Return false. Because there is a gap in the top center.
// 
//
// 
//
// 
//
// 
//
// Example 4: 
//
// 
//rectangles = [
//  [1,1,3,3],
//  [3,1,4,2],
//  [1,3,2,4],
//  [2,2,4,4]
//]
//
//Return false. Because two of the rectangles overlap with each other.
// 
//
// Related Topics Line Sweep


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        HashMap<Integer, HashMap<Integer, Integer>>  hmap = new HashMap<>();
        int area = 0;
        for (int[] rect: rectangles){
            int bx = rect[0];
            int by = rect[1];
            int tx = rect[2];
            int ty = rect[3];
            area += (tx-bx)*(ty-by);
            hmap.putIfAbsent(bx, new HashMap<>());
            hmap.putIfAbsent(tx, new HashMap<>());
            HashMap<Integer, Integer> t = hmap.get(bx);
            t.put(by, t.getOrDefault(by, 0)+1);
            t.put(ty, t.getOrDefault(ty, 0)+1);
            t = hmap.get(tx);
            t.put(by, t.getOrDefault(by, 0)+1);
            t.put(ty, t.getOrDefault(ty, 0)+1);
        }
        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;
        int count = 0;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> u: hmap.entrySet()){
            x_min = Math.min(x_min, u.getKey());
            x_max = Math.max(x_max, u.getKey());
            for (Map.Entry<Integer, Integer> v: u.getValue().entrySet()){
                if (v.getValue()==1){
                    count++;
                    y_min = Math.min(y_min, v.getKey());
                    y_max = Math.max(y_max, v.getKey());
                }else if (v.getValue()%2==1) return false;
            }
        }
        return count==4 && area == (x_max-x_min)*(y_max-y_min);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
