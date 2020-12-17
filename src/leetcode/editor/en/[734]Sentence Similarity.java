//Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar. 
//
// For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]. 
//
// Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar. 
//
// However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar. 
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
// Related Topics Hash Table


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        int n1 = words1.length;
        int n2 = words2.length;
        if (n1!=n2) return false;
        for (int i=0; i<pairs.size(); i++){
            String word1 = pairs.get(i).get(0);
            String word2 = pairs.get(i).get(1);
            HashSet<String> t = map.getOrDefault(word1, new HashSet<>());
            t.add(word2);
            map.put(word1, t);
            t = map.getOrDefault(word2, new HashSet<>());
            t.add(word1);
            map.put(word2, t);
        }
        for (int i=0; i<n1; i++){
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i])) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
