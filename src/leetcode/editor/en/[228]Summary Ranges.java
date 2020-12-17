//Given a sorted integer array without duplicates, return the summary of its ranges. 
//
// Example 1: 
//
// 
//Input:  [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]
//Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
// 
//
// Example 2: 
//
// 
//Input:  [0,2,3,4,6,8,9]
//Output: ["0","2->4","6","8->9"]
//Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
// 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        ArrayList<String> ans = new ArrayList<>();
        if (n==0) return ans;
        int i = 0;
        int j = 1;
        while (j<n){
            if (nums[j]!=nums[j-1]+1){
                ans.add(summarize(nums, i, j-1));
                i = j;
            }
            j++;
        }
        ans.add(summarize(nums, i, n-1));
        return ans;
    }
    private String summarize(int[] nums, int i, int j){
        String start = Integer.toString(nums[i]);
        if (i!=j){
            String end = Integer.toString(nums[j]);
            StringBuilder t = new StringBuilder().append(start+"->"+end);
            return t.toString();
        }
        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
