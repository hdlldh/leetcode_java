//Given a time represented in the format "HH:MM", form the next closest time by 
//reusing the current digits. There is no limit on how many times a digit can be r
//eused. 
//
// You may assume the given input string is always valid. For example, "01:34", 
//"12:09" are all valid. "1:34", "12:9" are all invalid. 
//
// Example 1:
// 
//Input: "19:34"
//Output: "19:39"
//Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, 
//which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and
// 59 minutes later.
// 
// 
//
// Example 2:
// 
//Input: "23:59"
//Output: "22:22"
//Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
//It may be assumed that the returned time is next day's time since it is smaller 
//than the input time numerically.
// 
// Related Topics String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int best_h;
    int best_m;
    int h0;
    int m0;
    public String nextClosestTime(String time) {
        HashSet<Integer> nums = new HashSet<>();
        for (int i: new int[]{0, 1, 3, 4})
            nums.add(time.charAt(i)-'0');

        h0 = Integer.valueOf(time.substring(0,2));
        m0 = Integer.valueOf(time.substring(3));
        best_h = h0;
        best_m = m0;
        ArrayList<Integer> cur = new ArrayList<>();
        dfs(cur, nums);
        return String.format("%02d:%02d", best_h, best_m);
    }

    private void dfs(ArrayList<Integer> cur, HashSet<Integer> nums){
        if (cur.size()==4){
            int h = cur.get(0)*10+cur.get(1);
            int m = cur.get(2)*10+cur.get(3);
            if (h>23 || m>59) return;
            if (timeDiff(h,m, h0, m0)<timeDiff(best_h, best_m, h0, m0)){
                best_h = h;
                best_m = m;
            }
            return;
        }
        for (int num: nums){
            cur.add(num);
            dfs(cur, nums);
            cur.remove(cur.size()-1);
        }
    }

    private int timeDiff(int h1, int m1, int h0, int m0){
        if (h1==h0 && m1==m0) return 24*60;
        return (h1*60+m1-h0*60-m0+24*60) % (24*60);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
