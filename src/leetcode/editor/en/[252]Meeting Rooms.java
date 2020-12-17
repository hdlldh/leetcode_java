//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings. 
//
// Example 1: 
//
// 
//Input: [[0,30],[5,10],[15,20]]
//Output: false
// 
//
// Example 2: 
//
// 
//Input: [[7,10],[2,4]]
//Output: true
// 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
// Related Topics Sort


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (x, y)->x[0]-y[0]);
        for (int i =1; i<n; i++){
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
