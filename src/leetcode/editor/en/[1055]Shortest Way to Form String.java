//From any string, we can form a subsequence of that string by deleting some num
//ber of characters (possibly no deletions). 
//
// Given two strings source and target, return the minimum number of subsequence
//s of source such that their concatenation equals target. If the task is impossib
//le, return -1. 
//
// 
//
// Example 1: 
//
// 
//Input: source = "abc", target = "abcbc"
//Output: 2
//Explanation: The target "abcbc" can be formed by "abc" and "bc", which are sub
//sequences of source "abc".
// 
//
// Example 2: 
//
// 
//Input: source = "abc", target = "acdbc"
//Output: -1
//Explanation: The target string cannot be constructed from the subsequences of 
//source string due to the character "d" in target string.
// 
//
// Example 3: 
//
// 
//Input: source = "xyz", target = "xzyxz"
//Output: 3
//Explanation: The target string can be constructed as follows "xz" + "y" + "xz"
//.
// 
// 
// Constraints: 
//
// 
// Both the source and target strings consist of only lowercase English letters 
//from "a"-"z". 
// The lengths of source and target string are between 1 and 1000. 
// Related Topics Dynamic Programming Greedy
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestWay(String source, String target) {
        char[] sc = source.toCharArray();
        char[] tc = target.toCharArray();
        List<Integer>[] mem = new List[26];
        for (int i=0; i<26; i++) mem[i] = new ArrayList<>();
        for (int i=0;i<sc.length; i++) mem[sc[i]-'a'].add(i);
        int i= 0;
        int j= 0;
        int ans =1;
        while (j<tc.length){
            List<Integer> tar = mem[tc[j]-'a'];
            if (tar.isEmpty()) return -1;
            int idx = Collections.binarySearch(tar, i);
            if (idx<0) idx = -idx -1;
            if (idx==tar.size()){
                i=0;
                ans++;
            }else{
                j++;
                i = tar.get(idx) + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
