//Write a program to find the n-th ugly number. 
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
//
// Example: 
//
// 
//Input: n = 10
//Output: 12
//Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers. 
//
// Note: 
//
// 
// 1 is typically treated as an ugly number. 
// n does not exceed 1690. 
// Related Topics Math Dynamic Programming Heap


import java.util.HashSet;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        HashSet<Integer> visited = new HashSet<>();
        int[] plist = {2,3,5};
        int num=0;
        for (int i=0; i<n; i++){
            num = pq.poll();
            if (i==n-1) break;
            for (int p: plist){
                int q = p*num;
                if (!visited.contains(q) && num< Integer.MAX_VALUE/p){
                    pq.offer(q);
                    visited.add(q);
                }
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
