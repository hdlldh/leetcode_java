//Given an unsorted array of integers, find the length of the longest consecutive elements sequence. 
//
// Your algorithm should run in O(n) complexity. 
//
// Example: 
//
// 
//Input: [100, 4, 200, 1, 3, 2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// 
// Related Topics Array Union Find


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num: nums) set.add(num);
        HashSet<Integer> visited = new HashSet<>();
        for (int num: nums){
            if (visited.contains(num)) continue;
            visited.add(num);
            int size = 1;
            int left = num;
            while (set.contains(left-1)){
                left--;
                visited.add(left);
                size++;
            }
            int right = num;
            while (set.contains(right+1)){
                right++;
                visited.add(right);
                size++;
            }
            ans = Math.max(ans, size);

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
