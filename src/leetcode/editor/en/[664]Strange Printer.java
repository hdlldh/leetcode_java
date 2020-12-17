//
//There is a strange printer with the following two special requirements:
//
// 
// The printer can only print a sequence of the same character each time. 
// At each turn, the printer can print new characters starting from and ending a
//t any places, and will cover the original existing characters. 
// 
//
// 
//
// 
//Given a string consists of lower English letters only, your job is to count th
//e minimum number of turns the printer needed in order to print it.
// 
//
// Example 1: 
// 
//Input: "aaabbb"
//Output: 2
//Explanation: Print "aaa" first and then print "bbb".
// 
// 
//
// Example 2: 
// 
//Input: "aba"
//Output: 2
//Explanation: Print "aaa" first and then print "b" from the second place of the
// string, which will cover the existing character 'a'.
// 
// 
//
// Hint: Length of the given string will not exceed 100. Related Topics Dynamic 
//Programming Depth-first Search


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strangePrinter(String s) {
        HashMap<String, Integer> mem = new HashMap<>();
        return helper(s, mem);
    }
    private int helper(String s, HashMap<String, Integer> mem){
        if (mem.containsKey(s)) return mem.get(s);
        int n = s.length();
        if (n<=1){
            mem.put(s, n);
            return n;
        }
        int ans = helper(s.substring(0, n-1), mem) +1;
        for (int i=0; i<n-1; i++){
            if (s.charAt(i)==s.charAt(n-1)){
                ans = Math.min(ans, helper(s.substring(0, i+1), mem) + helper(s.substring(i+1,n-1), mem));
            }
        }
        mem.put(s, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
