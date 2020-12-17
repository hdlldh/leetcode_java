//Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges. 
//
// Example: 
//
// 
//Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
//Output: ["2", "4->49", "51->74", "76->99"]
// 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        ArrayList<String> ans = new ArrayList<>();

        if (lower == Integer.MAX_VALUE){
            return ans;
        }
        if (n==0){
            ans.add(getRanges(lower, upper));
            return ans;
        }

        if (lower != nums[0]) ans.add(getRanges(lower, nums[0]-1));

        for (int i=1; i<n; i++){
            if (nums[i] > nums[i-1]+1) ans.add(getRanges(nums[i-1]+1, nums[i]-1));
            if (nums[i] == Integer.MAX_VALUE) return ans;
        }

        if (upper != nums[n-1]) ans.add(getRanges(nums[n-1]+1, upper));
        return ans;
    }
    private String getRanges(int start, int end){
        String s = String.valueOf(start);
        if (start!=end){
            String e = String.valueOf(end);
            return s+"->"+e;
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
