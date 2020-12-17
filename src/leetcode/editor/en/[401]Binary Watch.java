//A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59). 
// Each LED represents a zero or one, with the least significant bit on the right. 
//
// For example, the above binary watch reads "3:25". 
//
// Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent. 
//
// Example:
// Input: n = 1 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"] 
// 
//
// Note: 
// 
// The order of output does not matter. 
// The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00". 
// The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02". 
// 
// Related Topics Backtracking Bit Manipulation


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for (int h=0; h<12; h++){
            for (int m=0; m<60; m++){
                int cnt = countDigits(h)+ countDigits(m);
                if (cnt!=num) continue;
                String rst = h+":";
                if (m<10) rst += "0";
                rst += m;
                ans.add(rst);
            }
        }
        return ans;
    }
    private int countDigits(int n){
        int ans = 0;
        while (n>0){
            if ((n&1)==1) ans++;
            n>>=1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
