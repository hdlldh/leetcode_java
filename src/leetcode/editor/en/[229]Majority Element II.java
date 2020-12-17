//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
//
// Note: The algorithm should run in linear time and in O(1) space. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: [3] 
//
// Example 2: 
//
// 
//Input: [1,1,1,3,3,2,2,2]
//Output: [1,2] 
// Related Topics Array


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Integer n1 = null;
        int c1 = 0;
        Integer n2 = null;
        int c2 = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num: nums){
            if (n1!= null && num == n1) c1++;
            else if (n2!=null && num == n2) c2++;
            else if (c1 == 0){
                n1 = num;
                c1 = 1;
            }
            else if (c2 == 0){
                n2 = num;
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num: nums){
            if (num == n1) c1++;
            else if (num == n2) c2++;
        }
        if (c1>n/3) ans.add(n1);
        if (c2>n/3) ans.add(n2);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
