//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9] 
// 
//
// Note: 
//
// 
// Each element in the result should appear as many times as it shows in both arrays. 
// The result can be in any order. 
// 
//
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your algorithm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is better? 
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once? 
// 
// Related Topics Hash Table Two Pointers Binary Search Sort



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num: nums1){
            if (hmap.containsKey(num)) hmap.put(num, hmap.get(num)+1);
            else hmap.put(num, 1);
        }
        for (int num: nums2){
            if (hmap.containsKey(num) && hmap.get(num)>=1){
                ans.add(num);
                hmap.put(num, hmap.get(num)-1);
            }
        }
        int[] ans2 = new int[ans.size()];
        int i = 0;
        for(int num: ans) ans2[i++] = num;
        return ans2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
