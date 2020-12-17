//Given an unsorted array, find the maximum difference between the successive elements in its sorted form. 
//
// Return 0 if the array contains less than 2 elements. 
//
// Example 1: 
//
// 
//Input: [3,6,9,1]
//Output: 3
//Explanation: The sorted form of the array is [1,3,6,9], either
//             (3,6) or (6,9) has the maximum difference 3. 
//
// Example 2: 
//
// 
//Input: [10]
//Output: 0
//Explanation: The array contains less than 2 elements, therefore return 0. 
//
// Note: 
//
// 
// You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range. 
// Try to solve it in linear time/space. 
// 
// Related Topics Sort


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n<=1) return 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        int bkSize = (maxVal-minVal)/n+1;
        int bkNum = (maxVal-minVal)/bkSize+1;
        int[] bkMax = new int[bkNum];
        int[] bkMin = new int[bkNum];
        int ans = Integer.MIN_VALUE;
        HashSet<Integer> visited = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            int bkId = (nums[i]-minVal)/bkSize;
            if (visited.contains(bkId)){
                bkMax[bkId] = Math.max(bkMax[bkId], nums[i]);
                bkMin[bkId] = Math.min(bkMin[bkId], nums[i]);
            }else{
                bkMax[bkId] = nums[i];
                bkMin[bkId] = nums[i];
                visited.add(bkId);
            }
        }
        int pre = minVal;
        for (int i=0; i<bkNum; i++){
            if (!visited.contains(i)) continue;
            ans = Math.max(ans, bkMin[i]-pre);
            pre = bkMax[i];
        }
        return ans;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
