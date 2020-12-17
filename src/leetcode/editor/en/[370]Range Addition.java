//Assume you have an array of length n initialized with all 0's and are given k update operations. 
//
// Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc. 
//
// Return the modified array after all k operations were executed. 
//
// Example: 
//
// 
//Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//Output: [-2,0,3,5,3]
// 
//
// Explanation: 
//
// 
//Initial state:
//[0,0,0,0,0]
//
//After applying operation [1,3,2]:
//[0,2,2,2,0]
//
//After applying operation [2,4,3]:
//[0,2,5,5,3]
//
//After applying operation [0,2,-2]:
//[-2,0,3,5,3]
// Related Topics Array


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int n = updates.length;
        int[] arr = new int[length+1];
        for (int i=0; i<length+1; i++) arr[0] = 0;
        if (n==0) return Arrays.copyOfRange(arr, 0, length);
        for (int i=0; i<n; i++){
            int start = updates[i][0];
            int end = updates[i][1];
            int val = updates[i][2];
            arr[start] += val;
            arr[end+1] -= val;
        }
        for (int i=1; i<length+1; i++){
            arr[i] += arr[i-1];
        }
        return Arrays.copyOfRange(arr, 0, length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
