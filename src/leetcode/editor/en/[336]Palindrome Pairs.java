//Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome. 
//
// Example 1: 
//
// 
// 
//Input: ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]] 
//Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["bat","tab","cat"]
//Output: [[0,1],[1,0]] 
//Explanation: The palindromes are ["battab","tabbat"]
// 
// 
// 
// Related Topics Hash Table String Trie



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<n; i++){
            map.put(words[i], i);
        }

        for (int i=0; i<n; i++){
            String word = words[i];
            for (int j=0; j<=word.length(); j++){
                String left = word.substring(0,j);
                String right = word.substring(j);
                if (isPalindrome(left)){
                    String rightRev = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightRev) && map.get(rightRev)!=i){
                        ArrayList<Integer> rst = new ArrayList<>();
                        rst.add(map.get(rightRev));
                        rst.add(i);
                        ans.add(rst);
                    }
                }
                if (isPalindrome(right)){
                    String leftRev = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftRev) && map.get(leftRev)!=i && right.length()!=0){
                        ArrayList<Integer> rst = new ArrayList<>();
                        rst.add(i);
                        rst.add(map.get(leftRev));
                        ans.add(rst);
                    }
                }
            }
        }
        return ans;

    }

    private boolean isPalindrome(String word){
        int n = word.length();
        int i = 0;
        int j = n-1;
        while (i<j){
            if (word.charAt(i)!=word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
