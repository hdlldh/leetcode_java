//Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value. 
//Examples: 
// [2,3,4] , the median is 3 
// [2,3], the median is (2 + 3) / 2 = 2.5 
//
// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array. 
//
// For example, 
//Given nums = [1,3,-1,-3,5,3,6,7], and k = 3. 
//
// 
//Window position                Median
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7       -1
// 1  3 [-1  -3  5] 3  6  7       -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// Therefore, return the median sliding window as [1,-1,-1,3,5,6]. 
//
// Note: 
//You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array. Related Topics Sliding Window

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        ArrayList<Long> window = new ArrayList<>();
        for (int i=0; i<k-1; i++) window.add(Long.valueOf(nums[i]));
        Collections.sort(window);
        int n = nums.length;
        ArrayList<Double> ans = new ArrayList<>();
        for (int i=k-1; i<n; i++){
            int pos = Collections.binarySearch(window,Long.valueOf(nums[i]));
            if (pos<0) pos = -pos -1;
            window.add(pos, Long.valueOf(nums[i]));
            ans.add((window.get(k/2)+window.get((k-1)/2))*0.5);
            pos = Collections.binarySearch(window, Long.valueOf(nums[i-k+1]));
            window.remove(pos);
        }
        double[] ans1 = new double[ans.size()];
        for (int i=0; i<ans.size(); i++) ans1[i] = ans.get(i);
        return ans1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
