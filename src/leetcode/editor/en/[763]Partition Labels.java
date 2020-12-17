//
//A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
// 
//
// Example 1: 
// 
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
// 
// 
//
// Note: 
// S will have length in range [1, 500]. 
// S will consist of lowercase letters ('a' to 'z') only. 
// Related Topics Two Pointers Greedy



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        int idx = 0;
        for (char ch: S.toCharArray()){
            if (hmap.containsKey(ch)){
                int i = hmap.get(ch);
                intervals.get(i)[1] = idx;
            }
            else{
                hmap.put(ch, n);
                int[] t = {idx, idx};
                intervals.add(t);
                n++;
            }
            idx++;
        }
        int i = 0;
        int j = 1;
        while (j<n){
            if (intervals.get(j)[0] > intervals.get(i)[1]){
                ans.add(intervals.get(i)[1] - intervals.get(i)[0] + 1);
                i = j;
            }else{
                intervals.get(i)[1] = Math.max(intervals.get(i)[1], intervals.get(j)[1]);
            }
            j++;
        }
        ans.add(intervals.get(i)[1] - intervals.get(i)[0] + 1);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
