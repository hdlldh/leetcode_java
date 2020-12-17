//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time. 
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word. 
// 
//
// Note: 
//
// 
// Return 0 if there is no such transformation sequence. 
// All words have the same length. 
// All words contain only lowercase alphabetic characters. 
// You may assume no duplicates in the word list. 
// You may assume beginWord and endWord are non-empty and are not the same. 
// 
//
// Example 1: 
//
// 
//Input:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//Output: 5
//
//Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
// 
//
// Example 2: 
//
// 
//Input:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//Output: 0
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
// 
//
// 
// 
// Related Topics Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word: wordList) wordSet.add(word);
        if (wordSet.contains(endWord)) wordSet.remove(endWord);
        else return 0;
        if (wordSet.contains(beginWord)) wordSet.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        int wordLen = beginWord.length();
        queue.offer(beginWord);
        int ans = 1;
        while (!queue.isEmpty()){
            ans++;
            int qsize = queue.size();
            for (int i = 0; i<qsize; i++){
                String word1 = queue.poll();
                for (int j=0; j<wordLen; j++){
                    for (char ch ='a'; ch<='z'; ch++) {
                        if (ch==word1.charAt(j)) continue;
                        String word2 = word1.substring(0,j) + ch + word1.substring(j+1);
                        if (word2.equals(endWord)) return ans;
                        if (wordSet.contains(word2)){
                            queue.offer(word2);
                            wordSet.remove(word2);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
