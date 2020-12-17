//Given many words, words[i] has weight i. 
//
// Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1. 
//
// Examples: 
//
// 
//Input:
//WordFilter(["apple"])
//WordFilter.f("a", "e") // returns 0
//WordFilter.f("b", "") // returns -1
// 
//
// 
//
// Note: 
//
// 
// words has length in range [1, 15000]. 
// For each test case, up to words.length queries WordFilter.f may be made. 
// words[i] has length in range [1, 10]. 
// prefix, suffix have lengths in range [0, 10]. 
// words[i] and prefix, suffix queries consist of lowercase letters only. 
// 
//
// 
// Related Topics Trie


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class WordFilter {
    HashMap<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int idx=0; idx<words.length; idx++){
            String word = words[idx];
            for (int i=0; i<=word.length(); i++){
                String prefix = word.substring(0,i);
                for (int j=0; j<=word.length(); j++){
                    String suffix = word.substring(j);
                    map.put(prefix+"_"+suffix, idx);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix+"_"+suffix, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
//leetcode submit region end(Prohibit modification and deletion)
