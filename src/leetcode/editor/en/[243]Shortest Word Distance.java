//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list. 
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
//
// Note: 
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list. 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int i = -1;
        int j = -1;
        int ans = Integer.MAX_VALUE;
        for (int ix=0; ix<n; ix++){
            if (words[ix].equals(word1)){
                if (j!=-1) ans = Math.min(ans, ix - j);
                i = ix;
            }
            else if (words[ix].equals(word2)){
                if (i!=-1) ans = Math.min(ans, ix - i);
                j = ix;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
