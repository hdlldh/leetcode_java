//Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar. 
//
// For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]]. 
//
// Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar. 
//
// Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar. 
//
// Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs. 
//
// Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"]. 
//
// Note: 
//
// 
// The length of words1 and words2 will not exceed 1000. 
// The length of pairs will not exceed 2000. 
// The length of each pairs[i] will be 2. 
// The length of each words[i] and pairs[i][j] will be in the range [1, 20]. 
// 
//
// 
// Related Topics Depth-first Search Union Find

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        int n1 = words1.length;
        int n2 = words2.length;
        if (n1!=n2) return false;
        HashMap<String, Integer> index = new HashMap<>();
        for (int i=0; i<pairs.size(); i++){
            String word1 = pairs.get(i).get(0);
            String word2 = pairs.get(i).get(1);
            if (!index.containsKey(word1)) index.put(word1, index.size());
            if (!index.containsKey(word2)) index.put(word2, index.size());
        }
        int[] roots = new int[index.size()];
        for (int i=0; i<index.size(); i++) roots[i] = i;
        for (int i=0; i<pairs.size(); i++){
            int pi = index.get(pairs.get(i).get(0));
            int qi = index.get(pairs.get(i).get(1));
            union(roots, pi, qi);
        }
        for (int i=0; i<n1; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) continue;
            if (!index.containsKey(word1) || ! index.containsKey(word2)) return false;
            if (find(roots, index.get(word1)) != find(roots, index.get(word2))) return false;
        }
        return true;
    }
    private int find(int[] roots, int p){
        while (p!=roots[p]) p = roots[p];
        return p;
    }
    private void union(int[] roots, int p, int q){
        int root_p = find(roots, p);
        int root_q = find(roots, q);
        roots[root_q] = root_p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
