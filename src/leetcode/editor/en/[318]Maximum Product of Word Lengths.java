//Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0. 
//
// Example 1: 
//
// 
//Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
//Output: 16 
//Explanation: The two words can be "abcw", "xtfn". 
//
// Example 2: 
//
// 
//Input: ["a","ab","abc","d","cd","bcd","abcd"]
//Output: 4 
//Explanation: The two words can be "ab", "cd". 
//
// Example 3: 
//
// 
//Input: ["a","aa","aaa","aaaa"]
//Output: 0 
//Explanation: No such pair of words.
// 
// Related Topics Bit Manipulation



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int ans = 0;
        for (int i=0; i<n; i++){
            for (int k=0; k<words[i].length(); k++){
                mask[i] |= 1<<(words[i].charAt(k)-'a');
            }
            for (int j=0; j<i; j++){
                if ((mask[j] & mask[i])==0){
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
