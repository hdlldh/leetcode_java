//Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 
//
// Example: 
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 
//
// 
//Input: word1 = “coding”, word2 = “practice”
//Output: 3
// 
//
// 
//Input: word1 = "makes", word2 = "coding"
//Output: 1 
//
// Note: 
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list. 
// Related Topics Hash Table Design



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class WordDistance {
    HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i< words.length; i++){
            if (map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }
            else{
                ArrayList<Integer> t = new ArrayList<>();
                t.add(i);
                map.put(words[i], t);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        int m = l1.size();
        int n = l2.size();
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i<m && j<n){
            if (l1.get(i)>=l2.get(j)){
                ans = Math.min(ans, l1.get(i)-l2.get(j));
                j++;
            }else{
                ans = Math.min(ans, l2.get(j)-l1.get(i));
                i++;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)
