//You have some sticks with positive integer lengths. 
//
// You can connect any two sticks of lengths X and Y into one stick by paying a 
//cost of X + Y. You perform this action until there is one stick remaining. 
//
// Return the minimum cost of connecting all the given sticks into one stick in 
//this way. 
//
// 
// Example 1: 
// Input: sticks = [2,4,3]
//Output: 14
// Example 2: 
// Input: sticks = [1,8,3,5]
//Output: 30
// 
// 
// Constraints: 
//
// 
// 1 <= sticks.length <= 10^4 
// 1 <= sticks[i] <= 10^4 
// 
// Related Topics Greedy


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: sticks) pq.offer(num);
        int ans =0;
        while (pq.size()>1){
            int p = pq.poll();
            int q = pq.poll();
            ans += p+q;
            pq.offer(p+q);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
