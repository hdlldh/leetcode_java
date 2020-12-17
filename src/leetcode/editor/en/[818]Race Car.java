//Your car starts at position 0 and speed +1 on an infinite number line. (Your c
//ar can go into negative positions.) 
//
// Your car drives automatically according to a sequence of instructions A (acce
//lerate) and R (reverse). 
//
// When you get an instruction "A", your car does the following: position += spe
//ed, speed *= 2. 
//
// When you get an instruction "R", your car does the following: if your speed i
//s positive then speed = -1 , otherwise speed = 1. (Your position stays the same.
//) 
//
// For example, after commands "AAR", your car goes to positions 0->1->3->3, and
// your speed goes to 1->2->4->-1. 
//
// Now for some target position, say the length of the shortest sequence of inst
//ructions to get there. 
//
// 
//Example 1:
//Input: 
//target = 3
//Output: 2
//Explanation: 
//The shortest instruction sequence is "AA".
//Your position goes from 0->1->3.
// 
//
// 
//Example 2:
//Input: 
//target = 6
//Output: 5
//Explanation: 
//The shortest instruction sequence is "AAARA".
//Your position goes from 0->1->3->7->7->6.
// 
//
// 
//
// Note: 
//
// 
// 1 <= target <= 10000. 
// 
// Related Topics Dynamic Programming Heap


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target +1];

        for (int i=1;i<=target; i++){
            dp[i] = Integer.MAX_VALUE;
            int cnt1 = 1;
            int j=(1<<cnt1)-1;
            for (; j<i; j=(1<<++cnt1)-1){
                int cnt2 = 0;
                for (int k=0; k<j; k=(1<< ++cnt2)-1){
                    dp[i] = Math.min(dp[i], cnt1+1+cnt2+1+dp[i-j+k]);
                }
            }
            if (i==j) dp[i] =Math.min(dp[i], cnt1);
            if (j>i) dp[i] = Math.min(dp[i], cnt1+1+dp[j-i]);
        }
        return dp[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
