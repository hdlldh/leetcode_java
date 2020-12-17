//Given an integer array sorted in ascending order, write a function to search t
//arget in nums. If target exists, then return its index, otherwise return -1. How
//ever, the array size is unknown to you. You may only access the array using an A
//rrayReader interface, where ArrayReader.get(k) returns the element of the array 
//at index k (0-indexed). 
//
// You may assume all integers in the array are less than 10000, and if you acce
//ss the array out of bounds, ArrayReader.get will return 2147483647. 
//
// 
//
// Example 1: 
//
// 
//Input: array = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: array = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1 
//
// 
//
// Note: 
//
// 
// You may assume that all elements in the array are unique. 
// The value of each element in the array will be in the range [-9999, 9999]. 
// 
// Related Topics Binary Search




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 10000;
        int invalid = 2147483647;
        while (low<=high){
            int mid = low + (high-low)/2;
            int t = reader.get(mid);
            if (t==invalid || t>target) high = mid -1;
            else if (t<target) low = mid +1;
            else return mid;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
