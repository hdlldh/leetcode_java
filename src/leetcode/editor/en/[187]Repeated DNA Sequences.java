//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA. 
//
// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. 
//
// Example: 
//
// 
//Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//
//Output: ["AAAAACCCCC", "CCCCCAAAAA"]
// 
// Related Topics Hash Table Bit Manipulation

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length()<10) return ans;
        HashMap<String, Integer> seen = new HashMap<>();
        for (int i=0; i<s.length()-9; i++){
            String s1 = s.substring(i, i+10);
            if (!seen.containsKey(s1)) seen.put(s1, 1);
            else if (seen.get(s1)==1){
                ans.add(s1);
                seen.put(s1, 2);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
