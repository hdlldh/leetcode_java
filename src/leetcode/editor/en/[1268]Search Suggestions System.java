//Given an array of strings products and a string searchWord. We want to design 
//a system that suggests at most three product names from products after each char
//acter of searchWord is typed. Suggested products should have common prefix with 
//the searchWord. If there are more than three products with a common prefix retur
//n the three lexicographically minimums products. 
//
// Return list of lists of the suggested products after each character of search
//Word is typed. 
//
// 
// Example 1: 
//
// 
//Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWo
//rd = "mouse"
//Output: [
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//Explanation: products sorted lexicographically = ["mobile","moneypot","monitor
//","mouse","mousepad"]
//After typing m and mo all products match and we show user ["mobile","moneypot"
//,"monitor"]
//After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
// 
//
// Example 2: 
//
// 
//Input: products = ["havana"], searchWord = "havana"
//Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// Example 3: 
//
// 
//Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "ba
//gs"
//Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","b
//ags"],["bags"]]
// 
//
// Example 4: 
//
// 
//Input: products = ["havana"], searchWord = "tatiana"
//Output: [[],[],[],[],[],[],[]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= products.length <= 1000 
// There are no repeated elements in products. 
// 1 <= Σ products[i].length <= 2 * 10^4 
// All characters of products[i] are lower-case English letters. 
// 1 <= searchWord.length <= 1000 
// All characters of searchWord are lower-case English letters. 
// 
// Related Topics String


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        HashMap<String, ArrayList<String>> mem = new HashMap<>();
        for (String word: products){
            for (int i=1; i<=word.length(); i++){
                String w = word.substring(0, i);
                mem.putIfAbsent(w, new ArrayList<>());
                ArrayList<String> t = mem.get(w);
                t.add(word);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i=1; i<=searchWord.length(); i++){
            String w = searchWord.substring(0, i);
            if (!mem.containsKey(w)) ans.add(new ArrayList<>());
            else{
                ArrayList<String> t = mem.get(w);
                Collections.sort(t);
                if (t.size()>3) ans.add(t.subList(0,3));
                else ans.add(t);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
