//Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list. 
//
// Example 1: 
// 
//Input: ["23:59","00:00"]
//Output: 1
// 
// 
//
// Note: 
// 
// The number of time points in the given list is at least 2 and won't exceed 20000. 
// The input time is legal and ranges from 00:00 to 23:59. 
// 
// Related Topics String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int n = timePoints.size();
        int ans = Integer.MAX_VALUE;
        int gap;
        for (int i=1; i<n; i++){
            gap = findGap(timePoints.get(i-1), timePoints.get(i));
            ans = Math.min(ans, gap);
        }
        gap = findGap(timePoints.get(0), timePoints.get(n-1));
        ans = Math.min(ans, 24*60-gap);
        return ans;
    }
    private int findGap(String x, String y){
        int h1 = Integer.parseInt(x.substring(0,2));
        int m1 = Integer.parseInt(x.substring(3));
        int h2 = Integer.parseInt(y.substring(0,2));
        int m2 = Integer.parseInt(y.substring(3));
        return (h2-h1)*60+m2-m1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
