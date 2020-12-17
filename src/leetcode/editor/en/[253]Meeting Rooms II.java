//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required. 
//
// Example 1: 
//
// 
//Input: [[0, 30],[5, 10],[15, 20]]
//Output: 2 
//
// Example 2: 
//
// 
//Input: [[7,10],[2,4]]
//Output: 1 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature. 
// Related Topics Heap Greedy Sort


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int rooms = 0;
        Arrays.sort(intervals, (int[] x, int[] y)-> x[0]-y[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] x)->x[1]));
        for (int i=0; i<n; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <=intervals[i][0]){
                pq.poll();
            }
            pq.offer(intervals[i]);
            rooms = Math.max(rooms, pq.size());
        }
        return rooms;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
