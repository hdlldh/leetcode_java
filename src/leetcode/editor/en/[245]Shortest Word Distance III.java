//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list. 
//
// word1 and word2 may be the same and they represent two individual words in the list. 
//
// Example: 
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 
//
// 
//Input: word1 = “makes”, word2 = “coding”
//Output: 1
// 
//
// 
//Input: word1 = "makes", word2 = "makes"
//Output: 3
// 
//
// Note: 
//You may assume word1 and word2 are both in the list. 
// Related Topics Array



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int i = -1;
        int j;
        int ans = Integer.MAX_VALUE;
        if (word1.equals(word2)){
            j = 0;
            while (j<n){
                if (words[j].equals(word1)){
                    if (i!=-1) ans = Math.min(ans, j-i);
                    i = j;
                }
                j++;
            }
        }else{
            int k = 0;
            j = -1;
            while (k<n){
                if (words[k].equals(word1)){
                    if (j!=-1) ans = Math.min(ans, k-j);
                    i = k;
                }
                if (words[k].equals(word2)){
                    if (i!=-1) ans = Math.min(ans,k-i);
                    j = k;
                }
                k++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
