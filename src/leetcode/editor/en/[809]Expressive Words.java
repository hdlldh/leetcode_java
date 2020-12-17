//Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii". In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo". 
//
// For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more. 
//
// For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S. 
//
// Given a list of query words, return the number of words that are stretchy. 
//
// 
//
// 
//Example:
//Input: 
//S = "heeellooo"
//words = ["hello", "hi", "helo"]
//Output: 1
//Explanation: 
//We can extend "e" and "o" in the word "hello" to get "heeellooo".
//We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
// 
//
// 
//
// Notes: 
//
// 
// 0 <= len(S) <= 100. 
// 0 <= len(words) <= 100. 
// 0 <= len(words[i]) <= 100. 
// S and all words in words consist only of lowercase letters 
// 
//
// 
// Related Topics String

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Stats{
    ArrayList<Character> key;
    ArrayList<Integer> val;
}
class Solution {
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        Stats statsS = getStats(S);
        for (String word: words){
            Stats statsW = getStats(word);
            if (!statsS.key.equals(statsW.key)) continue;
            boolean match = true;
            for (int i=0; i<statsW.val.size(); i++){
                if (!(statsS.val.get(i)==statsW.val.get(i) || statsS.val.get(i)>=Math.max(statsW.val.get(i),3))){
                    match = false;
                    break;
                }
            }
            if (match) ans++;
        }
        return ans;
    }
    private Stats getStats(String word){
        Stats ans = new Stats();
        ans.key = new ArrayList<>();
        ans.val = new ArrayList<>();
        int start = 0;
        for (int i=0; i<word.length(); i++){
            if (i>0 && word.charAt(i)!=word.charAt(i-1)){
                ans.key.add(word.charAt(i-1));
                ans.val.add(i-start);
                start = i;
            }
        }
        ans.key.add(word.charAt(word.length()-1));
        ans.val.add(word.length()-start);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
