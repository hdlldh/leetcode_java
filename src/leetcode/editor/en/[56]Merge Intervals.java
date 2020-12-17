//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
// Related Topics Array Sort



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n<=1) return intervals;
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);
        List<int[]> ans = new LinkedList<>();
        int i = 0;
        int j = 1;
        while (j<n){
            if (intervals[j][0] > intervals[i][1]){
                ans.add(intervals[i]);
                i = j;
            }
            else{
                intervals[i][1] = Math.max(intervals[i][1],intervals[j][1]);
            }
            j++;
        }
        ans.add(intervals[i]);
        int[][] ans1 = ans.toArray(new int[ans.size()][2]);
        return ans1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
