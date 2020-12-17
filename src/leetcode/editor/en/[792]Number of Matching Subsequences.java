//Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S. 
//
// 
//Example :
//Input: 
//S = "abcde"
//words = ["a", "bb", "acd", "ace"]
//Output: 3
//Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
// 
//
// Note: 
//
// 
// All words in words and S will only consists of lowercase letters. 
// The length of S will be in the range of [1, 50000]. 
// The length of words will be in the range of [1, 5000]. 
// The length of words[i] will be in the range of [1, 50]. 
// 
// Related Topics Array


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Character, ArrayList<Integer>> mem = new HashMap<>();
        for (int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            mem.putIfAbsent(ch, new ArrayList<>());
            ArrayList<Integer> t = mem.get(ch);
            t.add(i);
        }
        int ans = 0;
        for (String word: words){
            int prev = -1;
            for (int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                if (!mem.containsKey(ch)) break;
                int pos = Collections.binarySearch(mem.get(ch), prev+1);
                if (pos<0) pos = -pos-1;
                if (pos==mem.get(ch).size()) break;
                prev = mem.get(ch).get(pos);
                if (i==word.length()-1) ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
