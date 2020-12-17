//Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window. 
//
// Example: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
//Output: [3,3,5,5,6,7] 
//Explanation: 
//
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array. 
//
// Follow up: 
//Could you solve it in linear time? Related Topics Heap Sliding Window


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length-k+1];
        for (int i=0; i< nums.length; i++){
            if (!queue.isEmpty() && i-queue.peekFirst()==k) queue.poll();
            while (!queue.isEmpty() && nums[i]> nums[queue.peekLast()]) queue.removeLast();
            queue.addLast(i);
            if (i>=k-1) ans[i-k+1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
