//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters. 
//
// Example 1: 
//
// 
//Input:
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//Output: [0,9]
//Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
//The output order does not matter, returning [9,0] is fine too.
// 
//
// Example 2: 
//
// 
//Input:
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//Output: []
// 
// Related Topics Hash Table Two Pointers String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int wordNum = words.length;
        ArrayList<Integer> ans = new ArrayList<>();
        if (n==0 || wordNum==0) return ans;
        int wordLen = words[0].length();
        HashMap<String, Integer> ref = new HashMap<>();
        for (String word: words) ref.put(word, ref.getOrDefault(word, 0)+1);
        String word;

        for (int i=0; i<wordLen; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int k = i;
            if (k+wordLen*wordNum<=n){
                for (int j=0; j<wordNum; j++){
                    word = s.substring(k+j*wordLen,k+(j+1)*wordLen);
                    map.put(word, map.getOrDefault(word, 0)+1);
                }
                if (ref.equals(map)) ans.add(k);
            }
            while (k+wordLen*(wordNum+1)<=n){
                word = s.substring(k,k+wordLen);
                int cnt = map.get(word);
                if (cnt == 1) map.remove(word);
                else map.put(word, cnt-1);
                word = s.substring(k+wordLen*wordNum,k+wordLen*(wordNum+1));
                map.put(word, map.getOrDefault(word, 0)+1);
                k += wordLen;
                if (ref.equals(map)) ans.add(k);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
