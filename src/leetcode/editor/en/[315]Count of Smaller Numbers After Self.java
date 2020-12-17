//You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i]. 
//
// Example: 
//
// 
//Input: [5,2,6,1]
//Output: [2,1,1,0] 
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// Related Topics Binary Search Divide and Conquer Sort Binary Indexed Tree Segment Tree



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n==0) return ans;
        ans.add(0);
        if (n==1) return ans;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[n-1]);
        for (int i=n-2; i>=0; i--){
            int k = arr.size();
            int low = 0;
            int high = k-1;
            while (low<=high){
                int mid = low + (high-low)/2;
                if (arr.get(mid)>=nums[i]) high = mid -1;
                else low = mid+1;
            }
            arr.add(low, nums[i]);
            ans.add(0,low);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
