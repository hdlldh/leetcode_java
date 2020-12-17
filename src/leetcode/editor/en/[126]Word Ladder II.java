//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that: 
//
// 
// Only one letter can be changed at a time 
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word. 
// 
//
// Note: 
//
// 
// Return an empty list if there is no such transformation sequence. 
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
//Output:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
//Output: []
//
//Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
// 
//
// 
// 
// Related Topics Array String Backtracking Breadth-first Search


import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String word: wordList) wordSet.add(word);
        if (wordSet.contains(endWord)) wordSet.remove(endWord);
        else return ans;
        int wordLen = beginWord.length();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> arr = new ArrayList<>();
        arr.add(beginWord);
        queue.offer(arr);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found){
            int qSize = queue.size();
            HashSet<String> visited2 = new HashSet<>();
            for (int i=0; i<qSize; i++){
                ArrayList<String> list1 = queue.poll();
                String word1 = list1.get(list1.size()-1);
                for (int j=0; j<wordLen; j++){
                    for (char ch='a'; ch<='z'; ch++){
                        if (ch==word1.charAt(j)) continue;
                        String word2 = word1.substring(0,j)+ch+word1.substring(j+1);
                        if (word2.equals(endWord)){
                            found = true;
                            ArrayList<String> list2 = new ArrayList<>(list1);
                            list2.add(endWord);
                            ans.add(list2);
                        }else if (wordSet.contains(word2) && !visited.contains(word2)){
                            ArrayList<String> list2 = new ArrayList<>(list1);
                            list2.add(word2);
                            queue.offer(list2);
                            visited2.add(word2);
                        }
                    }
                }
            }
            for (String word: visited2) visited.add(word);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
